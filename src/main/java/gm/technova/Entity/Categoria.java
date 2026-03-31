package gm.technova.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCategoria;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Producto> productos;
}