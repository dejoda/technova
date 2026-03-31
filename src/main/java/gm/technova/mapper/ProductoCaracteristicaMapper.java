package gm.technova.mapper;

import gm.technova.Entity.ProductoCaracteristica;
import gm.technova.dto.ProductoCaracteristicaDTO;

public class ProductoCaracteristicaMapper {
    public static ProductoCaracteristicaDTO toDTO(ProductoCaracteristica pc) {
        ProductoCaracteristicaDTO dto = new ProductoCaracteristicaDTO();
        dto.setNombre(pc.getCaracteristica().getNombre());
        dto.setValor(pc.getValor());
        return dto;
    }
}
