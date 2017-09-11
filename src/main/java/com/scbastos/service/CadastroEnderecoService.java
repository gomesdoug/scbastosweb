package com.scbastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scbastos.model.Endereco;
import com.scbastos.repository.EnderecosRepository;


@Service
public class CadastroEnderecoService {

	@Autowired
	private EnderecosRepository enderecos;
	
	@Transactional
	public void salvarImovel(Endereco endereco){
		enderecos.save(endereco);
		
	}
	
}
