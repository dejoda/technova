
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoCaracteristicaServiceImpl
        implements ProductoCaracteristicaService {

    @Autowired
    private ProductoCaracteristicaRepository productoCaracteristicaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    /* =========================
       METODOS BASICOS
    ========================= */

    @Override
    public Page<ProductoCaracteristica> listar(Pageable pageable) {

        return productoCaracteristicaRepository.findAll(pageable);
    }

    @Override
    public void eliminar(Long id) {

        ProductoCaracteristica pc =
                productoCaracteristicaRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Relación producto-característica no encontrada"
                                )
                        );

        productoCaracteristicaRepository.delete(pc);
    }

    /* =========================
       METODOS AVANZADOS
    ========================= */

    // Listar características por producto (DTO)
    @Override
    public Page<ProductoCaracteristicaDTO> listarCaracteristicasporProducto(
            Long idProducto,
            Pageable pageable
    ) {

        Page<ProductoCaracteristica> pagina =
                productoCaracteristicaRepository
                        .findByProductoIdProducto(idProducto, pageable);

        return pagina.map(ProductoCaracteristicaMapper::toDTO);
    }

    // Agregar característica a producto
    @Override
    public ProductoCaracteristica agregarCaracteristica(
            ProductoCaracteristicaInputDTO dto
    ) {

        Producto producto = productoRepository
                .findById(dto.getProductoId())
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado")
                );

        Caracteristica caracteristica = caracteristicaRepository
                .findById(dto.getCaracteristicaId())
                .orElseThrow(() ->
                        new RuntimeException("Característica no encontrada")
                );

        ProductoCaracteristica pc = new ProductoCaracteristica();

        pc.setProducto(producto);
        pc.setCaracteristica(caracteristica);
        pc.setValor(dto.getValor());

        return productoCaracteristicaRepository.save(pc);
    }

    /* =========================
       METODOS OMITIDOS
    ========================= */

    /*
    @Override
    public List<ProductoCaracteristica>
    listarCaracteristicasPorProductoCompleto(Long idProducto) {

        return repository.findByProductoIdProducto(idProducto);
    }
    */
}

