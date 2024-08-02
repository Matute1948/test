package com.example.examen.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(generator = "seq_detalle_venta", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_detalle_venta", sequenceName = "seq_detalle_venta", allocationSize = 1)
    @Column(name = "deta_id")
    private Integer deta_id;
    @Column(name = "deta_cantidad")
    private Integer cantidad;
    @Column(name = "deta_precio_uni")
    private BigDecimal precioUnitario;
    @Column(name = "deta_subtotal")
    private BigDecimal subtotal;
    @ManyToOne
    @JoinColumn(name = "deta_id_venta")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "dtea_id_producto")
    private Producto producto;
    public Integer getDeta_id() {
        return deta_id;
    }
    public void setDeta_id(Integer deta_id) {
        this.deta_id = deta_id;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    public Venta getVenta() {
        return venta;
    }
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    @Override
    public String toString() {
        return "DetalleVenta [deta_id=" + deta_id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
                + ", subtotal=" + subtotal + ", venta=" + venta + ", producto=" + producto + "]";
    }

    
}
