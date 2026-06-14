
package gm.technova.service;

import gm.technova.Entity.Caracteristica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CaracteristicaService {

    /* =========================
       LISTAR PAGINADO
    ========================= */
    Page<Caracteristica> listar(Pageable pageable);

    /* =========================
       BUSCAR POR ID
    ========================= */
    Caracteristica buscarPorId(Long id);

    /* =========================
       GUARDAR
    ========================= */
    Caracteristica guardar(Caracteristica caracteristica);

    /* =========================
       ACTUALIZAR
    ========================= */
    Caracteristica actualizar(Long id, Caracteristica caracteristica);

    /* =========================
       ELIMINAR
    ========================= */
    void eliminar(Long id);
}

