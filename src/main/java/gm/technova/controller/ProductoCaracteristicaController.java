package gm.technova.controller;


import gm.technova.Entity.Producto;
import gm.technova.Entity.ProductoCaracteristica;
import gm.technova.dto.ProductoCaracteristicaDTO;
import gm.technova.service.ProductoCaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto-caracteristicas")
public class ProductoCaracteristicaController {

    @Autowired
    private ProductoCaracteristicaService service;

    /*metodos basicos crud*/
    @GetMapping
    public List<ProductoCaracteristica> listar() {
        return service.listar();
    }

    @PostMapping
    public ProductoCaracteristica guardar(@RequestBody ProductoCaracteristica pc) {
        return service.guardar(pc);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    /*METODOS QUE SE USAN CON EL MAPPER Y DTO */

    @GetMapping("/{id}/caracteristicas")
    public List<ProductoCaracteristicaDTO> listarCaracteristicas(@PathVariable Long id) {
        return service.listarCaracteristicasporProducto(id);
    }


    /*METODOS OMITIDOS*/


    /*BUSCAR POR ID PRODUCTO las caracterizticas pero jalando todo el producto*/

    /* @GetMapping("/{id}/caracteristicas-completo")
    public List<ProductoCaracteristica> listarCaracteristicasProductoCompleto(@PathVariable Long id) {
        return service.listarCaracteristicasPorProductoCompleto(id);
    } */


}