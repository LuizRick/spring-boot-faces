package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.model.Product;
import com.auth0.samples.bootfaces.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.io.IOException;

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
			((UIInput) ui).setValid(false);
			FacesMessage message = new FacesMessage("Minimo de 1 char");
			context.addMessage(ui.getClientId(context), message);
		}
	}

	public Product getProduct() {
		return product;
	}
}
