package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.Product;
import com.ecommerce.util.HibernateUtil;

public class ProductDAO {

	private Session session;
	private Transaction transaction;
	private List<Product> clienteList;

	public List<Product> getClienteList() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Product.class);
		this.clienteList = criteria.list();

		session.close();
		return clienteList;
	}

	public void addProduct(Product p) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			p.setNome(p.getNome());
			p.setValor(p.getValor());
			session.save(p);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void removeProduct(Product p) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.delete(p);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void updateProduct(Product p) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.update(p);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public List queryProduct(String sql) {

		List productList = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			productList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return productList;

	}

}
