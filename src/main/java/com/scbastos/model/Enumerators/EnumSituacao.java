package com.scbastos.model.Enumerators;

public enum EnumSituacao {

	Ocupado("Ocupado"),
	Vazio("Vazio"),
	Obras("Em obras");
	
	private String enum_situacao;
	
	private EnumSituacao(String situacao) {
		this.enum_situacao = situacao;
	}

	public String getEnum_situacao() {
		return enum_situacao;
	}
	
}
