package gm.technova.productos.service.impl;

import gm.technova.productos.Entity.MovimientoInventario;
import gm.technova.productos.Entity.Producto;
import gm.technova.productos.dto.request.MovimientoInventarioRequestDTO;
import gm.technova.productos.dto.response.MovimientoInventarioResponseDTO;
import gm.technova.productos.exception.StockInsuficienteException;
import gm.technova.productos.mapper.MovimientoInventarioMapper;
import gm.technova.productos.repository.MovimientoInventarioRepository;
import gm.technova.productos.repository.ProductoRepository;
import gm.technova.productos.service.MovimientoInventarioService;
import gm.technova.usuario.entity.Usuario;
import gm.technova.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {

    private final MovimientoInventarioRepository movimientoInventarioRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final MovimientoInventarioMapper mapper;

    public MovimientoInventarioServiceImpl(MovimientoInventarioRepository movimientoInventarioRepository,
                                           ProductoRepository productoRepository,
                                           UsuarioRepository usuarioRepository,
                                           MovimientoInventarioMapper mapper) {
        this.movimientoInventarioRepository = movimientoInventarioRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public MovimientoInventarioResponseDTO registrar(MovimientoInventarioRequestDTO dto) {
        Producto producto = productoRepository.findById(dto.getProductoId())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con id " + dto.getProductoId()));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id " + dto.getUsuarioId()));

        int stockActual = producto.getStock();
        int nuevoStock;

        switch (dto.getTipo()) {
            case "entrada" -> nuevoStock = stockActual + dto.getCantidad();
            case "salida" -> {
                if (dto.getCantidad() > stockActual) {
                    throw new StockInsuficienteException(
                            "No hay stock suficiente. Disponible: " + stockActual + ", solicitado: " + dto.getCantidad());
                }
                nuevoStock = stockActual - dto.getCantidad();
            }
            case "ajuste" -> nuevoStock = dto.getCantidad();
            default -> throw new IllegalArgumentException("Tipo de movimiento inválido: " + dto.getTipo());
        }

        producto.setStock(nuevoStock);
        productoRepository.save(producto);

        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setProducto(producto);
        movimiento.setUsuario(usuario);
        movimiento.setTipo(dto.getTipo());
        movimiento.setCantidad(dto.getCantidad());
        movimiento.setStockResultante(nuevoStock);
        movimiento.setMotivo(dto.getMotivo());
        movimiento.setFecha(LocalDateTime.now());

        return mapper.toResponseDTO(movimientoInventarioRepository.save(movimiento));
    }

    @Override
    public List<MovimientoInventarioResponseDTO> listarTodos() {
        return movimientoInventarioRepository.findAllByOrderByFechaDesc()
                .stream().map(mapper::toResponseDTO).toList();
    }

    @Override
    public List<MovimientoInventarioResponseDTO> listarPorProducto(Long productoId) {
        return movimientoInventarioRepository.findByProductoIdProductoOrderByFechaDesc(productoId)
                .stream().map(mapper::toResponseDTO).toList();
    }
}