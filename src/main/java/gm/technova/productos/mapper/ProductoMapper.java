package gm.technova.productos.mapper;


import gm.technova.productos.dto.*;
import gm.technova.productos.Entity.Producto;
import gm.technova.productos.Entity.ProductoImagen;
import gm.technova.productos.Entity.ProductoCaracteristica;
import gm.technova.productos.Entity.Categoria;
import gm.technova.productos.dto.ProductoCaracteristicaDTO;
import gm.technova.productos.dto.ProductoDetalleDTO;
import gm.technova.productos.dto.ProductoImagenDTO;
import gm.technova.productos.dto.ProductopresentacionDTO;

import java.util.stream.Collectors;
public class ProductoMapper {

    //---
    public static ProductoDetalleDTO toDetalleDTO(Producto producto) {

        ProductoDetalleDTO dto = new ProductoDetalleDTO();

        dto.setId(producto.getIdProducto());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setCategoria(producto.getCategoria().getNombre());
        dto.setMarca(producto.getMarca());
        dto.setModelo(producto.getModelo());
        dto.setGarantia(producto.getGarantia());

        if (producto.getImagenes() != null) {
            dto.setImagenes(
                    producto.getImagenes().stream().map(img -> {
                        ProductoImagenDTO i = new ProductoImagenDTO();
                        i.setUrlImagen(img.getUrlImagen());
                        i.setPrincipal(img.getPrincipal());
                        return i;
                    }).collect(Collectors.toList())
            );
        }
        if (producto.getCaracteristicas() != null) {
            dto.setCaracteristicas(
                    producto.getCaracteristicas().stream().map(c -> {
                        ProductoCaracteristicaDTO cdto = new ProductoCaracteristicaDTO();
                        cdto.setNombre(c.getCaracteristica().getNombre());
                        cdto.setValor(c.getValor());
                        return cdto;
                    }).collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static ProductopresentacionDTO toPresentacionDTO(Producto producto) {

        String imagenPrincipal = null;

        if (producto.getImagenes() != null) {
            imagenPrincipal = producto.getImagenes().stream()
                    .filter(img -> Boolean.TRUE.equals(img.getPrincipal()))
                    .map(ProductoImagen::getUrlImagen)
                    .findFirst()
                    .orElse(null);
        }

        ProductopresentacionDTO dto = new ProductopresentacionDTO();

        dto.setId(producto.getIdProducto());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setDescripcion(producto.getDescripcion());
        dto.setMarca(producto.getMarca());
        dto.setCategoria(
                producto.getCategoria() != null ? producto.getCategoria().getNombre() : null
        );
        dto.setImagen(imagenPrincipal);

        return dto;
    }


    public static ProductoAdminDTO toAdminDTO(Producto p) {
        ProductoAdminDTO dto = new ProductoAdminDTO();
        dto.setId(p.getIdProducto());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());
        dto.setStock(p.getStock());
        dto.setMarca(p.getMarca());
        dto.setModelo(p.getModelo());
        dto.setGarantia(p.getGarantia());
        dto.setDescripcion(p.getDescripcion());

        if (p.getCategoria() != null) {
            dto.setCategoriaId(p.getCategoria().getIdCategoria());
            dto.setCategoria(p.getCategoria().getNombre());
        }

        if (p.getImagenes() != null) {
            dto.setImagenes(p.getImagenes().stream()
                    .map(img -> {
                        ProductoImagenDTO idto = new ProductoImagenDTO();
                        idto.setUrlImagen(img.getUrlImagen());
                        idto.setPrincipal(img.getPrincipal());
                        return idto;
                    }).collect(Collectors.toList()));
        }

        return dto;
    }

}
