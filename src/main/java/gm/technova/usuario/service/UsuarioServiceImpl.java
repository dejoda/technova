package gm.technova.usuario.service;

import gm.technova.usuario.entity.Rol;
import gm.technova.usuario.entity.Usuario;
import gm.technova.usuario.dto.UsuarioRequestDTO;
import gm.technova.usuario.dto.UsuarioResponseDTO;
import gm.technova.usuario.dto.UsuarioUpdateDTO;
import gm.technova.exception.ResourceNotFoundException;   // la que ya tengas
import gm.technova.usuario.mapper.UsuarioMapper;
import gm.technova.usuario.repository.RolRepository;
import gm.technova.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("El username '" + dto.getUsername() + "' ya está en uso");
        }

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + dto.getRolId()));

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        Usuario usuario = usuarioMapper.toEntity(dto, rol, encodedPassword);
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toResponse(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO obtenerPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public UsuarioResponseDTO actualizar(Integer id, UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));

        if (dto.getUsername() != null && !dto.getUsername().isBlank()) {
            if (!dto.getUsername().equals(usuario.getUsername())
                    && usuarioRepository.existsByUsername(dto.getUsername())) {
                throw new IllegalArgumentException("El username '" + dto.getUsername() + "' ya está en uso");
            }
            usuario.setUsername(dto.getUsername());
        }

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getRolId() != null) {
            Rol rol = rolRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + dto.getRolId()));
            usuario.setRol(rol);
        }

        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}