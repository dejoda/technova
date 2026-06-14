package gm.technova.controller;

import gm.technova.Entity.ProductoImagen;
import gm.technova.dto.ProductoImagenInputDTO;
import gm.technova.service.ProductoImagenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto-imagenes")
public class ProductoImagenController {

    @Autowired
    private ProductoImagenService service;

    /* =========================
       LISTAR IMAGENES PAGINADO
    ========================= */

    @GetMapping("/{id}")
    public Page<ProductoImagen> listarImagenesporProducto(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        return service.listarImagenesPorProducto(
                id,
                pageable
        );
    }

    /* =========================
       AGREGAR IMAGEN
    ========================= */

    @PostMapping("/agregar")
    public ProductoImagen agregarImagen(
            @RequestBody ProductoImagenInputDTO dto
    ) {

        return service.agregarImagen(dto);
    }

    /*
    {
        "productoId": 11,
        "urlImagen": "https://i0.wp.com/mrtecnologies.com/wp-content/uploads/2023/08/G305-1.jpg?fit=1000%2C1000&ssl=1"
    }
    */
}