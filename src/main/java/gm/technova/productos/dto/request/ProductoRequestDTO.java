package gm.technova.productos.dto.request;

import lombok.Data;

@Data
public class ProductoRequestDTO {
    private String nombre;
    private Double precio;
    private Integer stock;
    private String descripcion;
    private String marca;
    private String modelo;
    private Long garantia;
    private Long categoriaId;
}
