package gm.technova.repository;

import gm.technova.Entity.ProductoCaracteristica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCaracteristicaRepository
        extends JpaRepository<ProductoCaracteristica, Long> {

    /* =========================
       LISTAR POR ID PRODUCTO
    ========================= */

    Page<ProductoCaracteristica> findByProductoIdProducto(
            Long idProducto,
            Pageable pageable
    );
}