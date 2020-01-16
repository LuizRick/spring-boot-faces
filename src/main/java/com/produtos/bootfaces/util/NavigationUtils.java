package com.produtos.bootfaces.util;

import java.io.IOException;

import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component(value="navigationUtils")
public class NavigationUtils {

	public void redirect(String url) throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect(url);
	}
}
