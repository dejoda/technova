package gm.technova.usuario.mapper;

import gm.technova.usuario.entity.Rol;
import gm.technova.usuario.entity.Usuario;
import gm.technova.usuario.dto.UsuarioRequestDTO;
import gm.technova.usuario.dto.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .rol(usuario.getRol() != null ? usuario.getRol().getNombre() : null)
                .build();
    }

    public Usuario toEntity(UsuarioRequestDTO dto, Rol rol, String encodedPassword) {
        return Usuario.builder()
                .username(dto.getUsername())
                .password(encodedPassword)
                .rol(rol)
                .build();
    }
}