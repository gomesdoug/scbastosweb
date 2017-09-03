package com.scbastos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_endereco")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	
	
	private String logradouro;
	private String cep;
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "bairro_id_bairro")
	private Bairro bairro;
	
	// GETTERS AND SETTERS
	
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
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
		result = prime * result + (int) (idEndereco ^ (idEndereco >>> 32));
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
		if (idEndereco != other.idEndereco)
			return false;
		return true;
	}
	

	
	
	
	
	
	

}// END CLASS
