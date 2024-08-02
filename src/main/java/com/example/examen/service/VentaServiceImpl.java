package com.example.examen.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.modelo.DetalleVenta;
import com.example.examen.modelo.Producto;
import com.example.examen.modelo.Venta;
import com.example.examen.repository.IProductoRepository;
import com.example.examen.repository.IVentaRepository;

@Service
public class VentaServiceImpl implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void guardar(String numVenta, String cedula, List<Producto> productos) {
        Venta ven = new Venta();
        BigDecimal total = new BigDecimal(0);
        ven.setCedula(cedula);
        ven.setNumVenta(numVenta);

        List<DetalleVenta> listDtv = new ArrayList<DetalleVenta>();

        for (Producto producto : productos) {
            Producto p = this.productoRepository.seleccionar(producto.getCodigoBarras());
            DetalleVenta dtv = new DetalleVenta();
            Integer auxCan = dtv.getCantidad();
            dtv.setCantidad(auxCan-producto.getStock());
            dtv.setPrecioUnitario(p.getPrecio());
            dtv.setSubtotal(p.getPrecio().multiply(new BigDecimal(producto.getStock())));
            dtv.setProducto(producto);
            dtv.setVenta(ven);
            total = total.add(dtv.getSubtotal());
            listDtv.add(dtv);
        }

        ven.setDetallesVenta(listDtv);


        this.ventaRepository.insertar(ven);
    }
    
}
