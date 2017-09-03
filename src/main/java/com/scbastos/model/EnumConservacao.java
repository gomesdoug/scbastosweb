package com.scbastos.model;

public enum EnumConservacao {
	
	IMOVELNOVO("Imóvel novo"),
	OTIMO("Ótimo estado"),
	REFORMA("Requer reforma"),
	PRECARIO("Precário"),
	PESSIMO("Péssimo"),
	DESTRUIDO("Destruído");
	
	private String enum_conservacao;
	
	private EnumConservacao(String conservacao) {
		this.enum_conservacao = conservacao;
	}

	public String getEnum_conservacao() {
		return enum_conservacao;
	}
	
	
}
