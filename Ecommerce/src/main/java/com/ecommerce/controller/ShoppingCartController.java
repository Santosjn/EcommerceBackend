package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/shoppingcart/delete", method = RequestMethod.DELETE)
	public ResponseEntity<ShoppingCart> deleteShoppingCartItem(@RequestParam(value = "id") Integer id) {
		ShoppingCartService service = new ShoppingCartService();
		ShoppingCart sc_found = null;

		sc_found = service.find(id);		
		if (sc_found == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		service.delete(sc_found);
		return new ResponseEntity<ShoppingCart>(HttpStatus.OK);

	}

}
