package gm.technova.productos.controller;

import gm.technova.commons.response.ApiResponse;
import gm.technova.commons.response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import gm.technova.productos.service.ProductoService;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ApiResponse<PageResponse<String>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        return ApiResponse.ok(
                "Marcas listadas correctamente",
                productoService.listarMarcas(page, size)
        );
    }

    @PostMapping
    @org.springframework.security.access.prepost.PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<String> guardar(@RequestBody java.util.Map<String, String> body) {
        String nombre = body.get("nombre");
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("El nombre de la marca es obligatorio");
        }
        // Como ya no hay tabla de marcas, "guardar" una marca no tiene sentido
        // a menos que queramos validar que existe o algo así.
        // Pero para no romper el frontend, devolvemos el nombre.
        return ApiResponse.ok("Marca registrada (simulado)", nombre);
    }
}
