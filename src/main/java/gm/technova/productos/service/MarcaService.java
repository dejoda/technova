package gm.technova.productos.service;

import gm.technova.productos.Entity.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarcaService {
    Page<Marca> listar(Pageable pageable);
    Marca guardar(Marca marca);
    Marca buscarPorId(Long id);
}
