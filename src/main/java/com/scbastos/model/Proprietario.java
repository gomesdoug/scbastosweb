package com.scbastos.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.scbastos.validation.Nome;

@Entity
@Table(name = "proprietario")
public class Proprietario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Nome
	@NotBlank(message = "Por favor, informe o nome do proprietário é obrigatório.")
	private String nome;
	
	@NotBlank(message ="Por favor, informe o telefone do proprietário.")
	private String telefone;
	
	@Email(message="E-mail inválido.")
	private String email;
	
	@CPF(message = "CPF inválido.")
	@NotBlank(message = "Por favor, informe o CPF do proprietario.")
	private String cpf;
	
	private LocalDateTime data_cadastro = LocalDateTime.now();
	
/*	@Version
	private Integer versao;*/
	
	
	//GETTERS AND SETTERS -------------------------------------------------

	public Long getIdProprietario() {
		return codigo;
	}

	public void setIdProprietario(Long idProprietario) {
		this.codigo = idProprietario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone_fixo() {
		return telefone;
	}

	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone = telefone_fixo;
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

	public LocalDateTime getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDateTime data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	//HASHCODE AND EQUALS
	
	
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
		Proprietario other = (Proprietario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
	
	
	

}//END CLASS
