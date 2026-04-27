package org.dao;

import jakarta.persistence.EntityManager;
import org.model.Produto;

import java.util.List;

public class ProdutoDao {
    private EntityManager em;
    public ProdutoDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }
    public void remover(Produto produto) {
        produto = em.merge(produto);
        this.em.remove(produto);
    }
    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }
    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM produto";
        return em.createQuery(jpql,Produto.class).getResultList();
    }
    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM produto WHERE nome LIKE :nome";
        return em.createQuery(jpql,Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
