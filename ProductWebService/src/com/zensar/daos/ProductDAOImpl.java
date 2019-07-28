package com.zensar.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.zensar.entities.Product;

/*
 * Author: Pickle Rick
 * Creation Date: 26th July 2019 10.02 AM
 * Modified Date: 26th July 2019 10.02 AM
 * Version: 1.0
 * Copyright: Zensar Technologies. All rights reserved.
 * Description: Data Access Object Interface implementor.
 * It is uses HibernateAPI to access Product Data from Database.   
 * */

public class ProductDAOImpl implements ProductDAO {

	private Session session;
	
	public ProductDAOImpl() {
		super();
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		session =  sessionFactory.openSession();
		System.out.println("DB Connection ESTD");
	}
	
	
	
	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		Transaction txTransaction =  session.beginTransaction();
		session.save(product);
		txTransaction.commit();
		System.out.println("Product Inserted");
		
		
	}

	

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		Transaction txTransaction =  session.beginTransaction();
		session.update(product);
		txTransaction.commit();
		System.out.println("Product Updated");

	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
		Transaction txTransaction =  session.beginTransaction();
		session.delete(product);
		txTransaction.commit();
		System.out.println("Product Deleted");
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return session.get(Product.class, productId);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		Query query = session.createQuery("from Product ");
		
		return query.getResultList();
	}

}
