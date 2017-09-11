package com.scbastos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scbastos.exceptions.ImovelCodigoSCExpetion;
import com.scbastos.model.Imovel;
import com.scbastos.repository.ImoveisRepository;

@Service
public class CadastroImovelService {
	
	@Autowired
	private ImoveisRepository imoveis;
	
	@Transactional
	public void salvarImovel(Imovel imovel){
		
		Optional<Imovel> imovelSC = imoveis.findByCodigosc(imovel.getCodigosc());
		if(imovelSC.isPresent()){
			 throw new ImovelCodigoSCExpetion("O CódigoSC informado já existe na base de dados.");
		 }
		
		imoveis.save(imovel);

	}
}