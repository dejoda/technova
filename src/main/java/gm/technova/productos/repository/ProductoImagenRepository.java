package gm.technova.productos.repository;

import gm.technova.productos.Entity.Producto;
import gm.technova.productos.Entity.ProductoImagen;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoImagenRepository
        extends JpaRepository<ProductoImagen, Long> {

    // LISTAR IMAGENES PAGINADAS POR PRODUCTO
    Page<ProductoImagen> findByProductoIdProducto(
            Long idProducto,
            Pageable pageable
    );

    // VALIDAR SI EXISTE IMAGEN PRINCIPAL
    @Query("""
        SELECT COUNT(p) > 0
        FROM ProductoImagen p
        WHERE p.producto = :producto
        AND p.principal = true
    """)
    boolean existsPrincipal(
            @Param("producto") Producto producto
    );
}