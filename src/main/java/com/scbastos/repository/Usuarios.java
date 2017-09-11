package com.scbastos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scbastos.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByCpf(String cpf);
	
	public Optional<Usuario> findByEmail(String email);
	
	//public Optional<Usuario> findByTelefone(String telefone_celular);
	

}
