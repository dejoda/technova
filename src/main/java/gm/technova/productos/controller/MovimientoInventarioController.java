package gm.technova.productos.controller;

import gm.technova.productos.dto.request.MovimientoInventarioRequestDTO;
import gm.technova.productos.dto.response.MovimientoInventarioResponseDTO;
import gm.technova.productos.service.MovimientoInventarioService;
import gm.technova.commons.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos-inventario")
public class MovimientoInventarioController {

    private final MovimientoInventarioService movimientoInventarioService;

    public MovimientoInventarioController(MovimientoInventarioService movimientoInventarioService) {
        this.movimientoInventarioService = movimientoInventarioService;
    }

    @PostMapping
    @org.springframework.security.access.prepost.PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<MovimientoInventarioResponseDTO> registrar(@RequestBody MovimientoInventarioRequestDTO dto) {
        MovimientoInventarioResponseDTO response = movimientoInventarioService.registrar(dto);
        return ApiResponse.ok("Movimiento registrado correctamente", response);
    }

    @GetMapping
    public ApiResponse<List<MovimientoInventarioResponseDTO>> listarTodos() {
        return ApiResponse.ok("Movimientos obtenidos correctamente", movimientoInventarioService.listarTodos());
    }

    @GetMapping("/producto/{productoId}")
    public ApiResponse<List<MovimientoInventarioResponseDTO>> listarPorProducto(@PathVariable Long productoId) {
        return ApiResponse.ok("Movimientos del producto obtenidos correctamente", movimientoInventarioService.listarPorProducto(productoId));
    }
}