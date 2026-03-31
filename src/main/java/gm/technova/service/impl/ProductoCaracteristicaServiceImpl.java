package gm.technova.service.impl;

import gm.technova.Entity.Caracteristica;
import gm.technova.Entity.Producto;
import gm.technova.Entity.ProductoCaracteristica;
import gm.technova.dto.ProductoCaracteristicaDTO;
import gm.technova.dto.ProductoCaracteristicaInputDTO;
import gm.technova.mapper.ProductoCaracteristicaMapper;
import gm.technova.repository.CaracteristicaRepository;
import gm.technova.repository.ProductoCaracteristicaRepository;
import gm.technova.repository.ProductoRepository;
import gm.technova.service.ProductoCaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoCaracteristicaServiceImpl implements ProductoCaracteristicaService {



    @Autowired
    private ProductoCaracteristicaRepository ProductoCaracteristicarepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    //METODOS BASICOS
    @Override
    public List<ProductoCaracteristica> listar() {
        return ProductoCaracteristicarepository.findAll();
    }


    @Override
    public void eliminar(Long id) {
        ProductoCaracteristicarepository.deleteById(id);
    }
    //

    //METODOS AVANZADOS

    /*Listar las caracteristicas del producto (USANDO DTO Y MAPPER)*/
    @Override
    public List<ProductoCaracteristicaDTO> listarCaracteristicasporProducto(Long idProducto) {
        List<ProductoCaracteristica> lista = ProductoCaracteristicarepository.findByProductoIdProducto(idProducto);

        List<ProductoCaracteristicaDTO> dtoLista = new ArrayList<>();

        for (ProductoCaracteristica pc : lista) {
            dtoLista.add(ProductoCaracteristicaMapper.toDTO(pc));
        }

        return dtoLista;
    }

    @Override
    public ProductoCaracteristica agregarCaracteristica(ProductoCaracteristicaInputDTO dto) {

        Producto producto = productoRepository.findById(dto.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Caracteristica caracteristica = caracteristicaRepository.findById(dto.getCaracteristicaId())
                .orElseThrow(() -> new RuntimeException("Característica no encontrada"));

        ProductoCaracteristica pc = new ProductoCaracteristica();
        pc.setProducto(producto);
        pc.setCaracteristica(caracteristica);
        pc.setValor(dto.getValor());

        return ProductoCaracteristicarepository.save(pc);
    }

    //METODOS OMITIDOS -------

    /*Listar por id_PRODUCTO*/
   /* @Override
    public List<ProductoCaracteristica> listarCaracteristicasPorProductoCompleto(Long idProducto) {
        return repository.findByProductoIdProducto(idProducto);
    }*/
}