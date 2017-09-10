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

import com.scbastos.model.Imovel;
import com.scbastos.model.Enumerators.EnumClassificacao;
import com.scbastos.model.Enumerators.EnumConservacao;
import com.scbastos.model.Enumerators.EnumDestinacao;
import com.scbastos.model.Enumerators.EnumExclusividadeImovel;
import com.scbastos.model.Enumerators.EnumSituacao;
import com.scbastos.model.Enumerators.EnumStatusImovel;
import com.scbastos.model.Enumerators.EnumTipoImovel;
import com.scbastos.repository.Usuarios;

@Controller
public class ImovelController {
	
	@Autowired
	private Usuarios usuarios;
	
	
	@RequestMapping("/imovel/novo")
	public ModelAndView novo(Imovel imovel){
		ModelAndView mv = new ModelAndView("imovel/CadastroImovel");
		mv.addObject("tipoImoveis", EnumTipoImovel.values());
		mv.addObject("destinacoes", EnumDestinacao.values());
		mv.addObject("conservacao", EnumConservacao.values());
		mv.addObject("classificacoes", EnumClassificacao.values());
		mv.addObject("situacoes", EnumSituacao.values());
		mv.addObject("statusImovel",EnumStatusImovel.values());
		mv.addObject("exclusividadeImovel",EnumExclusividadeImovel.values());
		
		mv.addObject("usuario",usuarios.findAll());
		return mv;

	}
	
	@RequestMapping(value = "/imovel/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Imovel imovel, BindingResult result, Model model, RedirectAttributes atributes){
		
		//if(result.hasErrors()){
		//	return novo(imovel);
		//}
		
		// Salvar no banco de dados
		atributes.addFlashAttribute("mensagem", "Imovel cadastrado com sucesso");
		System.out.println(">>>> CodigoSC:" + imovel.getCodigosc());
		System.out.println(">>>> Tipo do imovel:" + imovel.getTipoImovel());
		System.out.println(">>>> Exclusividade:" + imovel.getExclusividade_imovel());
		//System.out.println(">>>> DataCaptacao:" + imovel.getDataCaptacao());
		//System.out.println(">>>> usuario:" + imovel.getUsuario().getNome());
		return new ModelAndView("redirect:/imovel/novo");
		
	}
	
}//END CLASS
