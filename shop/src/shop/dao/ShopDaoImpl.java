package shop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import shop.domain.Products;

@Repository("shopDao")
@Transactional
public class ShopDaoImpl implements ShopDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Products> getAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Products.class);
		List products = (List<Products>) crit.list();
		return products;
	}

	@Override
	public List<Products> getPaginatedProducts(int start, int quanto) {

		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Products.class);

		crit.setFirstResult(start);
		crit.setMaxResults(quanto);
		List products = (List<Products>) crit.list();
		return products;

	}

	@Override
	public Products getProductById(String productId) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Products.class);
		crit.add(Restrictions.eqProperty("id", productId));
		List products = (List<Products>) crit.list();
		Products product = (Products) products.get(0);
		return product;
	}

	@Override
	public int deleteProduct(String productId) {

		String hql = "Delete from Products p where p.id = :id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", productId);
		int result = query.executeUpdate();

		return result;

	}

	@Override
	public void saveProduct(Products product) {

		sessionFactory.getCurrentSession().saveOrUpdateCopy(product);

	}

}
