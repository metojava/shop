package com.shop.webservices.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.shop.webservices.getproductsservices.GetProductsRequest;
import com.shop.webservices.getproductsservices.GetProductsResponse;
import com.shop.webservices.services.ProductsService;

@Endpoint
public class ProductsEndpoint {

	private static final String GET_TARGET_NAMESPACE = "http://com/shop/webservices/getProductsServices";

	@Autowired
	private ProductsService productsService;

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	@PayloadRoot(localPart = "GetProductsRequest", namespace = GET_TARGET_NAMESPACE)
	public @ResponsePayload
	GetProductsResponse getUserDetails(
			@RequestPayload GetProductsRequest request) {
		System.out.println("Get Product !");
		GetProductsResponse response = new GetProductsResponse();
		try {
			response.setProductDetails(productsService.getProduct(request
					.getProductId()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

}
