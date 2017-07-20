package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.Product;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.util.HibernateUtil;

public class ShoppingCartDAO {

	private Session session;
	private Transaction transaction;
	private List<Product> clienteList;

	public List queryShoppingCart(String sql) {

		List shoppingCartList = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			shoppingCartList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return shoppingCartList;

	}

	public ShoppingCart addItem(ShoppingCart sc) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.save(sc);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return sc;
	}

}
