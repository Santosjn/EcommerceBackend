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
import com.ecommerce.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {

	@RequestMapping(value = "/product/new", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product_params) {
		ProductService service = new ProductService();
		return service.save(product_params);
	}

	@RequestMapping(value = "/product/get", method = RequestMethod.GET)
	public ResponseEntity<Product> findProduct(@RequestParam(value = "id") Integer id) {
		ProductService service = new ProductService();
		Product productFound = null;
		productFound = service.find(id);

		if (productFound == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Product>(productFound, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public List<Product> listProducts() {
		ProductService service = new ProductService();
		return service.listProducts();
	}

	@RequestMapping(value = "/product/update", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product_params) {
		ProductService service = new ProductService();
		Product productFound = null;
		productFound = service.find(product_params.getId());
		if (productFound == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		service.update(product_params);

		return new ResponseEntity<Product>(product_params, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@RequestParam(value = "id") Integer id) {
		ProductService service = new ProductService();
		Product productFound = null;

		productFound = service.find(id);
		if (productFound == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		service.delete(productFound);
		return new ResponseEntity<Product>(productFound, HttpStatus.OK);
	}

}
