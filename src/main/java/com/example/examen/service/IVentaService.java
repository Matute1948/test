package com.example.examen.service;

import java.util.List;

import com.example.examen.modelo.Producto;

public interface IVentaService {

    public void guardar(String numVenta, String cedula, List<Producto> productos);
    
}
