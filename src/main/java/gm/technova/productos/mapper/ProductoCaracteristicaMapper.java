package gm.technova.productos.mapper;

import gm.technova.productos.Entity.ProductoCaracteristica;
import gm.technova.productos.dto.ProductoCaracteristicaDTO;

public class ProductoCaracteristicaMapper {
    public static ProductoCaracteristicaDTO toDTO(ProductoCaracteristica pc) {
        ProductoCaracteristicaDTO dto = new ProductoCaracteristicaDTO();
        dto.setNombre(pc.getCaracteristica().getNombre());
        dto.setValor(pc.getValor());
        return dto;
    }
}
