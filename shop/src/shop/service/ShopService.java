package shop.service;

import java.util.List;

import shop.domain.Products;

public interface ShopService {



		public List<Products> getAll();
		public List<Products> getPaginatedProducts(int start,int quanto);
		public Products getProductById(String productId);
		public int deleteProduct(String productId);
		public void saveProduct(Products product);
	

}
