
package gm.technova.service;

import gm.technova.Entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {

    /* =========================
       CRUD BASICO
    ========================= */

    // Listar con paginación
    Page<Categoria> listar(Pageable pageable);

    // Buscar por ID
    Categoria buscarPorId(Long id);

    // Guardar
    Categoria guardar(Categoria categoria);

    // Actualizar
    Categoria actualizar(Long id, Categoria categoria);

    // Eliminar
    void eliminar(Long id);

}

