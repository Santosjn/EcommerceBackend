package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;

@RestController
public class ProductController {

	@RequestMapping(value = "/product/new", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product params) {
		Product product = new Product();
		product.setNome(params.getNome());
		product.setValor(params.getValor());
		product.save();

		return product;
	}

	@RequestMapping(value = "/product/get", method = RequestMethod.GET)
	public ResponseEntity<Product> findProduct(@RequestParam(value = "id") Integer id) {
		Product productFound = null;
		productFound = new Product().find(id);

		if (productFound == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Product>(productFound, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public List<Product> listProducts() {
		Product product = new Product();
		return product.listProducts();
	}

	@RequestMapping(value = "/product/update", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@RequestBody Product params) {
		Product product = new Product();
		Product productFound = null;
		productFound = product.find(params.getId());
		if (productFound == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		productFound.setNome(params.getNome());
		productFound.setValor(params.getValor());
		productFound.update();

		return new ResponseEntity<Product>(productFound, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@RequestParam(value = "id") Integer id) {
		Product product = new Product();
		Product productFound = null;

		productFound = product.find(id);
		if (productFound == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		productFound.delete();
		return new ResponseEntity<Product>(productFound, HttpStatus.OK);
	}

}
