package gm.technova.controller;

import gm.technova.Entity.ProductoImagen;
import gm.technova.dto.ProductoImagenInputDTO;
import gm.technova.service.ProductoImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto-imagenes")
public class ProductoImagenController {
    @Autowired
    private ProductoImagenService service;

    @GetMapping("/{id}")
    public List<ProductoImagen> listarImagenesporProducto (@PathVariable Integer id){
    return  service.listarImagenesPorProducto(id.longValue());
    }


    @PostMapping("/agregar")
    public ProductoImagen agregarImagen(@RequestBody ProductoImagenInputDTO dto) {
        return service.agregarImagen(dto);
    }
    /*{
        "productoId": 11,
        "urlImagen": "https://i0.wp.com/mrtecnologies.com/wp-content/uploads/2023/08/G305-1.jpg?fit=1000%2C1000&ssl=1",
        "principal":"true"
    }*/

}
