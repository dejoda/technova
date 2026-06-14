package gm.technova.usuario.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioUpdateDTO {

    @Size(min = 3, max = 100)
    private String username;

    @Size(min = 6, message = "La contraseña debe tener mínimo 6 caracteres")
    private String password;      // opcional, solo si quiere cambiarla

    private Integer rolId;        // opcional
}