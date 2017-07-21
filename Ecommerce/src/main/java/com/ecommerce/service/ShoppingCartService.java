package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.ShoppingCartDAO;
import com.ecommerce.model.Product;
import com.ecommerce.model.ShoppingCart;

public class ShoppingCartService {

	public ShoppingCart save(ShoppingCart params) {
		ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
		ProductService pservice = new ProductService();
		Product p = pservice.find(params.getId());

		ShoppingCart sc = new ShoppingCart();
		sc.setProduto(p);
		sc.setQuantidade(params.getQuantidade());

		return shoppingCartDAO.addItem(sc);
	}

	public List shoppingCartItems() {
		String query = "select p.nome, p.valor, sc.id as shopping_cart_id, sc.quantidade\r\n"
				+ "from shopping_cart sc \r\n" + "join product p on p.id = sc.product_id \r\n" + "order by sc.id asc";
		List itemList = queryShoppingCartItems(query);

		return itemList;
	}

	public List queryShoppingCartItems(String query) {
		ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
		List queryResult = shoppingCartDAO.queryShoppingCart(query);

		return queryResult;
	}

	public ShoppingCart find(Integer id) {
		ShoppingCart sc = null;
		ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
		sc = shoppingCartDAO.findById(id);		
		return sc;
	}

	public void delete(ShoppingCart sc) {
		ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
		shoppingCartDAO.removeShoppingCart(sc);
	}

}
