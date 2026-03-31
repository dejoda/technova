package gm.technova.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductoDetalleDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private String categoria;
    private String descripcion;

    private List<ProductoImagenDTO> imagenes;
    private List<ProductoCaracteristicaDTO> caracteristicas;
}
