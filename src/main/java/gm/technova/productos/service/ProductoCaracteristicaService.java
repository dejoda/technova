
package gm.technova.productos.service;

import gm.technova.productos.Entity.ProductoCaracteristica;
import gm.technova.productos.dto.ProductoCaracteristicaDTO;
import gm.technova.productos.dto.ProductoCaracteristicaInputDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoCaracteristicaService {

    /* =========================
       METODOS BASICOS
    ========================= */

    // Listar paginado
    Page<ProductoCaracteristica> listar(Pageable pageable);

    // Eliminar
    void eliminar(Long id);

    /* =========================
       METODOS AVANZADOS
    ========================= */

    // Listar características por producto (DTO)
    Page<ProductoCaracteristicaDTO> listarCaracteristicasporProducto(
            Long idProducto,
            Pageable pageable
    );

    // Agregar característica a producto
    ProductoCaracteristica agregarCaracteristica(
            ProductoCaracteristicaInputDTO dto
    );

    /* =========================
       METODOS OMITIDOS
    ========================= */

    // List<ProductoCaracteristica> listarCaracteristicasPorProductoCompleto(Long idProducto);

}

