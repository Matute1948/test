package com.example.examen.repository;

import com.example.examen.modelo.Producto;

public interface IProductoRepository {
    
    public void instertar(Producto producto);
    public Producto seleccionar(String codigo);
    public void actualizar(Producto producto);

}
