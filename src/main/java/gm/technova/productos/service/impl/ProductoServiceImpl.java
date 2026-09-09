package gm.technova.productos.service.impl;

import gm.technova.productos.Entity.Producto;

import gm.technova.productos.dto.ProductoAdminDTO;
import gm.technova.productos.dto.ProductoDetalleDTO;
import gm.technova.productos.dto.ProductopresentacionDTO;
import gm.technova.productos.mapper.ProductoMapper;
import gm.technova.productos.repository.ProductoRepository;
import gm.technova.productos.repository.CategoriaRepository;
import gm.technova.productos.service.ProductoService;
import gm.technova.productos.service.MovimientoInventarioService;
import gm.technova.productos.dto.request.MovimientoInventarioRequestDTO;
import gm.technova.productos.dto.request.ProductoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MovimientoInventarioService movimientoInventarioService;

    /* =========================
       MÉTODOS BÁSICOS
    ========================= */

    @Override
    public Page<Producto> listar(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto guardar(ProductoRequestDTO request) {
        Producto producto = new Producto();

        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setDescripcion(request.getDescripcion());
        producto.setModelo(request.getModelo());
        producto.setGarantia(request.getGarantia());
        producto.setMarca(request.getMarca());

        if (request.getCategoriaId() != null) {
            producto.setCategoria(categoriaRepository.findById(request.getCategoriaId()).orElse(null));
        }

        Producto guardado = repository.save(producto);

        if (producto.getStock() != null && producto.getStock() > 0) {
            try {
                MovimientoInventarioRequestDTO mov = new MovimientoInventarioRequestDTO();
                mov.setProductoId(guardado.getIdProducto());
                mov.setTipo("entrada");
                mov.setCantidad(producto.getStock());
                mov.setMotivo("Carga inicial");
                mov.setUsuarioId(1);
                movimientoInventarioService.registrar(mov);
            } catch (Exception e) {
                System.err.println("Error creating initial stock movement: " + e.getMessage());
            }
        }

        return guardado;
    }

    @Override
    @Transactional
    public Producto actualizar(Long id, ProductoRequestDTO request) {
        Producto existente = repository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNombre(request.getNombre());
            existente.setPrecio(request.getPrecio());
            existente.setStock(request.getStock());
            existente.setDescripcion(request.getDescripcion());
            existente.setModelo(request.getModelo());
            existente.setGarantia(request.getGarantia());
            existente.setMarca(request.getMarca());

            if (request.getCategoriaId() != null) {
                existente.setCategoria(categoriaRepository.findById(request.getCategoriaId()).orElse(null));
            }

            return repository.save(existente);
        }

        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    /* =========================
       MÉTODOS AVANZADOS
    ========================= */

    @Override
    public ProductoDetalleDTO obtenerDetalle(Long id) {
        Producto producto = repository.obtenerProductoDetalle(id);
        return ProductoMapper.toDetalleDTO(producto);
    }

    @Override
    public Page<Producto> listarPorCategoria(Long idCategoria, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByCategoriaIdCategoria(idCategoria, pageable);
    }

    @Override
    public Page<ProductopresentacionDTO> listarProductosPresentacion(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.obtenerProductosPresentacion(pageable);
    }

    @Override
    public Page<ProductopresentacionDTO> filtrarProductos(
            String categoria, String marca, Double minPrecio, Double maxPrecio, String nombre, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.filtrarProductos(categoria, marca, minPrecio, maxPrecio, nombre, pageable)
                .map(ProductoMapper::toPresentacionDTO);
    }

    @Override
    public Page<String> listarMarcas(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.obtenerMarcas(pageable);
    }

    @Override
    public Page<ProductoAdminDTO> filtrarProductosAdmin(
            String categoria, String marca, Double minPrecio, Double maxPrecio, String nombre, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.filtrarProductos(categoria, marca, minPrecio, maxPrecio, nombre, pageable)
                .map(ProductoMapper::toAdminDTO);
    }
}
