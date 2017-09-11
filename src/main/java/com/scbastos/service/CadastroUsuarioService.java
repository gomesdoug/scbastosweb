package com.scbastos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scbastos.exceptions.UsuarioCpfExpetion;
import com.scbastos.exceptions.UsuarioEmailExpetion;
import com.scbastos.exceptions.UsuarioTelefoneException;
import com.scbastos.model.Usuario;
import com.scbastos.repository.Usuarios;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	@Transactional
	public void salvarUsuario(Usuario usuario){
		
			
		Optional<Usuario> usuarioCpf = usuarios.findByCpf(usuario.getCpf());
		if(usuarioCpf.isPresent()){
			 throw new UsuarioCpfExpetion("O CPF informado já existe na base de dados.");
		 }
		
		Optional<Usuario> usuarioEmail = usuarios.findByEmail(usuario.getEmail());
		if(usuarioEmail.isPresent()){
			 throw new UsuarioEmailExpetion("O E-mail informado já existe na base de dados.");
		 }
		
		/*Optional<Usuario> usuarioTelefone = usuarios.findByTelefone(usuario.getTelefone_celular());
		if(usuarioTelefone.isPresent()){
			 throw new UsuarioTelefoneException("O Telefone celular informado já existe na base de dados.");
		 }*/
		
		usuarios.save(usuario);
	}

}//END CLASS
