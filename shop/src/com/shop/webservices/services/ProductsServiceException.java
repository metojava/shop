package com.shop.webservices.services;

import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


public class ProductsServiceException extends Exception{

	
	public ProductsServiceException(String message)
	{
		
		super(message);
	}
}
