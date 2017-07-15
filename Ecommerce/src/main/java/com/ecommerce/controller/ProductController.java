package com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;

@RestController
public class ProductController {

	@RequestMapping("/product")
	public Product saveProduct() {
		Product product = new Product();
		product.setNome("My product");
		product.setValor((float) 10.11);

		return product;
	}

}
