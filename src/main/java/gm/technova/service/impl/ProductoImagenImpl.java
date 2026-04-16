package gm.technova.service.impl;

import gm.technova.Entity.Producto;
import gm.technova.Entity.ProductoImagen;
import gm.technova.dto.ProductoImagenInputDTO;
import gm.technova.repository.ProductoImagenRepository;
import gm.technova.repository.ProductoRepository;
import gm.technova.service.ProductoImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImagenImpl implements ProductoImagenService {

    @Autowired
    private ProductoImagenRepository productoImagenRepository;

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<ProductoImagen> listarImagenesPorProducto(Long idProducto) {
        return productoImagenRepository.findByProductoIdProducto(idProducto);
    }

    @Override
    public ProductoImagen agregarImagen(ProductoImagenInputDTO dto) {

        Producto producto = repository.findById(dto.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        boolean existePrincipal = productoImagenRepository.existsPrincipal(producto);

        ProductoImagen imagen = new ProductoImagen();
        imagen.setProducto(producto);
        imagen.setUrlImagen(dto.getUrlImagen());

        imagen.setPrincipal(!existePrincipal);

        return productoImagenRepository.save(imagen);
    }
}
