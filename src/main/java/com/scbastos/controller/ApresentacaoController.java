package com.scbastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ApresentacaoController {
	
	
	@RequestMapping("/apresentacao")
	public String novo(){
		
		return "/apresentacao";
	}

}
