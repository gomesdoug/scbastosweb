package com.scbastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scbastos.model.Proprietario;
import com.scbastos.repository.Proprietarios;

@Service
public class CadastroProprietarioService {
	
	@Autowired
	private Proprietarios proprietarios;
	
	@Transactional
	public void salvarProprietario(Proprietario proprietario){
		proprietarios.save(proprietario);

	}
}
