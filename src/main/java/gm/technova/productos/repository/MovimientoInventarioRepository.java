package gm.technova.productos.repository;

import gm.technova.productos.Entity.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {
    List<MovimientoInventario> findByProductoIdProductoOrderByFechaDesc(Long idProducto);
    List<MovimientoInventario> findAllByOrderByFechaDesc();
}