package gm.technova.controller;

import gm.technova.Entity.ProductoCaracteristica;
import gm.technova.dto.ProductoCaracteristicaDTO;
import gm.technova.dto.ProductoCaracteristicaInputDTO;
import gm.technova.service.ProductoCaracteristicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto-caracteristicas")
public class ProductoCaracteristicaController {

    @Autowired
    private ProductoCaracteristicaService service;

    /* =========================
       CRUD BASICO
    ========================= */

    @GetMapping
    public Page<ProductoCaracteristica> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return service.listar(pageable);
    }

    // Agregar característica a producto
    @PostMapping("/agregar")
    public ProductoCaracteristica agregarCaracteristica(
            @RequestBody ProductoCaracteristicaInputDTO dto
    ) {

        return service.agregarCaracteristica(dto);
    }

    /*
    {
        "productoId": 11,
        "caracteristicaId": 12,
        "valor": "99g"
    }
    */

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        service.eliminar(id);
    }

    /* =========================
       DTO + MAPPER
    ========================= */

    @GetMapping("/{id}/caracteristicas")
    public Page<ProductoCaracteristicaDTO> listarCaracteristicas(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return service.listarCaracteristicasporProducto(
                id,
                pageable
        );
    }

    /* =========================
       METODOS OMITIDOS
    ========================= */

    /*
    @GetMapping("/{id}/caracteristicas-completo")
    public List<ProductoCaracteristica> listarCaracteristicasProductoCompleto(
            @PathVariable Long id
    ) {
        return service.listarCaracteristicasPorProductoCompleto(id);
    }
    */
}