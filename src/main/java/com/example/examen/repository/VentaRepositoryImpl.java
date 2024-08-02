package com.example.examen.repository;

import org.springframework.stereotype.Repository;
import com.example.examen.modelo.Venta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Venta venta) {
        // TODO Auto-generated method stub
        entityManager.persist(venta);
    }

    @Override
    public Venta seleccionar(String numVenta) {
        // TODO Auto-generated method stub
        TypedQuery<Venta> mQuery = this.entityManager.createQuery("SELECT v FROM Venta v WHERE v.nomVenta =:nomVenta",Venta.class);
        mQuery.setParameter("numVenta", numVenta);
        return mQuery.getSingleResult();
    }
    
}
