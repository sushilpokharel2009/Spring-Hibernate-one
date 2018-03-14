package com.stosh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stosh.model.Category;
import com.stosh.model.Product;
import com.stosh.utils.HibernateUtil;

@Repository
public class ProductDao {

public void insertProduct(Product product) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Product> getProductList(){
		try {
			List<Product> productList = new ArrayList<Product>();
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query qry = session.createQuery("from Product");			
			productList = qry.list();
			
			session.getTransaction().commit();
			session.close();
			
			return productList;
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	
public void deleteProduct(int productId) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Product product = session.load(Product.class, productId);
			session.delete(product);
			session.getTransaction().commit();
			session.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
public Product getProduct(int productId) {
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Product product = session.get(Product.class, productId);		
		session.getTransaction().commit();
		session.close();
		return product;		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

public List<Product> getProductListByCategoryId(int categoryId) {
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query qry = session.createQuery("from Product where category.categoryId =:categoryId")	;
		qry.setParameter("categoryId", categoryId);
		List<Product> productList = qry.list();
		session.getTransaction().commit();
		session.close();
		return productList;		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

public void updateProduct(Product product) {
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
					
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
