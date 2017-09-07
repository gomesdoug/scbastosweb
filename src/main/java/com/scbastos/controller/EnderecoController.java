package com.scbastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scbastos.model.Endereco;
import com.scbastos.repository.Bairros;
import com.scbastos.repository.Municipios;

@Controller
public class EnderecoController {
	
	@Autowired
	private Bairros bairros;
	
	@Autowired
	private Municipios municipios;
	
	@RequestMapping("/endereco/novo")
	public ModelAndView novo(Endereco endereco){
		ModelAndView mv = new ModelAndView("endereco/CadastroEndereco");
		mv.addObject("municipio",municipios.findAll());
		mv.addObject("bairro",bairros.findAll());
		
		return mv;
	}

}// END CLASS
