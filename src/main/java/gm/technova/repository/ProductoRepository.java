package gm.technova.repository;

import gm.technova.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("""
    SELECT DISTINCT p FROM Producto p
    LEFT JOIN FETCH p.imagenes
    LEFT JOIN FETCH p.caracteristicas pc
    LEFT JOIN FETCH pc.caracteristica
    LEFT JOIN FETCH p.categoria
    WHERE p.idProducto = :id
    """)
    Producto obtenerProductoDetalle(@Param("id") Long id);

}