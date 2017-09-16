package com.scbastos.repository.helper.usuario;

import java.util.Optional;

import com.scbastos.model.Usuario;

public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	
}
