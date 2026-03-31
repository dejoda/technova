package gm.technova.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_caracteristica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCaracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id") //
    @JsonBackReference//<--Cambiar despues peusto por mientras
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "caracteristica_id") //
    private Caracteristica caracteristica;

    private String valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoCaracteristica)) return false;
        ProductoCaracteristica that = (ProductoCaracteristica) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}