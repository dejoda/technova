package gm.technova.productos.service;

import gm.technova.productos.Entity.Producto;
import gm.technova.productos.dto.ProductoDetalleDTO;
import gm.technova.productos.dto.ProductopresentacionDTO;

import org.springframework.data.domain.Page;

public interface ProductoService {

    /* =========================
       MÉTODOS BÁSICOS
    ========================= */

    // LISTAR PRODUCTOS PAGINADOS
    Page<Producto> listar(
            int page,
            int size
    );

    // BUSCAR PRODUCTO POR ID
    Producto buscarPorId(Long id);

    // GUARDAR PRODUCTO
    Producto guardar(Producto producto);

    // ACTUALIZAR PRODUCTO
    Producto actualizar(
            Long id,
            Producto producto
    );

    // ELIMINAR PRODUCTO
    void eliminar(Long id);

    /* =========================
       MÉTODOS AVANZADOS
    ========================= */

    // OBTENER DETALLE COMPLETO DEL PRODUCTO
    ProductoDetalleDTO obtenerDetalle(Long id);

    // LISTAR PRODUCTOS POR CATEGORÍA PAGINADOS
    Page<Producto> listarPorCategoria(
            Long idCategoria,
            int page,
            int size
    );

    // LISTAR PRODUCTOS PRESENTACIÓN PAGINADOS
    Page<ProductopresentacionDTO> listarProductosPresentacion(
            int page,
            int size
    );

    // FILTRAR PRODUCTOS PAGINADOS
    Page<ProductopresentacionDTO> filtrarProductos(
            String categoria,
            String marca,
            Double minPrecio,
            Double maxPrecio,
            String nombre,
            int page,
            int size
    );

    // LISTAR MARCAS PAGINADAS
    Page<String> listarMarcas(
            int page,
            int size
    );
}