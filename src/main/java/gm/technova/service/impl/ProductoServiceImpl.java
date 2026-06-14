package gm.technova.service.impl;

import gm.technova.Entity.Producto;
import gm.technova.dto.ProductoDetalleDTO;
import gm.technova.dto.ProductopresentacionDTO;
import gm.technova.mapper.ProductoMapper;
import gm.technova.repository.ProductoRepository;
import gm.technova.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

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
    public Producto guardar(Producto producto) {

        return repository.save(producto);
    }

    @Override
    public Producto actualizar(Long id, Producto producto) {

        Producto existente = repository.findById(id).orElse(null);

        if (existente != null) {

            existente.setNombre(producto.getNombre());
            existente.setPrecio(producto.getPrecio());
            existente.setStock(producto.getStock());
            existente.setDescripcion(producto.getDescripcion());
            existente.setMarca(producto.getMarca());
            existente.setModelo(producto.getModelo());
            existente.setGarantia(producto.getGarantia());
            existente.setCategoria(producto.getCategoria());

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
    public Page<Producto> listarPorCategoria(
            Long idCategoria,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findByCategoriaIdCategoria(
                idCategoria,
                pageable
        );
    }

    @Override
    public Page<ProductopresentacionDTO> listarProductosPresentacion(
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.obtenerProductosPresentacion(
                pageable
        );
    }

    @Override
    public Page<ProductopresentacionDTO> filtrarProductos(
            String categoria,
            String marca,
            Double minPrecio,
            Double maxPrecio,
            String nombre,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return repository
                .filtrarProductos(
                        categoria,
                        marca,
                        minPrecio,
                        maxPrecio,
                        nombre,
                        pageable
                )
                .map(ProductoMapper::toPresentacionDTO);
    }

    @Override
    public Page<String> listarMarcas(
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.obtenerMarcas(pageable);
    }
}