package gm.technova.service.impl;

import gm.technova.Entity.Producto;
import gm.technova.Entity.ProductoImagen;
import gm.technova.dto.ProductoImagenInputDTO;
import gm.technova.repository.ProductoImagenRepository;
import gm.technova.repository.ProductoRepository;
import gm.technova.service.ProductoImagenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoImagenImpl implements ProductoImagenService {

    @Autowired
    private ProductoImagenRepository productoImagenRepository;

    @Autowired
    private ProductoRepository repository;

    /* =========================
       METODOS BASICOS
    ========================= */

    @Override
    public Page<ProductoImagen> listarImagenesPorProducto(
            Long idProducto,
            Pageable pageable
    ) {

        return productoImagenRepository
                .findByProductoIdProducto(idProducto, pageable);
    }

    /* =========================
       METODOS AVANZADOS
    ========================= */

    @Override
    public ProductoImagen agregarImagen(
            ProductoImagenInputDTO dto
    ) {

        Producto producto = repository.findById(dto.getProductoId())
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado")
                );

        boolean existePrincipal =
                productoImagenRepository.existsPrincipal(producto);

        ProductoImagen imagen = new ProductoImagen();

        imagen.setProducto(producto);
        imagen.setUrlImagen(dto.getUrlImagen());

        // Si no existe principal, esta será principal
        imagen.setPrincipal(!existePrincipal);

        return productoImagenRepository.save(imagen);
    }
}