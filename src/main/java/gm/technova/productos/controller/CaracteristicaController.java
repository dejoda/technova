
package gm.technova.productos.controller;

import gm.technova.productos.Entity.Caracteristica;
import gm.technova.commons.response.ApiResponse;
import gm.technova.commons.response.PageResponse;
import gm.technova.productos.service.CaracteristicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService service;

    /* =========================
       LISTAR PAGINADO
    ========================= */
    @GetMapping
    public ApiResponse<PageResponse<Caracteristica>> listar(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size,

            @RequestParam(defaultValue = "idCaracteristica")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return ApiResponse.ok(
                "Características listadas correctamente",
                service.listar(
                        PageRequest.of(page, size, sort)
                )
        );
    }

    /* =========================
       BUSCAR POR ID
    ========================= */
    @GetMapping("/{id}")
    public ApiResponse<Caracteristica> buscarPorId(
            @PathVariable Long id
    ) {

        return ApiResponse.ok(
                "Característica encontrada",
                service.buscarPorId(id)
        );
    }

    /* =========================
       GUARDAR
    ========================= */
    @PostMapping
    public ApiResponse<Caracteristica> guardar(
            @RequestBody Caracteristica caracteristica
    ) {

        return ApiResponse.ok(
                "Característica registrada correctamente",
                service.guardar(caracteristica)
        );
    }

    /*
    {
        "nombre": "Ergonomia"
    }
    */

    /* =========================
       ACTUALIZAR
    ========================= */
    @PutMapping("/{id}")
    public ApiResponse<Caracteristica> actualizar(

            @PathVariable Long id,

            @RequestBody Caracteristica caracteristica
    ) {

        return ApiResponse.ok(
                "Característica actualizada correctamente",
                service.actualizar(id, caracteristica)
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
                "Característica eliminada correctamente"
        );
    }
}

