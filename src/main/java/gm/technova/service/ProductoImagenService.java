package gm.technova.service;

import gm.technova.Entity.ProductoImagen;
import gm.technova.dto.ProductoImagenInputDTO;

import java.util.List;

public interface ProductoImagenService {
    List<ProductoImagen> listarImagenesPorProducto(Long idProducto);


    ProductoImagen agregarImagen(ProductoImagenInputDTO dto);
}
