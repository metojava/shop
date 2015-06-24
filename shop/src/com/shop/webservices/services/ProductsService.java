package com.shop.webservices.services;

import com.shop.my.Products;

public interface ProductsService  {

	public Products getProduct(String id)throws ProductsServiceException;
	
}
