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
import com.scbastos.exceptions.UsuarioCpfExpetion;
import com.scbastos.exceptions.UsuarioEmailExpetion;
import com.scbastos.model.Usuario;
import com.scbastos.model.Enumerators.EnumStatusUsuario;
import com.scbastos.service.CadastroUsuarioService;

@Controller
public class UsuarioController {
	
	
	@Autowired
	CadastroUsuarioService cadastroUsuarioService;
	
	@RequestMapping("/usuario/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		
		mv.addObject("EnumStatusUsuario", EnumStatusUsuario.values());
		
		return mv;
		
	}
	
	@RequestMapping(value = "/usuario/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			System.out.println("TEM ERRO !!!! ");
			return novo(usuario);
		}
		
		// Salvar no banco de dados
		
		
		try {
				cadastroUsuarioService.salvarUsuario(usuario);
				
		} catch (UsuarioCpfExpetion cpf) {
				result.rejectValue("cpf",cpf.getMessage(), cpf.getMessage());
				return novo(usuario);
		} catch(UsuarioEmailExpetion email){
				result.rejectValue("email",email.getMessage(), email.getMessage());
				return novo(usuario);
		} /*catch(UsuarioTelefoneException tel){
				result.rejectValue("tel",tel.getMessage(), tel.getMessage());
				return novo(usuario);
		}*/
		
		atributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso");
		return new ModelAndView("redirect:/usuario/novo");
		
	}

}
