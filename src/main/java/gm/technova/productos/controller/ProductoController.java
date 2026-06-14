
package gm.technova.productos.controller;

import gm.technova.productos.Entity.Producto;
import gm.technova.commons.response.ApiResponse;
import gm.technova.commons.response.PageResponse;
import gm.technova.productos.dto.ProductoDetalleDTO;
import gm.technova.productos.dto.ProductopresentacionDTO;
import gm.technova.productos.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    /* =========================
       ENDPOINTS BÁSICOS
       ========================= */

    // LISTAR PRODUCTOS PAGINADOS
    @GetMapping
    public ApiResponse<PageResponse<Producto>> listar(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Page<Producto> productos = service.listar(page, size);

        return ApiResponse.ok(
                "Lista de productos obtenida correctamente",
                productos
        );
    }

    // BUSCAR PRODUCTO POR ID
    @GetMapping("/{id}")
    public ApiResponse<Producto> buscarPorId(
            @PathVariable Long id
    ) {

        return ApiResponse.ok(
                "Producto encontrado",
                service.buscarPorId(id)
        );
    }

    // GUARDAR PRODUCTO
    @PostMapping
    public ApiResponse<Producto> guardar(
            @RequestBody Producto producto
    ) {

        return ApiResponse.ok(
                "Producto guardado correctamente",
                service.guardar(producto)
        );
    }

    /*
    {
        "nombre": "Logitech G305 Lightspeed Wireless Gaming Mouse",
        "precio": 140.0,
        "stock": 20,
        "descripcion": "Mouse gamer inalámbrico",
        "marca": "Logitech",
        "modelo": "G305",
        "garantia": 12,
        "categoria": {
            "idCategoria": 5
        }
    }
    */

    // ACTUALIZAR PRODUCTO
    @PutMapping("/{id}")
    public ApiResponse<Producto> actualizar(

            @PathVariable Long id,
            @RequestBody Producto producto
    ) {

        return ApiResponse.ok(
                "Producto actualizado correctamente",
                service.actualizar(id, producto)
        );
    }

    // ELIMINAR PRODUCTO
    @DeleteMapping("/{id}")
    public ApiResponse<Void> eliminar(
            @PathVariable Long id
    ) {

        service.eliminar(id);

        return ApiResponse.ok(
                "Producto eliminado correctamente"
        );
    }

    /* =========================
       ENDPOINTS AVANZADOS
       ========================= */

    // OBTENER DETALLE COMPLETO DEL PRODUCTO
    @GetMapping("/{id}/detalle")
    public ApiResponse<ProductoDetalleDTO> obtenerDetalle(
            @PathVariable Long id
    ) {

        return ApiResponse.ok(
                "Detalle del producto obtenido correctamente",
                service.obtenerDetalle(id)
        );
    }

    /*
    ARCHIVOS USADOS:
    ProductoController
    ProductoMapper
    ProductoRepository
    ProductoServiceImpl
    ProductoService
    ProductoDetalleDTO
    ProductoImagen
    ProductoCaracteristica
    Producto
    */

    @GetMapping("/categoria/{id}")
    public ApiResponse<List<Producto>> listarPorCategoria(
            @PathVariable Long id
    ) {
        return ApiResponse.ok(
                "Productos por categoría obtenidos correctamente",
                service.listarPorCategoria(id, 0, Integer.MAX_VALUE).getContent()
        );
    }



    /*
    FILTROS DISPONIBLES:

    /productos/presentacion?categoria=Laptops

    /productos/presentacion?marca=ASUS

    /productos/presentacion?minPrecio=2000&maxPrecio=4000

    /productos/presentacion?nombre=Mouse
    */

    // LISTAR PRODUCTOS FILTRADOS Y PAGINADOS
    @GetMapping("/presentacion")
    public ApiResponse<PageResponse<ProductopresentacionDTO>> listarProductos(

            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) Double minPrecio,
            @RequestParam(required = false) Double maxPrecio,
            @RequestParam(required = false) String nombre,

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Page<ProductopresentacionDTO> productos =
                service.filtrarProductos(
                        categoria,
                        marca,
                        minPrecio,
                        maxPrecio,
                        nombre,
                        page,
                        size
                );

        return ApiResponse.ok(
                "Productos filtrados correctamente",
                productos
        );
    }

    // LISTAR MARCAS
    @GetMapping("/marcas")
    public ApiResponse<List<String>> listarMarcas() {
        return ApiResponse.ok(
                "Marcas obtenidas correctamente",
                service.listarMarcas(0, Integer.MAX_VALUE).getContent()
        );
    }
}

