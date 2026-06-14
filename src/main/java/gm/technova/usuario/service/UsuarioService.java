package gm.technova.usuario.service;

import gm.technova.usuario.dto.UsuarioRequestDTO;
import gm.technova.usuario.dto.UsuarioResponseDTO;
import gm.technova.usuario.dto.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO crear(UsuarioRequestDTO dto);
    List<UsuarioResponseDTO> listarTodos();
    UsuarioResponseDTO obtenerPorId(Integer id);
    UsuarioResponseDTO actualizar(Integer id, UsuarioUpdateDTO dto);
    void eliminar(Integer id);
}