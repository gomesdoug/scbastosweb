package com.scbastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImovelController {
	
	@RequestMapping("/imovel/novo")
	public String novo(){
		
		return "imovel/CadastroImovel";

	}
}
