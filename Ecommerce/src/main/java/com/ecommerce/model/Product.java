package com.ecommerce.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecommerce.dao.ProductDAO;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;
	private Float valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product() {
	}

	public Product(String nome, Float valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public Product save() {
		ProductDAO productDao = new ProductDAO();
		return productDao.addProduct(this);
	}

	public void delete() {
		ProductDAO productDao = new ProductDAO();
		productDao.removeProduct(this);
	}

	public void update() {
		ProductDAO productDao = new ProductDAO();
		productDao.updateProduct(this);
	}

	public List listProducts() {
		String query = "select * from product order by product.id asc";
		List productList = queryProducts(query);

		return productList;
	}

	public List queryProducts(String query) {
		ProductDAO productDao = new ProductDAO();
		List queryResult = productDao.queryProduct(query);

		return queryResult;
	}

	public Product find(Integer id) {
		Product p = null;
		ProductDAO productDao = new ProductDAO();
		p = productDao.findById(id);

		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
