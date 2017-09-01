package com.scbastos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bairro")
public class Bairro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long idBairro;
	
	@Column(name = "nome_bairro")
	private String nomeBairro;
	
	@ManyToOne
	@JoinColumn(name = "Municipio_idMunicipio")
	private Municipio municipio;

	//GETTERS AND SETTERS
	
	public Long getIdBairro() {
		return idBairro;
	}


	public void setIdBairro(Long idBairro) {
		this.idBairro = idBairro;
	}


	public String getNomeBairro() {
		return nomeBairro;
	}


	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}


	public Municipio getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	//HASHCODE AND EQUALS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBairro == null) ? 0 : idBairro.hashCode());
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
		Bairro other = (Bairro) obj;
		if (idBairro == null) {
			if (other.idBairro != null)
				return false;
		} else if (!idBairro.equals(other.idBairro))
			return false;
		return true;
	}

	
	
	

	
	
	
	

}//END CLASS
