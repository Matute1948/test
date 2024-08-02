package com.example.examen.repository;

import org.springframework.stereotype.Repository;

import com.example.examen.modelo.DetalleVenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DetalleRepositoryImpl implements IDetalleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(DetalleVenta detalleVenta) {
        // TODO Auto-generated method stub
        this.entityManager.persist(detalleVenta);
    }

    
}
