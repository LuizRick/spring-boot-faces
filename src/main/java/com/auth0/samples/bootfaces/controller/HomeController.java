package com.auth0.samples.bootfaces.controller;

import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope(value = "session")
@Controller(value = "home")
@ELBeanName(value = "home")
public class HomeController {

	private String msg = "padrao";


	public String getMsg(){
		return msg;
	}


	@RequestMapping("/home")
	public String home(Model model){
		msg = "Seja bem vindo!";
		return "home.jsf";
	}
}
