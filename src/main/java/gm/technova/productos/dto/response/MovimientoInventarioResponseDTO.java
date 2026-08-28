package gm.technova.productos.dto.response;


import java.time.LocalDateTime;

public class MovimientoInventarioResponseDTO {
    private Integer id;
    private Long productoId;
    private String productoNombre;
    private String usuarioNombre;
    private String tipo;
    private Integer cantidad;
    private Integer stockResultante;
    private String motivo;
    private LocalDateTime fecha;

    // getters y setters de todos los campos
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public String getProductoNombre() { return productoNombre; }
    public void setProductoNombre(String productoNombre) { this.productoNombre = productoNombre; }

    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Integer getStockResultante() { return stockResultante; }
    public void setStockResultante(Integer stockResultante) { this.stockResultante = stockResultante; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}