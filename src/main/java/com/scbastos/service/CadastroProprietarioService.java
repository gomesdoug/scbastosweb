package com.scbastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scbastos.model.Proprietario;
import com.scbastos.repository.ProprietariosRepository;

@Service
public class CadastroProprietarioService {
	
	@Autowired
	private ProprietariosRepository proprietarios;
	
	@Transactional
	public Proprietario salvarProprietario(Proprietario proprietario){
		return proprietarios.save(proprietario);

	}
}
