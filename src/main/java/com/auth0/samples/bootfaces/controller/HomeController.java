package com.auth0.samples.bootfaces.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope(value = "session")
@Controller(value = "home")
@ELBeanName(value = "home")
public class HomeController {

	@RequestMapping("/home")
	public String home(){
		return "home.jsf";
	}
}
