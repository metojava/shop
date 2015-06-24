package com.shop.webservices.dao;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductsDaoImpl pd = new ProductsDaoImpl();
		
		System.out.print("products picture +"+pd.getProduct("1").getPhoto());

	}

}
