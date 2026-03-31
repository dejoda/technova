package gm.technova.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_imagen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoImagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long idImagen;

    @Column(name = "url_imagen")
    private String urlImagen;

    private Boolean principal;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    @JsonIgnore
    private Producto producto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoImagen)) return false;
        ProductoImagen that = (ProductoImagen) o;
        return idImagen != null && idImagen.equals(that.idImagen);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}