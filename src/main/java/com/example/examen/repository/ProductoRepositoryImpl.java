package com.example.examen.repository;

import org.springframework.stereotype.Repository;

import com.example.examen.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void instertar(Producto producto) {
        // TODO Auto-generated method stub
        entityManager.persist(producto);
    }

    @Override
    public Producto seleccionar(String codigo) {
        try {
            TypedQuery<Producto> mQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigo", Producto.class);
            mQuery.setParameter("codigo", codigo);
            return mQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void actualizar(Producto producto) {
        // TODO Auto-generated method stub
        Query query = this.entityManager.createQuery("UPDATE Producto p SET p.stock = :nuevoStock WHERE p.codigoBarras = :codigoBarras");
        query.setParameter("codigoBarras", producto.getCodigoBarras());
        query.setParameter("nuevoStock", producto.getStock());
        query.executeUpdate();
    }

    

    
}
