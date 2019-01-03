package org.guilherme.oak.stock.service;

import java.util.List;

import javax.persistence.EntityManager;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.guilherme.oak.stock.model.Product;
import org.guilherme.oak.stock.util.JPAUtil;

public class ProductService {

	private JPAUtil JPAEM = new JPAUtil();
	private EntityManager em = JPAEM.getEntityManager();

	public List<Product> products() {
		try {
			String query = "select l from Product l";
			List<Product> products = em.createQuery(query, Product.class).getResultList();
			em.close();
			return products;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}

	}
		
	public Product productById(long id) {
		try {
			Product product = em.find(Product.class, id);
			em.close();
			return product;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}		
	}
	
	public Response record(Product productObject) {
		try {
			em.getTransaction().begin();
			em.persist(productObject);
			em.getTransaction().commit();
			em.close();
			return Response.status(200).entity("Done").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	public Response update(Product productObject) {
		try {
			em.getTransaction().begin();
			em.merge(productObject);
			em.getTransaction().commit();
			em.close();
			return Response.status(200).entity("Done").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}	
	
	public Response remove(long id) {
		try {
			Product product = em.find(Product.class, id);
			em.getTransaction().begin();
			em.remove(product);
			em.getTransaction().commit();
			em.close();
			return Response.status(200).entity("Done").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}		
	}

}
