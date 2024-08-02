package com.example.examen.repository;

import com.example.examen.modelo.Venta;

public interface IVentaRepository {

    public void insertar(Venta venta);
    public Venta seleccionar(String numVenta);
    
    
}
