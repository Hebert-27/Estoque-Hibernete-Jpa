package br.com.javajpa.tests;

import br.com.javajpa.models.Produto;
import br.com.javajpa.models.dao.CategoriaDAO;
import br.com.javajpa.models.dao.ProdutoDAO;

public class CategoriaTest {
	
	public static void main(String[] args) {
		
		ProdutoDAO daoP = new ProdutoDAO();
		/*CategoriaDAO daoC = new CategoriaDAO();
		
		
		Categoria c = new Categoria();
		
		c.setId(4);
		
		p.setDescricao("Arroz");
		p.setQtd(5);
		p.setValor(4.20);
		p.setCategoria(c);
		
		
		daoP.save(p);*/
		for(Produto p: daoP.findAll()) {
			System.out.println("Descrição: "+p.getDescricao());
		
		}
		
		/*Produto p = daoP.findById(1);
		
		System.out.println("Descrição: " +p.getDescricao());
		System.out.println("Quantidade: " +p.getQtd());
		System.out.println("Valor: " +p.getValor());
		System.out.println("Categoria: " +p.getCategoria().getDescricao());*/
	}
}
