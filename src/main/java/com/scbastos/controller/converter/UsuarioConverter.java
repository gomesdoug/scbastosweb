package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import com.scbastos.model.Usuario;

public class UsuarioConverter implements Converter<String, Usuario> {
	
	@Override
	public Usuario convert(String idUsuario) {
		if(!StringUtils.isEmpty(idUsuario)){
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(Long.valueOf(idUsuario));
			return usuario;
		}
		
		return null;
	}

}
