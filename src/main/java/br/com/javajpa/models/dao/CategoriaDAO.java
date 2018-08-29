package br.com.javajpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.javajpa.connection.ConnectionFactory;
import br.com.javajpa.models.Categoria;

public class CategoriaDAO {
	

	public Categoria save(Categoria c) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		//Insert into
		try {
			em.getTransaction().begin();
			if(c.getId() == null) {
				em.persist(c);
			//update
			}else {
				em.merge(c);
			}
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return c;
	}
	
	//Select 1 ID
	public Categoria findById(Integer id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Categoria categoria = null;
		
		try {
			categoria = em.find(Categoria.class, id);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return categoria;
	}
	
	//Select all ID's
	public List<Categoria> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Categoria> categorias = null;
		
		try {
			categorias = em.createQuery("from Categoria").getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		return categorias;
	}
	
	//Remove
	
	public Categoria remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Categoria categoria = null;
		try {
			categoria = em.find(Categoria.class, id);
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return categoria;
	}
	
}
