package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import shop.dao.ShopDao;
import shop.domain.Products;

@Component
@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Override
	public List<Products> getAll() {

		List<Products> products = shopDao.getAll();
		return products;
	}

	@Override
	public List<Products> getPaginatedProducts(int start, int quanto) {
		List<Products> products = shopDao.getPaginatedProducts(start, quanto);
		return products;
	}

	@Override
	public Products getProductById(String productId) {

		Products product = shopDao.getProductById(productId);
		return product;
	}

	@Override
	public int deleteProduct(String productId) {
		int res = shopDao.deleteProduct(productId);
		return res;
	}

	@Override
	public void saveProduct(Products product) {

		shopDao.saveProduct(product);

	}

}
