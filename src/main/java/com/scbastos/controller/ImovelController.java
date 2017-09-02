package com.scbastos.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scbastos.model.Classificacao;
import com.scbastos.model.Conservacao;
import com.scbastos.model.Destinacao;
import com.scbastos.model.Imovel;
import com.scbastos.model.Situacao;
import com.scbastos.model.TipoImovel;

@Controller
public class ImovelController {
	
	@RequestMapping("/imovel/novo")
	public ModelAndView novo(Imovel imovel){
		ModelAndView mv = new ModelAndView("imovel/CadastroImovel");
		mv.addObject("tipoImoveis", TipoImovel.values());
		mv.addObject("destinacoes", Destinacao.values());
		mv.addObject("conservacao", Conservacao.values());
		mv.addObject("classificacoes", Classificacao.values());
		mv.addObject("situacoes", Situacao.values());
		return mv;

	}
	
	@RequestMapping(value = "/imovel/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Imovel imovel, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			return novo(imovel);
		}
		
		// Salvar no banco de dados
		atributes.addFlashAttribute("mensagem", "Imovel cadastrado com sucesso");
		System.out.println(">>>> cadastrar:" + imovel.getCodigocs());
		return new ModelAndView("redirect:/imovel/novo");
		
	}
	
}//END CLASS
