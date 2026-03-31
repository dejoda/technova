package gm.technova.dto;

import lombok.Data;

@Data
public class ProductoCaracteristicaInputDTO {
    private Long productoId;        // ID del producto al que se le agrega
    private Long caracteristicaId;  // ID de la característica global
    private String valor;           // valor de la característica
}
