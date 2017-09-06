package com.scbastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValorImovelController {
	
	@RequestMapping("/valores/novo")
	public String novo(){
		
		return "valores/cadastroValoresImovel";
	}

}//END CLASS
