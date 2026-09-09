package gm.technova.productos.controller;

import gm.technova.productos.Entity.Marca;
import gm.technova.productos.service.MarcaService;
import gm.technova.commons.response.ApiResponse;
import gm.technova.commons.response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping
    public ApiResponse<PageResponse<Marca>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        return ApiResponse.ok(
                "Marcas listadas correctamente",
                service.listar(PageRequest.of(page, size))
        );
    }

    @PostMapping
    @org.springframework.security.access.prepost.PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Marca> guardar(@RequestBody Marca marca) {
        return ApiResponse.ok(
                "Marca registrada correctamente",
                service.guardar(marca)
        );
    }
}
