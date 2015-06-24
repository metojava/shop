package com.shop.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.shop.my.Products;
import com.shop.webservices.getproductsservices.GetProductsRequest;
import com.shop.webservices.getproductsservices.GetProductsResponse;

public class ProductsClientImpl extends WebServiceGatewaySupport implements
		ProductsClient {

	@Override
	public Products getProduct(String id) {

		GetProductsRequest request = new GetProductsRequest();
		request.setProductId(id);
		GetProductsResponse response = (GetProductsResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);

		return response.getProductDetails();
	}

}
