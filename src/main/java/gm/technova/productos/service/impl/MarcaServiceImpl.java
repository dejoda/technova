package gm.technova.productos.service.impl;

import gm.technova.productos.Entity.Marca;
import gm.technova.productos.repository.MarcaRepository;
import gm.technova.productos.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository repository;

    @Override
    public Page<Marca> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Marca guardar(Marca marca) {
        return repository.save(marca);
    }

    @Override
    public Marca buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + id));
    }
}
