package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.scbastos.model.Municipio;

public class MunicipioConverter implements Converter<String, Municipio>{
	
	@Override
	public Municipio convert(String idMunicipio) {
		Municipio municipio = new Municipio();
		municipio.setIdMunicipio(Long.valueOf(idMunicipio));
		return municipio;
	}

}
