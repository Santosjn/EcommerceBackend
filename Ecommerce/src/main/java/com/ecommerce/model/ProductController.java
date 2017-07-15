package com.ecommerce.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;

@RestController
public class ProductController {

	@RequestMapping("/product")
	public Product product() {		
		Product product = new Product();
		product.setNome("My product");
		product.setValor((float) 10.11);

		return product;
	}

}
