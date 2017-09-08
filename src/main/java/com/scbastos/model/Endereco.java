package com.scbastos.model;

import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_endereco;
	
	//@NotBlank(message = "O logradouro é obrigatório")
	private String logradouro;
	
	//@NotBlank(message = "Por favor, informe o CEP do endereço")
	private String cep;
	
	//@NotBlank(message = "Por favor, informe o número do imóvel")
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "bairro_id_bairro")
	private Bairro bairro;
	
	// GETTERS AND SETTERS
	
	public Long getIdEndereco() {
		return id_endereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.id_endereco = idEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	// HASHCODE AND EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_endereco ^ (id_endereco >>> 32));
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
		Endereco other = (Endereco) obj;
		if (id_endereco != other.id_endereco)
			return false;
		return true;
	}
	

}// END CLASS
