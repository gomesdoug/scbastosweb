package com.scbastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scbastos.model.Usuario;
import com.scbastos.repository.Usuarios;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	@Transactional
	public void salvarUsuario(Usuario usuario){
		usuarios.save(usuario);
		
	}

}
