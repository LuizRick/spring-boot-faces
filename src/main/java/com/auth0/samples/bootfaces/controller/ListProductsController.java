package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.model.Product;
import com.auth0.samples.bootfaces.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Scope (value = "session")
@Controller(value = "listProducts")
public class ListProductsController {
	@Autowired
	private ProductRepository productRepository;

	private List<Product> products;


	public void loadData() {
		products = productRepository.findAll();
	}

	@RequestMapping("/product/product-list")
	public String listarProdutos(){
		loadData();
		return "/product/product-list.jsf";
	}

	public List<Product> getProducts() {
		return products;
	}

	public String delete(Product product) {
		productRepository.delete(product.getId());
		loadData();
		return null;
	}
}
