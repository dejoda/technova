package gm.technova.repository;

import gm.technova.Entity.ProductoCaracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoCaracteristicaRepository extends JpaRepository<ProductoCaracteristica, Long> {
    /*Listar por IDPRODUCTO*/   /*METODOS QUE SE USAN CON EL MAPPER Y DTO */
    List<ProductoCaracteristica> findByProductoIdProducto(Long idProducto);
}