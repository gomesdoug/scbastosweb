package com.scbastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scbastos.model.Imovel;
import com.scbastos.repository.Imoveis;

@Service
public class CadastroImovelService {
	
	@Autowired
	private Imoveis imoveis;
	
	@Transactional
	public void salvarImovel(Imovel imovel){
		imoveis.save(imovel);

	}
}