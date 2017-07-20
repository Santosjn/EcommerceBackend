package com.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.service.ShoppingCartService;

@CrossOrigin
@RestController
public class ShoppingCartController {

	@RequestMapping(value = "/shoppingcart/list", method = RequestMethod.GET)
	public List<Product> listProducts() {
		ShoppingCartService service = new ShoppingCartService();
		return service.shoppingCartItems();
	}

	@RequestMapping(value = "/shoppingcart/new", method = RequestMethod.POST)
	public Object saveProduct(@RequestBody ShoppingCart params) {
		ShoppingCartService service = new ShoppingCartService();
		return service.save(params);
	}

}
