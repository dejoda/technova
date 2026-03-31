package gm.technova.service;

import gm.technova.Entity.ProductoCaracteristica;
import gm.technova.dto.ProductoCaracteristicaDTO;

import java.util.List;

public interface ProductoCaracteristicaService {

    //METODOS BASICOS
    List<ProductoCaracteristica> listar();
    ProductoCaracteristica guardar(ProductoCaracteristica pc);
    void eliminar(Long id);

    //METODOS AVANZADOS

    /*Listar las caracteristicas del producto (USANDO DTO Y MAPPER)*/
    List<ProductoCaracteristicaDTO> listarCaracteristicasporProducto(Long idProducto);


    /*METODOS OMITIDOS*/

    /*Listar por ID PRODUCTO*/

    //List<ProductoCaracteristica> listarCaracteristicasPorProductoCompleto(Long idProducto);
}