package gm.technova.repository;


import gm.technova.Entity.Producto;
import gm.technova.Entity.ProductoImagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoImagenRepository extends JpaRepository<ProductoImagen, Long> {
    List<ProductoImagen> findByProductoIdProducto(Long idProducto);

    @Query("SELECT COUNT(p) > 0 FROM ProductoImagen p WHERE p.producto = :producto AND p.principal = true")
    boolean existsPrincipal(@Param("producto") Producto producto);


}
