
package gm.technova.service.impl;

import gm.technova.Entity.Caracteristica;
import gm.technova.repository.CaracteristicaRepository;
import gm.technova.service.CaracteristicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {

    @Autowired
    private CaracteristicaRepository repository;

    /* =========================
       LISTAR PAGINADO
    ========================= */
    @Override
    public Page<Caracteristica> listar(Pageable pageable) {

        return repository.findAll(pageable);
    }

    /* =========================
       BUSCAR POR ID
    ========================= */
    @Override
    public Caracteristica buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Característica no encontrada con ID: " + id
                        )
                );
    }

    /* =========================
       GUARDAR
    ========================= */
    @Override
    public Caracteristica guardar(Caracteristica caracteristica) {

        return repository.save(caracteristica);
    }

    /* =========================
       ACTUALIZAR
    ========================= */
    @Override
    public Caracteristica actualizar(Long id, Caracteristica caracteristica) {

        Caracteristica existente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Característica no encontrada con ID: " + id
                        )
                );

        existente.setNombre(caracteristica.getNombre());

        return repository.save(existente);
    }

    /* =========================
       ELIMINAR
    ========================= */
    @Override
    public void eliminar(Long id) {

        Caracteristica caracteristica = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Característica no encontrada con ID: " + id
                        )
                );

        repository.delete(caracteristica);
    }
}

