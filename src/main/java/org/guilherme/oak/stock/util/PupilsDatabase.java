package org.guilherme.oak.stock.util;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.guilherme.oak.stock.model.Product;

public class PupilsDatabase {

	public static void main(String[] args) {

		Product product1 = new Product();
		product1.setName("Apliques");
		product1.setImagePath("/stock/Assets/imagens/apliques.jpg");
		product1.setPrice(new BigDecimal(5.99));
		product1.setProvider("Zayne");
		product1.setRegistrationDate(Calendar.getInstance());

		Product product2 = new Product();
		product2.setName("Boneca");
		product2.setImagePath("/stock/Assets/imagens/boneca.jpg");
		product2.setPrice(new BigDecimal(3.99));
		product2.setProvider("Zayne");
		product2.setRegistrationDate(Calendar.getInstance());

		Product product3 = new Product();
		product3.setName("Capinha");
		product3.setImagePath("/stock/Assets/imagens/capinha.jpg");
		product3.setPrice(new BigDecimal(3.99));
		product3.setProvider("Zayne");
		product3.setRegistrationDate(Calendar.getInstance());

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);
		em.getTransaction().commit();

		em.close();

	}

}
