package com.produtos.bootfaces.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.component.inputtext.InputText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.produtos.bootfaces.model.Product;
import com.produtos.bootfaces.persistence.ProductRepository;

@Scope(value = "session")
@Controller(value = "productController")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	private Product product = new Product();



	public void save() throws IOException {
		productRepository.save(product);
		product = new Product();
		FacesContext.getCurrentInstance().getExternalContext().redirect("/product/product-list");
	}

	@RequestMapping("/product")
	public String addNewProduto(){
		return "/product/product-form.jsf";
	}

	public void validateModelText(FacesContext context, UIComponent ui, Object value){
		String text = (String) value;
		if(text.length() <=0 ){
			((InputText) ui).setValid(false);
			FacesMessage message = new FacesMessage("O nome do produto deve ser de no minimo de 1 char");
			context.addMessage(ui.getClientId(context), message);
		}
	}

	public Product getProduct() {
		return product;
	}
}
