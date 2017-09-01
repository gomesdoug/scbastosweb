package com.scbastos.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scbastos.model.Proprietario;
import com.scbastos.repository.Proprietarios;

@Controller
public class ProprietarioController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProprietarioController.class);
	
	//BUSCAR DO REPOSITORIO
	@Autowired
	private Proprietarios proprietarios;
			
			
	@RequestMapping("/proprietario/novo")
	public String novo(Proprietario proprietario) {
		
		if(logger.isDebugEnabled() ){
			logger.debug("O objeto: " + proprietario);
		}
		
		proprietarios.findAll();//teste e apagar
		return "proprietario/CadastroProprietario";
	}
	
	@RequestMapping(value = "/proprietario/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Proprietario proprietario, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			return novo(proprietario);
		}
		
		atributes.addFlashAttribute("mensagem", "Cerveja cadastrada com sucesso");
		System.out.println(">>>> cadastrar:" + proprietario.getNome());
		return "redirect:/proprietario/novo";
		
	}
	
	@RequestMapping("/proprietario/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}

}//END CLASS
