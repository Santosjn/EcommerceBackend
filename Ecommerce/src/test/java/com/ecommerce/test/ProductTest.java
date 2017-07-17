package com.ecommerce.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

public class ProductTest {

	ProductService service = null;
	Product savedProduct = null;

	@Before
	public void before() {
		service = new ProductService();
	}

	@After
	public void after() {
		if (savedProduct != null) {
			Product productFound = service.find(savedProduct.getId());
			if (productFound != null) {
				service.delete(productFound);
			}
		}
	}

	@Test
	public void testSaveProduct() {
		Product p = new Product();
		p.setNome("Lamp");
		p.setValor((float) 20.55);

		savedProduct = service.save(p);
		assertEquals(savedProduct.getId(), service.find(savedProduct.getId()).getId());
	}

	@Test
	public void testDeleteProduct() {
		Product p = new Product();
		p.setNome("Other Lamp");
		p.setValor((float) 31.55);
		savedProduct = service.save(p);

		service.delete(savedProduct);
		assertEquals(null, service.find(savedProduct.getId()));
	}

	@Test
	public void testUpdateProduct() {
		Product p = new Product();
		p.setNome("One Lamp");
		p.setValor((float) 11.27);
		savedProduct = service.save(p);

		assertEquals("One Lamp", service.find(savedProduct.getId()).getNome());
		assertEquals("11.27", service.find(savedProduct.getId()).getValor().toString());

		savedProduct.setNome("Third Lamp");
		savedProduct.setValor((float) 35.25);
		service.update(savedProduct);
		assertEquals("Third Lamp", service.find(savedProduct.getId()).getNome());
	}

	@Test
	public void testListProducts() {
		Product p1 = new Product("Lamp 1", (float) 25.77);
		Product saved1 = service.save(p1);
		Product p2 = new Product("Lamp 2", (float) 33.21);
		Product saved2 = service.save(p2);

		List<?> productList = service.listProducts();

		assertEquals(2, productList.size());

		service.delete(saved1);
		service.delete(saved2);
	}

}
