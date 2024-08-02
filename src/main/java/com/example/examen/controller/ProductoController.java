package com.example.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.modelo.Producto;
import com.example.examen.service.IProductoService;

@RestController
@RequestMapping(path="/producto")
@CrossOrigin(origins = "http://localhost:8081")
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
    //http://localhost:8080/API/v1.0/Supermaxi/producto

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> buscarPorCodigo(@RequestBody Producto pro){
        HttpHeaders cabeceras = new HttpHeaders();
        this.productoService.guardar(pro);
        cabeceras.add("data", "se encontro el producto");
        return new ResponseEntity<>(pro,cabeceras,236);
    }


}
