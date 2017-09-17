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

import com.scbastos.exceptions.ImovelCodigoSCExpetion;
import com.scbastos.model.Endereco;
import com.scbastos.model.Imovel;
import com.scbastos.model.Proprietario;
import com.scbastos.model.Enumerators.EnumClassificacao;
import com.scbastos.model.Enumerators.EnumConservacao;
import com.scbastos.model.Enumerators.EnumDestinacao;
import com.scbastos.model.Enumerators.EnumExclusividadeImovel;
import com.scbastos.model.Enumerators.EnumSituacao;
import com.scbastos.model.Enumerators.EnumStatusImovel;
import com.scbastos.model.Enumerators.EnumTipoImovel;
import com.scbastos.repository.BairrosRepository;
import com.scbastos.repository.EnderecosRepository;
import com.scbastos.repository.MunicipiosRepository;
import com.scbastos.repository.ProprietariosRepository;
import com.scbastos.repository.Usuarios;
import com.scbastos.repository.ValoresRepository;
import com.scbastos.service.CadastroImovelService;

@Controller
@RequestMapping("/imovel")
public class ImovelController {
	
	@Autowired
	private Usuarios usuariosRepository;
	
	private EnderecosRepository enderecosRepository;
	
	@Autowired
	private ProprietariosRepository proprietariosRepository;
	
	@Autowired
	private ValoresRepository valoresRepository;
	
	@Autowired
	private CadastroImovelService cadastroImovelService;
	
	@Autowired
	private BairrosRepository bairrosRepository;
	
	@Autowired
	private MunicipiosRepository municipiosRepository;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(Imovel imovel){
		ModelAndView mv = new ModelAndView("imovel/CadastroImovel");
		
		mv.addObject("tipoImoveis", EnumTipoImovel.values());
		mv.addObject("destinacoes", EnumDestinacao.values());
		mv.addObject("conservacao", EnumConservacao.values());
		mv.addObject("classificacoes", EnumClassificacao.values());
		mv.addObject("situacoes", EnumSituacao.values());
		mv.addObject("statusImovel",EnumStatusImovel.values());
		mv.addObject("exclusividadeImovel",EnumExclusividadeImovel.values());
		
		mv.addObject("usuario",usuariosRepository.findAllByAtivoTrue());
		mv.addObject("proprietario", proprietariosRepository.findAll());
		mv.addObject("valor",valoresRepository.findAll());
		mv.addObject("bairros",bairrosRepository.findAll());
		mv.addObject("municipios",municipiosRepository.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/novo" ,method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Imovel imovel, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			return novo(imovel);
		}
		
		// Salvar no banco de dados
		
	try {
		    Endereco endereco = enderecosRepository.save(imovel.getEndereco());
		    Proprietario proprietario = proprietariosRepository.save(imovel.getProprietario());
		    
		    imovel.setProprietario(proprietario);
		    imovel.setEndereco(endereco);
	 		cadastroImovelService.salvarImovel(imovel);
			
	} catch (ImovelCodigoSCExpetion sc) {
			result.rejectValue("codigosc",sc.getMessage(), sc.getMessage());
			return novo(imovel);
	}
		
		atributes.addFlashAttribute("mensagem", "Imovel cadastrado com sucesso");
		return new ModelAndView("redirect:/imovel/novo");
		
	}
	
}//END CLASS
