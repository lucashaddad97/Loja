package org.dao;

import jakarta.persistence.EntityManager;
import org.model.Categoria;


public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }
}
