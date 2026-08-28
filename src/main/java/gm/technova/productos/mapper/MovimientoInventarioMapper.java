package gm.technova.productos.mapper;

import gm.technova.productos.Entity.MovimientoInventario;
import gm.technova.productos.dto.response.MovimientoInventarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MovimientoInventarioMapper {

    public MovimientoInventarioResponseDTO toResponseDTO(MovimientoInventario m) {
        MovimientoInventarioResponseDTO dto = new MovimientoInventarioResponseDTO();
        dto.setId(m.getId());
        dto.setProductoId(m.getProducto().getIdProducto());
        dto.setProductoNombre(m.getProducto().getNombre());
        dto.setUsuarioNombre(m.getUsuario().getUsername());
        dto.setTipo(m.getTipo());
        dto.setCantidad(m.getCantidad());
        dto.setStockResultante(m.getStockResultante());
        dto.setMotivo(m.getMotivo());
        dto.setFecha(m.getFecha());
        return dto;
    }
}