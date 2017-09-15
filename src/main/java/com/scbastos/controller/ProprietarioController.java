package com.scbastos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.scbastos.model.Proprietario;
import com.scbastos.service.CadastroProprietarioService;

@Controller
public class ProprietarioController {
	
	
	@Autowired
	private CadastroProprietarioService cadastroProprietarioService;
	
			
	@RequestMapping("/proprietario/novo")
	public ModelAndView novo(Proprietario proprietario) {
		ModelAndView mv = new ModelAndView("proprietario/CadastroProprietario");
		return mv;
	}
	
	@RequestMapping(value = "/proprietario/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Proprietario proprietario, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			return novo(proprietario);
		}
		
		// Salvar no banco de dados
		cadastroProprietarioService.salvarProprietario(proprietario);
		atributes.addFlashAttribute("mensagem", "Proprietário cadastrado com sucesso");
		return new ModelAndView("redirect:/endereco/novo");
		
	}
	
}//END CLASS
