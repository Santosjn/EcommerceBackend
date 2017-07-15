package com.ecommerce.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ecommerce.model.Product;

public class ProductTest {

	Product p = null;

	@Before
	public void before() {
		p = new Product();
	}

	@After
	public void after() {
		if (p != null) {
			p.delete();
		}
	}

	@Test
	public void testSaveProduct() {
		p.setNome("Lamp");
		p.setValor((float) 20.55);
		p.save();
	}

	@Test
	public void testDeleteProduct() {
		p.setNome("Other Lamp");
		p.setValor((float) 31.55);

		p.delete();
	}

	// @Test
	// public void testUpdateProduct() {
	// p.setNome("Third Lamp");
	// p.setValor((float) 35.25);
	// p.update();
	// }

	@Test
	public void testListProducts() {
		Product p1 = new Product("Lamp 1", (float) 25.77);
		p1.save();
		Product p2 = new Product("Lamp 2", (float) 33.21);
		p2.save();
		
		List productList = p.listProducts();

		System.out.println(productList);
		
		p1.delete();
		p2.delete();
	}

}
