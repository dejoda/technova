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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Service
public class ProductoImagenImpl implements ProductoImagenService {

    @Autowired
    private ProductoImagenRepository productoImagenRepository;

    @Autowired
    private ProductoRepository repository;

    @Override
    public Page<ProductoImagen> listarImagenesPorProducto(Long idProducto, Pageable pageable) {
        return productoImagenRepository.findByProductoIdProducto(idProducto, pageable);
    }

    @Override
    public ProductoImagen agregarImagen(ProductoImagenInputDTO dto) {
        Producto producto = repository.findById(dto.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        boolean existePrincipal = productoImagenRepository.existsPrincipal(producto);
        ProductoImagen imagen = new ProductoImagen();
        imagen.setProducto(producto);
        imagen.setUrlImagen(dto.getUrlImagen());
        imagen.setPrincipal(!existePrincipal);

        return productoImagenRepository.save(imagen);
    }

    @Override
    @Transactional
    public ProductoImagen uploadImagen(MultipartFile file, Long productoId, boolean isPrincipal) {
        Producto producto = repository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // 1. Generar Slug Limpio (Remover prefijos genéricos como "Laptop", "Mouse", etc.)
        String rawName = producto.getNombre();
        String[] genericPrefixes = {"laptop", "mouse", "teclado", "monitor", "auriculares", "impresora", "silla", "mesa"};

        String processedName = rawName.toLowerCase();
        for (String prefix : genericPrefixes) {
            if (processedName.startsWith(prefix + " ")) {
                processedName = processedName.substring(prefix.length()).trim();
                break;
            }
        }

        String productSlug = processedName
                .replaceAll("[^a-z0-9 ]", "")
                .replace(" ", "-");

        // 2. Definir ruta de almacenamiento
        Path root = Paths.get("uploads/images/products/" + productSlug);
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el directorio de imágenes", e);
        }

        // 3. Determinar el siguiente número de imagen
        int imageNumber = 1;
        try (Stream<Path> files = Files.list(root)) {
            OptionalInt maxNum = files
                .map(path -> path.getFileName().toString())
                .filter(name -> name.endsWith(".jpg"))
                .map(name -> {
                    Pattern p = Pattern.compile("-(\\d+)\\.jpg$");
                    Matcher m = p.matcher(name);
                    return m.find() ? Integer.parseInt(m.group(1)) : 0;
                })
                .mapToInt(Integer::valueOf)
                .max();
            if (maxNum.isPresent()) imageNumber = maxNum.getAsInt() + 1;
        } catch (IOException e) {
            throw new RuntimeException("Error al procesar imágenes existentes", e);
        }

        // 4. Guardar archivo físico (Forzar siempre .jpg)
        String fileName = productSlug + "-" + imageNumber + ".jpg";
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
        ProductoImagen imagenRecord = new ProductoImagen();
        imagenRecord.setProducto(producto);
        imagenRecord.setUrlImagen("images/products/" + productSlug + "/" + fileName);
        imagenRecord.setPrincipal(isPrincipal);

        return productoImagenRepository.save(imagenRecord);
    }

    @Override
    @Transactional
    public void updatePrincipal(Long imagenId, boolean isPrincipal) {
        ProductoImagen imagen = productoImagenRepository.findById(imagenId)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));

        if (isPrincipal) {
            productoImagenRepository.setAllNonPrincipal(imagen.getProducto().getIdProducto());
        }

        imagen.setPrincipal(isPrincipal);
        productoImagenRepository.save(imagen);
    }

    @Override
    @Transactional
    public void eliminarImagen(Long imagenId) {
        ProductoImagen imagen = productoImagenRepository.findById(imagenId)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));

        String url = imagen.getUrlImagen();
        if (url != null) {
            String physicalPath = url.replace("images/products/", "uploads/images/products/");
            try {
                Files.deleteIfExists(Paths.get(physicalPath));
            } catch (IOException e) {
                System.err.println("Error al borrar archivo físico: " + e.getMessage());
            }
        }
        productoImagenRepository.delete(imagen);
    }
}
