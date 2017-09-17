package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.scbastos.model.Municipio;

public class MunicipioConverter implements Converter<String, Municipio>{
	
	@Override
	public Municipio convert(String codigo) {
		Municipio municipio = new Municipio();
		municipio.setCodigo(Long.valueOf(codigo));
		return municipio;
	}

}
