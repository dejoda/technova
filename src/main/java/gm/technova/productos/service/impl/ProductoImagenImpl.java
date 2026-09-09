package gm.technova.productos.service.impl;

import gm.technova.productos.Entity.Producto;
import gm.technova.productos.Entity.ProductoImagen;
import gm.technova.productos.dto.ProductoImagenInputDTO;
import gm.technova.productos.repository.ProductoImagenRepository;
import gm.technova.productos.repository.ProductoRepository;
import gm.technova.productos.service.ProductoImagenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

@Service
public class ProductoImagenImpl implements ProductoImagenService {

    @Autowired
    private ProductoImagenRepository productoImagenRepository;

    @Autowired
    private ProductoRepository repository;

    /* =========================
       METODOS BASICOS
    ========================= */

    @Override
    public Page<ProductoImagen> listarImagenesPorProducto(
            Long idProducto,
            Pageable pageable
    ) {

        return productoImagenRepository
                .findByProductoIdProducto(idProducto, pageable);
    }

    /* =========================
       METODOS AVANZADOS
    ========================= */

    @Override
    public ProductoImagen agregarImagen(
            ProductoImagenInputDTO dto
    ) {

        Producto producto = repository.findById(dto.getProductoId())
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado")
                );

        boolean existePrincipal =
                productoImagenRepository.existsPrincipal(producto);

        ProductoImagen imagen = new ProductoImagen();

        imagen.setProducto(producto);
        imagen.setUrlImagen(dto.getUrlImagen());

        // Si no existe principal, esta será principal
        imagen.setPrincipal(!existePrincipal);

        return productoImagenRepository.save(imagen);
    }

    @Override
    public ProductoImagen uploadImagen(MultipartFile file, Long productoId, boolean isPrincipal) {
        Producto producto = repository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // 1. Generar Slug
        String slug = producto.getNombre().toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")
                .replace(" ", "-");

        // 2. Definir ruta de almacenamiento
        Path root = Paths.get("uploads/images/" + slug);
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el directorio de imágenes", e);
        }

        // 3. Determinar el siguiente número de imagen
        int imageNumber = 1;
        try (Stream<Path> files = Files.list(root)) {
            long count = files.count();
            imageNumber = (int) count + 1;
        } catch (IOException e) {
            throw new RuntimeException("Error al contar imágenes existentes", e);
        }

        // 4. Guardar archivo físico
        String fileName = producto.getNombre().toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")
                .replace(" ", "-") + "-" + imageNumber + ".jpg";
        Path destination = root.resolve(fileName);

        try {
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo de imagen", e);
        }

        // 5. Gestionar imagen principal
        if (isPrincipal) {
            productoImagenRepository.setAllNonPrincipal(productoId);
        }

        // 6. Guardar registro en DB
        ProductoImagen imagen = new ProductoImagen();
        imagen.setProducto(producto);
        imagen.setUrlImagen("products/" + slug + "/" + fileName);
        imagen.setPrincipal(isPrincipal);

        return productoImagenRepository.save(imagen);
    }
}