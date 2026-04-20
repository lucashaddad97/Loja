package org.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.dao.CategoriaDao;
import org.dao.ProdutoDao;
import org.model.Categoria;
import org.model.Produto;
import org.util.JPAUtil;

import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");


       EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(celulares);



        em.getTransaction().commit();
        em.close();

    }

}
