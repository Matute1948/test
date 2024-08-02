package com.example.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.modelo.Producto;
import com.example.examen.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void guardar(Producto producto) {
        // TODO Auto-generated method stub
        Producto p = this.productoRepository.seleccionar(producto.getCodigoBarras());

        if(p == null){
            this.productoRepository.instertar(producto);
        }else{
            Integer auxCant = p.getStock();
            p.setStock(auxCant+producto.getStock());
            this.productoRepository.actualizar(p);
        }
    }

    @Override
    public Producto buscar(String codigo) {
        return this.productoRepository.seleccionar(codigo);
        
    }

    @Override
    public void actualizar(Producto producto) {
        // TODO Auto-generated method stub
        this.productoRepository.actualizar(producto);
    }
    
}
