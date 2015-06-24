package com.shop.webservices.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shop.my.Products;

@Repository
public class HibernateProductsDao {

	private SessionFactory sessionFactory;
	
	public HibernateProductsDao() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public void store(Products product) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.saveOrUpdate(product);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void delete(int productsId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Products product = (Products) session.get(Products.class, productsId);
			session.delete(product);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Products findById(int productsId) {
		Session session = sessionFactory.openSession();
		try {
			return (Products) session.get(Products.class, productsId);
		} finally {
			session.close();
		}
	}

	public List<Products> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Products");
			return query.list();
		} finally {
			session.close();
		}
	}
	
	
}
