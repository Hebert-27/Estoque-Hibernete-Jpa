package br.com.javajpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.javajpa.connection.ConnectionFactory;
import br.com.javajpa.models.Categoria;
import br.com.javajpa.models.Produto;

public class ProdutoDAO {
	
public Produto save(Produto p) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		//Insert into
		try {
			em.getTransaction().begin();
			if(p.getId() == null) {
				em.persist(p);
			//update
			}else {
				em.merge(p);
			}
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return p;
	}

	public Produto findById(Integer id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;
		
		try {
			produto = em.find(Produto.class, id);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return produto;
	}
	
	public List<Produto> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Produto> produtos = null;
		
		try {
			produtos = em.createQuery("from Produto").getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return produtos;
	}
}
