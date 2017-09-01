package com.scbastos.model;

public enum Classificacao {
	
	DUPLEX("Duplex"),
	LINEAR("Linear"),
	SOBRADO("Sobrado"),
	TERREA("Térrea"),
	TRIPLEX("Triplex");
	
	private String classificacao;
	
	private Classificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getClassificacao() {
		return classificacao;
	}
	
}
