package org.dao;

import jakarta.persistence.EntityManager;
import org.model.Produto;

public class ProdutoDao {
    private EntityManager em;
    public ProdutoDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
}
