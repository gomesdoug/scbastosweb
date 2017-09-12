package com.scbastos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.scbastos.model.Enumerators.EnumStatusUsuario;
import com.scbastos.validation.Nome;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Nome
	@NotBlank(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@NotBlank(message = "Por favor, informe o telefone celular do usuário.")
	private String telefone;
	
	@Email(message="E-mail inválido.")
	@NotBlank(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@CPF(message = "CPF inválido.")
	@NotBlank(message = "Por favor, informe o CPF do usuário.")
	private String cpf;
	
	@NotNull(message = "A senha é obrigatória.")
	private String senha;
	
	@NotNull(message = "Por favor, especifique o Status do usuário")
	@Enumerated(EnumType.STRING)
	private EnumStatusUsuario status_usuario;
	
	private Date data_cadastro;
	
	
	//REMOVER FORMATO CPF PARA SALVA NO BANCO DE DADOS ----------
	
	@PrePersist @PreUpdate
	private void prePersistPreUpdate() {
		this.cpf = this.cpf.replaceAll("\\.|-", "");
	}
	
	
	
	// GETTERS AND SETTERS ---------------------------------------
	
	public Long getIdUsuario() {
		return codigo;
	}
	public void setIdUsuario(Long idUsuario) {
		this.codigo = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getTelefone_celular() {
		return telefone;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone = telefone_celular;
	}
	
	public EnumStatusUsuario getStatus_usuario() {
		return status_usuario;
	}
	public void setStatus_usuario(EnumStatusUsuario status_usuario) {
		this.status_usuario = status_usuario;
	}
	
	//HASHCODE AND EQUALS -----------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}//END CLASS
