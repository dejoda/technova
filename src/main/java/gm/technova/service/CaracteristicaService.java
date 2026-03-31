package gm.technova.service;

import gm.technova.Entity.Caracteristica;

import java.util.List;

public interface CaracteristicaService {

    List<Caracteristica> listar();

    Caracteristica buscarPorId(Long id);

    Caracteristica guardar(Caracteristica caracteristica);

    Caracteristica actualizar(Long id, Caracteristica caracteristica);

    void eliminar(Long id);
}