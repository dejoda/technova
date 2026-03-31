package gm.technova.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caracteristica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCaracteristica;

    private String nombre;
}