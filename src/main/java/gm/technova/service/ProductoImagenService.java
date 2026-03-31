package gm.technova.service;

import gm.technova.Entity.ProductoImagen;

import java.util.List;

public interface ProductoImagenService {
    List<ProductoImagen> listarImagenesPorProducto(Long idProducto);
}
