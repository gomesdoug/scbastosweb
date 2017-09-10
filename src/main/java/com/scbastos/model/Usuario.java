package com.scbastos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.scbastos.validation.Nome;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Nome
	@NotBlank(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@NotBlank(message = "Por favor, informe o telefone celular do usuário.")
	private String telefone_celular;
	
	@NotBlank(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@NotBlank(message = "Por favor, informe o CPF do usuário.")
	private String cpf;
	
	@NotBlank(message = "A senha é obrigatória.")
	private String senha;
	
	private boolean ativo;
	private boolean opcionista;
	private boolean corretor;
	
	private Date data_cadastro;
	
	// GETTERS AND SETTERS
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isCorretor() {
		return corretor;
	}
	public void setCorretor(boolean corretor) {
		this.corretor = corretor;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public boolean isOpcionista() {
		return opcionista;
	}
	public void setOpcionista(boolean opcionista) {
		this.opcionista = opcionista;
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
		return telefone_celular;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}
	
	//HASHCODE AND EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
}//END CLASS
