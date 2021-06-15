package com.domain;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.domain.model.Product;
import com.domain.util.HibernateUtilities;

public class Application {
	// Create the session factory
	SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
	Session session = sessionFactory.openSession();

	public static void main(String[] args) {
		Application application = new Application();
//		application.saveProduct();
		application.getProducts();
		application.updateProduct("P02", "mongoose");
		application.getProducts();
		application.deleteProduct("P02");
		application.getProducts();
	}

	private void saveProduct() {
		session.beginTransaction();
		Product product = new Product();
		product.setProductId("P02");
		product.setProductName("Spring");
		session.save(product);
		session.getTransaction().commit();
	}

	private void getProducts() {
		session.beginTransaction();
		Query selectQuery = session.createQuery("FROM Product");
		List<Product> Products = (List<Product>) selectQuery.list();
		session.getTransaction().commit();
		for (Product Product : Products) {
			System.out.println(Product);
		}
	}

	private void updateProduct(String productId, String productName) {
		session.beginTransaction();
		Product Product = (Product) session.get(Product.class, productId);
		Product.setProductName(productName);
		session.getTransaction().commit();
	}

	private void deleteProduct(String productId) {
		session.beginTransaction();
		Product Product = (Product) session.get(Product.class, productId);
		session.delete(Product);
		session.getTransaction().commit();
	}
}
