package gm.technova.productos.service;

import gm.technova.productos.dto.request.MovimientoInventarioRequestDTO;
import gm.technova.productos.dto.response.MovimientoInventarioResponseDTO;

import java.util.List;

public interface MovimientoInventarioService {
    MovimientoInventarioResponseDTO registrar(MovimientoInventarioRequestDTO dto);
    List<MovimientoInventarioResponseDTO> listarTodos();
    List<MovimientoInventarioResponseDTO> listarPorProducto(Long productoId);
}