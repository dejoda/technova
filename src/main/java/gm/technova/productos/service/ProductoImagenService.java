package gm.technova.productos.service;

import gm.technova.productos.Entity.ProductoImagen;
import gm.technova.productos.dto.ProductoImagenInputDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


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

    // Subir archivo de imagen
    ProductoImagen uploadImagen(
            MultipartFile file,
            Long productoId,
            boolean isPrincipal
    );
}