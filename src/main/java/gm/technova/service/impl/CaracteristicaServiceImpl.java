package gm.technova.service.impl;

import gm.technova.Entity.Caracteristica;
import gm.technova.repository.CaracteristicaRepository;
import gm.technova.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {

    @Autowired
    private CaracteristicaRepository repository;

    @Override
    public List<Caracteristica> listar() {
        return repository.findAll();
    }

    @Override
    public Caracteristica buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Caracteristica guardar(Caracteristica caracteristica) {
        return repository.save(caracteristica);
    }

    @Override
    public Caracteristica actualizar(Long id, Caracteristica caracteristica) {
        Caracteristica existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(caracteristica.getNombre());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}