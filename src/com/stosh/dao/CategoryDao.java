package com.stosh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stosh.model.Category;
import com.stosh.utils.HibernateUtil;

@Repository
public class CategoryDao {

	
	public void insertCategory(Category category) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Category> getCategoryList(){
		try {
			List<Category> categoryList = new ArrayList<Category>();
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query qry = session.createQuery("from Category");			
			categoryList = qry.list();
			
			session.getTransaction().commit();
			session.close();
			
			return categoryList;
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
public void deleteCategory(int categoryId) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Category category = session.load(Category.class, categoryId);
			session.delete(category);
			session.getTransaction().commit();
			session.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
public Category getCategory(int categoryId) {
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Category category = session.get(Category.class, categoryId);		
		session.getTransaction().commit();
		session.close();
			return category;		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

public void updateCategory(Category category) {
	
	try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Category category1 = session.load(Category.class, category.getCategoryId());
		category1.setCategoryName(category.getCategoryName());
		session.update(category1);
		session.getTransaction().commit();
		session.close();
					
	}catch(Exception e) {
		e.printStackTrace();
	}
}


	
	
}
