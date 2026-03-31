package gm.technova.service.impl;

import gm.technova.Entity.ProductoImagen;
import gm.technova.repository.ProductoImagenRepository;
import gm.technova.service.ProductoImagenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoImagenImpl implements ProductoImagenService {

    @Autowired
    private ProductoImagenRepository repository;

    @Override
    public List<ProductoImagen> listarImagenesPorProducto(Long idProducto) {
        return repository.findByProductoIdProducto(idProducto);
    }
}
