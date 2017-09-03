package com.scbastos.model;

public enum EnumClassificacao {
	
	DUPLEX("Duplex"),
	LINEAR("Linear"),
	SOBRADO("Sobrado"),
	TERREA("Térrea"),
	TRIPLEX("Triplex");
	
	private String enum_classificacao;
	
	private EnumClassificacao(String classificacao) {
		this.enum_classificacao = classificacao;
	}

	public String getEnum_classificacao() {
		return enum_classificacao;
	}
	


	
}

