package gm.technova.productos.repository;

import gm.technova.productos.Entity.Producto;
import gm.technova.productos.dto.ProductopresentacionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

    /* =========================================================
       DETALLE COMPLETO
    ========================================================= */

    @Query("""
        SELECT DISTINCT p FROM Producto p
        LEFT JOIN FETCH p.imagenes
        LEFT JOIN FETCH p.caracteristicas pc
        LEFT JOIN FETCH pc.caracteristica
        LEFT JOIN FETCH p.categoria
        WHERE p.idProducto = :id
    """)
    Producto obtenerProductoDetalle(
            @Param("id") Long id
    );

    /* =========================================================
       PRODUCTOS POR CATEGORIA
    ========================================================= */

    Page<Producto> findByCategoriaIdCategoria(
            Long idCategoria,
            Pageable pageable
    );

    /* =========================================================
       FILTRAR PRODUCTOS
    ========================================================= */

    @Query("""
        SELECT p FROM Producto p
        WHERE (:categoria IS NULL
            OR LOWER(p.categoria.nombre) = LOWER(:categoria))
        AND (:marca IS NULL
            OR LOWER(p.marca) = LOWER(:marca))
        AND (:minPrecio IS NULL
            OR p.precio >= :minPrecio)
        AND (:maxPrecio IS NULL
            OR p.precio <= :maxPrecio)
        AND (:nombre IS NULL
            OR LOWER(p.nombre)
            LIKE LOWER(CONCAT('%', :nombre, '%')))
    """)
    Page<Producto> filtrarProductos(
            @Param("categoria") String categoria,
            @Param("marca") String marca,
            @Param("minPrecio") Double minPrecio,
            @Param("maxPrecio") Double maxPrecio,
            @Param("nombre") String nombre,
            Pageable pageable
    );

    /* =========================================================
       PRODUCTOS PRESENTACION
    ========================================================= */

    @Query("""
        SELECT new gm.technova.productos.dto.ProductopresentacionDTO(
            p.idProducto,
            p.nombre,
            p.precio,
            c.nombre,
            p.descripcion,
            p.marca,
            pi.urlImagen
        )
        FROM Producto p
        LEFT JOIN p.categoria c
        LEFT JOIN p.imagenes pi
            ON pi.principal = true
    """)
    Page<ProductopresentacionDTO> obtenerProductosPresentacion(
            Pageable pageable
    );

    /* =========================================================
       LISTAR MARCAS
    ========================================================= */

    @Query("""
        SELECT DISTINCT p.marca
        FROM Producto p
        ORDER BY p.marca ASC
    """)
    Page<String> obtenerMarcas(
            Pageable pageable
    );
}