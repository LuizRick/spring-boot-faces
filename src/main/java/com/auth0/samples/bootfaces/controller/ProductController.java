package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.model.Product;
import com.auth0.samples.bootfaces.persistence.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope(value = "session")
@Controller(value = "productController")
@ELBeanName(value = "productController")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	private Product product = new Product();

	public String save() {
		productRepository.save(product);
		product = new Product();
		//return "/produtos-load.xhtml?faces-redirect=true";
		return "/product/product-list.xhtml?faces-redirect=true";
	}

	@RequestMapping("/product")
	public String addNewProduto(){
		return "/product/product-form.jsf";
	}

	public Product getProduct() {
		return product;
	}
}
