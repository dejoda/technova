package gm.technova.repository;


import gm.technova.Entity.ProductoImagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoImagenRepository extends JpaRepository<ProductoImagen, Long> {
    List<ProductoImagen> findByProductoIdProducto(Long idProducto);
}
