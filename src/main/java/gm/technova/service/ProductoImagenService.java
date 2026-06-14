package gm.technova.service;

import gm.technova.Entity.ProductoImagen;
import gm.technova.dto.ProductoImagenInputDTO;

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