package gm.technova.controller;


import gm.technova.Entity.Caracteristica;
import gm.technova.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService service;

    @GetMapping
    public List<Caracteristica> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Caracteristica buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Caracteristica guardar(@RequestBody Caracteristica caracteristica) {
        return service.guardar(caracteristica);
    }

    @PutMapping("/{id}")
    public Caracteristica actualizar(@PathVariable Long id, @RequestBody Caracteristica caracteristica) {
        return service.actualizar(id, caracteristica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}