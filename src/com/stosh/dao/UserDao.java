package com.stosh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stosh.model.Category;
import com.stosh.model.GeneralUser;
import com.stosh.utils.HibernateUtil;

@Repository
public class UserDao {

	
	public void insertGeneralUser(GeneralUser generalUser) {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(generalUser);
			session.getTransaction().commit();
			session.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public GeneralUser verifyUser(String generalUserName, String generalUserPassword) {
		
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query qry = session.createQuery("from GeneralUser where generalUserName=:generalUserName and generalUserPassword=:generalUserPassword");			
			qry.setParameter("generalUserName", generalUserName);
			qry.setParameter("generalUserPassword", generalUserPassword);
			
			GeneralUser generalUser = (GeneralUser)qry.list().get(0);
			
			session.getTransaction().commit();
			session.close();
			
			return generalUser;
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
		
 	}
	
}
