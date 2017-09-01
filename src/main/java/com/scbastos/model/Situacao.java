package com.scbastos.model;

public enum Situacao {

	OCUPADO("Ocupado"),
	VAZIO("Vazio"),
	EMOBRAS("Em obras");
	
	private String situacao;
	
	private Situacao(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}
	
}
