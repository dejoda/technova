
        package gm.technova.controller;

import gm.technova.Entity.Categoria;
import gm.technova.commons.response.ApiResponse;
import gm.technova.commons.response.PageResponse;
import gm.technova.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    /* =========================
       LISTAR PAGINADO
    ========================= */
    @GetMapping
    public ApiResponse<PageResponse<Categoria>> listar(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size,

            @RequestParam(defaultValue = "idCategoria")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return ApiResponse.ok(
                "Categorías listadas correctamente",
                service.listar(
                        PageRequest.of(page, size, sort)
                )
        );
    }

    /* =========================
       BUSCAR POR ID
    ========================= */
    @GetMapping("/{id}")
    public ApiResponse<Categoria> buscarPorId(
            @PathVariable Long id
    ) {

        return ApiResponse.ok(
                "Categoría encontrada",
                service.buscarPorId(id)
        );
    }

    /* =========================
       GUARDAR
    ========================= */
    @PostMapping
    public ApiResponse<Categoria> guardar(
            @RequestBody Categoria categoria
    ) {

        return ApiResponse.ok(
                "Categoría registrada correctamente",
                service.guardar(categoria)
        );
    }

    /* =========================
       ACTUALIZAR
    ========================= */
    @PutMapping("/{id}")
    public ApiResponse<Categoria> actualizar(

            @PathVariable Long id,

            @RequestBody Categoria categoria
    ) {

        return ApiResponse.ok(
                "Categoría actualizada correctamente",
                service.actualizar(id, categoria)
        );
    }

    /* =========================
       ELIMINAR
    ========================= */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> eliminar(
            @PathVariable Long id
    ) {

        service.eliminar(id);

        return ApiResponse.ok(
                "Categoría eliminada correctamente"
        );
    }
}

