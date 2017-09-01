package com.scbastos.model;

public enum Conservacao {
	
	IMOVELNOVO("Imóvel novo"),
	OTIMO("Ótimo estado"),
	REFORMA("Requer reforma"),
	PRECARIO("Precário"),
	PESSIMO("Péssimo"),
	DESTRUIDO("Destruído");
	
	private String conservacao;
	
	private Conservacao(String conservacao) {
		this.conservacao = conservacao;
	}

	public String getConservacao() {
		return conservacao;
	}
	
	
}
