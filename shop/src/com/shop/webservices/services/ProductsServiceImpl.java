package com.shop.webservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.my.Products;
import com.shop.webservices.dao.HibernateProductsDao;
import com.shop.webservices.dao.ProductsDao;

@Service
public class ProductsServiceImpl implements ProductsService{

//	@Autowired
//	ProductsDao productsDao;
	
	@Autowired
	HibernateProductsDao hibernateProductsDao;
	
//	public void setProductsDao(ProductsDao productsDao) {
//		this.productsDao = productsDao;
//	}

	public void setHibernateProductsDao(HibernateProductsDao hibernateProductsDao) {
		this.hibernateProductsDao = hibernateProductsDao;
	}

	@Override
	public Products getProduct(String id) {
		Products prod = hibernateProductsDao.findById(Integer.valueOf(id));
		
		return prod;
	}

}
