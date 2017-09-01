package com.scbastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnderecoController {
	
	@RequestMapping("/endereco/novo")
	public String novo(){
		
		return "endereco/CadastroEndereco";
	}

}// END CLASS
