
package gm.technova.service.impl;

import gm.technova.Entity.Categoria;
import gm.technova.repository.CategoriaRepository;
import gm.technova.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    /* =========================
       LISTAR PAGINADO
    ========================= */
    @Override
    public Page<Categoria> listar(Pageable pageable) {

        return repository.findAll(pageable);
    }

    /* =========================
       BUSCAR POR ID
    ========================= */
    @Override
    public Categoria buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Categoría no encontrada con ID: " + id
                        )
                );
    }

    /* =========================
       GUARDAR
    ========================= */
    @Override
    public Categoria guardar(Categoria categoria) {

        return repository.save(categoria);
    }

    /* =========================
       ACTUALIZAR
    ========================= */
    @Override
    public Categoria actualizar(Long id, Categoria categoria) {

        Categoria existente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Categoría no encontrada con ID: " + id
                        )
                );

        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());

        return repository.save(existente);
    }

    /* =========================
       ELIMINAR
    ========================= */
    @Override
    public void eliminar(Long id) {

        Categoria categoria = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Categoría no encontrada con ID: " + id
                        )
                );

        repository.delete(categoria);
    }
}

