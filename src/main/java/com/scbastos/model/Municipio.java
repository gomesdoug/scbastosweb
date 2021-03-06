package com.scbastos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="municipio")
public class Municipio implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	private Long codigo;
	
	@Column(name = "nome_municipio")
	private String NomeMunicipio;
	
	@OneToMany(mappedBy ="municipio")
	private List<Bairro> bairro;
	
	
	// GETTERS AND SETTERS
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeMunicipio() {
		return NomeMunicipio;
	}
	public void setNomeMunicipio(String nomeMunicipio) {
		NomeMunicipio = nomeMunicipio;
	}
	public List<Bairro> getBairro() {
		return bairro;
	}
	public void setBairro(List<Bairro> bairro) {
		this.bairro = bairro;
	}
	
	//HASHCODE AND EQUALS
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
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
		Municipio other = (Municipio) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	

}//END CLASS
