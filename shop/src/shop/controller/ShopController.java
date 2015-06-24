package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.client.ProductsClient;

import shop.domain.Products;
import shop.service.ShopService;

@Controller
public class ShopController {

	private ProductsClient productsClient;
	
//public void setProductsClient(ProductsClient productsClient) {
//	ApplicationContext ctx = new ClassPathXmlApplicationContext(
//			"client.xml");
//	ProductsClient client = (ProductsClient)ctx.getBean("client");
//		this.productsClient = client;
//		
//	}

public void setProductsClient(ProductsClient productsClient) {
		this.productsClient = productsClient;
	}

@Autowired
private ShopService shopService;

@RequestMapping("/products")
public ModelAndView products()
{
	com.shop.my.Products prod = productsClient.getProduct("1");
	ModelAndView mv = new ModelAndView("products");
	List<Products> prods = shopService.getAll();
	int esa = prods.size();
	mv.addObject("esa", esa);
	System.out.println(esa);
	if(esa>0)
	mv.addObject("prods", prods);
	mv.addObject("prod", prod);
	return mv;
}

@RequestMapping("product/{productId}")
public ModelAndView product(@PathVariable("productId") String productId)
{
	ModelAndView mv = new ModelAndView("product");
	Products prod = shopService.getProductById(productId);
	mv.addObject("prod", prod);
	
	return mv;
}


}
	

