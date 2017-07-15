package com.ecommerce.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Product productFound = new Product();
		assertEquals(p.getId(), productFound.find(p.getId()).getId());
	}

	@Test
	public void testDeleteProduct() {
		p.setNome("Other Lamp");
		p.setValor((float) 31.55);
		p.delete();

		Product productFound = new Product();
		assertEquals(null, productFound.find(p.getId()));
	}

	@Test
	public void testUpdateProduct() {
		p.setNome("One Lamp");
		p.setValor((float) 11.27);
		p.save();

		Product productFound = new Product();

		assertEquals("One Lamp", productFound.find(p.getId()).getNome());
		assertEquals("11.27", productFound.find(p.getId()).getValor().toString());

		p.setNome("Third Lamp");
		p.setValor((float) 35.25);
		p.update();
		assertEquals("Third Lamp", productFound.find(p.getId()).getNome());
	}

	@Test
	public void testListProducts() {
		Product p1 = new Product("Lamp 1", (float) 25.77);
		p1.save();
		Product p2 = new Product("Lamp 2", (float) 33.21);
		p2.save();

		List<?> productList = p.listProducts();

		assertEquals(2, productList.size());

		p1.delete();
		p2.delete();
	}

}
