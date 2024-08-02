package com.example.examen.service;

import com.example.examen.modelo.Producto;

public interface IProductoService {

    public void guardar(Producto producto);
    public Producto buscar(String codigo);
    public void actualizar(Producto producto);
    
}
