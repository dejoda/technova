package gm.technova.service.impl;

import gm.technova.Entity.ProductoCaracteristica;
import gm.technova.dto.ProductoCaracteristicaDTO;
import gm.technova.mapper.ProductoCaracteristicaMapper;
import gm.technova.repository.ProductoCaracteristicaRepository;
import gm.technova.service.ProductoCaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoCaracteristicaServiceImpl implements ProductoCaracteristicaService {



    @Autowired
    private ProductoCaracteristicaRepository repository;

    //METODOS BASICOS
    @Override
    public List<ProductoCaracteristica> listar() {
        return repository.findAll();
    }

    @Override
    public ProductoCaracteristica guardar(ProductoCaracteristica pc) {
        return repository.save(pc);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
    //

    //METODOS AVANZADOS

    /*Listar las caracteristicas del producto (USANDO DTO Y MAPPER)*/
    @Override
    public List<ProductoCaracteristicaDTO> listarCaracteristicasporProducto(Long idProducto) {
        List<ProductoCaracteristica> lista = repository.findByProductoIdProducto(idProducto);

        List<ProductoCaracteristicaDTO> dtoLista = new ArrayList<>();

        for (ProductoCaracteristica pc : lista) {
            dtoLista.add(ProductoCaracteristicaMapper.toDTO(pc));
        }

        return dtoLista;
    }

    //METODOS OMITIDOS -------

    /*Listar por id_PRODUCTO*/
   /* @Override
    public List<ProductoCaracteristica> listarCaracteristicasPorProductoCompleto(Long idProducto) {
        return repository.findByProductoIdProducto(idProducto);
    }*/
}