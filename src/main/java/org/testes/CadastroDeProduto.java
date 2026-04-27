package org.testes;

import jakarta.persistence.EntityManager;
import org.dao.CategoriaDao;
import org.dao.ProdutoDao;
import org.model.Categoria;
import org.model.Produto;
import org.util.JPAUtil;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {

        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        // Busca por ID
        Produto p = produtoDao.buscarPorId(1L);
        System.out.println("Preço: " + p.getPreco());

        // Busca por nome
        List<Produto> todos = produtoDao.buscarPorNome("Iphone 16");

        todos.forEach(produto -> System.out.println("Nome: " + produto.getNome()));

        em.close();
    }

    public static void cadastrarProduto() {

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        Categoria celulares = new Categoria("CELULARES");

        Produto celularNovo = new Produto();
        celularNovo.setNome("Iphone 16");
        celularNovo.setDescricao("Iphone 16 noivinho krl");
        celularNovo.setPreco(new BigDecimal("1.00"));
        celularNovo.setCategoria(celulares);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);   // salva categoria
        produtoDao.cadastrar(celularNovo);   // salva produto

        em.getTransaction().commit();
        em.close();
    }
}
