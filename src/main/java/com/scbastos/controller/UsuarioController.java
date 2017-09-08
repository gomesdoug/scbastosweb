package com.scbastos.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scbastos.model.Usuario;

@Controller
public class UsuarioController {
	
	@RequestMapping("/usuario/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		return mv;
		
	}
	
	@RequestMapping(value = "/usuario/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			return novo(usuario);
		}
		
		// Salvar no banco de dados
		atributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso");
		System.out.println(">>>> cadastrar:" + usuario.getNome());
		return new ModelAndView("redirect:/usuario/novo");
		
	}

}
