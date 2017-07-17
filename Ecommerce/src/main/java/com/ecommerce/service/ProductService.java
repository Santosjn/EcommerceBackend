package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;

public class ProductService {

	public Product save(Product product_params) {
		Product product = new Product();
		product.setNome(product_params.getNome());
		product.setValor(product_params.getValor());

		ProductDAO productDao = new ProductDAO();
		return productDao.addProduct(product);
	}

	public void delete(Product product) {
		ProductDAO productDao = new ProductDAO();
		productDao.removeProduct(product);
	}

	public void update(Product product) {
		ProductDAO productDao = new ProductDAO();
		productDao.updateProduct(product);
	}

	public List listProducts() {
		String query = "select * from product order by product.id asc";
		List productList = queryProducts(query);

		return productList;
	}

	public List queryProducts(String query) {
		ProductDAO productDao = new ProductDAO();
		List queryResult = productDao.queryProduct(query);

		return queryResult;
	}

	public Product find(Integer id) {
		Product p = null;
		ProductDAO productDao = new ProductDAO();
		p = productDao.findById(id);

		return p;
	}

}
