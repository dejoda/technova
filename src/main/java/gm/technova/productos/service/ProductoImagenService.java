package gm.technova.productos.service;

import gm.technova.productos.Entity.ProductoImagen;
import gm.technova.productos.dto.ProductoImagenInputDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoImagenService {

    /* =========================
       METODOS BASICOS
    ========================= */

    // Listar imágenes por producto (paginado)
    Page<ProductoImagen> listarImagenesPorProducto(
            Long idProducto,
            Pageable pageable
    );

    /* =========================
       METODOS AVANZADOS
    ========================= */

    // Agregar imagen a producto
    ProductoImagen agregarImagen(
            ProductoImagenInputDTO dto
    );
}