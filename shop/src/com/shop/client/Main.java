package com.shop.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.shop.my.Products;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"client.xml");
		ProductsClient client = (ProductsClient)ctx.getBean("client");
		try
		{
		Products pd = client.getProduct("1");
		System.out.print("product + "+pd.getDescr());
		}
		catch(SoapFaultClientException ex)
		{
			ex.printStackTrace();
			
		}
		

	}

}
