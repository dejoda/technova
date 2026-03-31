package gm.technova.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProducto;

    private String nombre;
    private Double precio;
    private Integer stock;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_id") // ← ESTA ES LA CLAVE FORÁNEA REAL
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private Set<ProductoImagen> imagenes;

    @OneToMany(mappedBy = "producto")
    @JsonManagedReference// ← CAMBIAR DESPUES PUESTO POR MIENTRAS
    private Set<ProductoCaracteristica> caracteristicas;


}