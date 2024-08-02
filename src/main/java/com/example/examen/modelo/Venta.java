package com.example.examen.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(generator = "seq_venta", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_venta", sequenceName = "seq_venta", allocationSize = 1)
    @Column(name = "ven_id")
    private Integer id;
    @Column(name = "ven_numero_venta")
    private String numVenta;
    @Column(name = "ven_cedula_cliente")
    private String cedula;
    @Column(name = "ven_total")
    private BigDecimal totalVenta;
    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detallesVenta;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumVenta() {
        return numVenta;
    }
    public void setNumVenta(String numVenta) {
        this.numVenta = numVenta;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public BigDecimal getTotalVenta() {
        return totalVenta;
    }
    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }
    public List<DetalleVenta> getDetallesVenta() {
        return detallesVenta;
    }
    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }
    @Override
    public String toString() {
        return "Venta [id=" + id + ", numVenta=" + numVenta + ", cedula=" + cedula + ", totalVenta=" + totalVenta
                + ", detallesVenta=" + detallesVenta + "]";
    }

    
    
}
