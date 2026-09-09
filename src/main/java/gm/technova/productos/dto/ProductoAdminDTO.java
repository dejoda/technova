package gm.technova.productos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoAdminDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private Long categoriaId;
    private String categoria;
    private String descripcion;
    private String marca;
    private String modelo;
    private Long garantia;
    private List<ProductoImagenDTO> imagenes;
}