package gm.technova.productos.controller;

import gm.technova.productos.Entity.ProductoImagen;
import gm.technova.productos.dto.ProductoImagenInputDTO;
import gm.technova.productos.service.ProductoImagenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    public ProductoImagen uploadImagen(
            @RequestParam("file") MultipartFile file,
            @RequestParam Long productoId,
            @RequestParam boolean isPrincipal
    ) {
        return service.uploadImagen(file, productoId, isPrincipal);
    }

    @PutMapping("/principal/{id}")
    public void updatePrincipal(
            @PathVariable Long id,
            @RequestParam boolean isPrincipal
    ) {
        service.updatePrincipal(id, isPrincipal);
    }

    @DeleteMapping("/{id}")
    public void eliminarImagen(
            @PathVariable Long id
    ) {
        service.eliminarImagen(id);
    }
}
