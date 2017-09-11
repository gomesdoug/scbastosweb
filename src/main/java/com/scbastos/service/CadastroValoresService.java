package com.scbastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scbastos.model.Valor;
import com.scbastos.repository.ValoresRepository;

@Service
public class CadastroValoresService {
	
	
	@Autowired
	private ValoresRepository valores;
	
	@Transactional
	public void salvarValores(Valor valor){
		valores.save(valor);

	}

}
