package com.scbastos.model;

public enum Destinacao {
	
	COMPRA("Compra"),
	VENDA("Venda");
	
	private String destinacao;
	
	private Destinacao(String destinacao) {
		this.destinacao = destinacao;
	}

	public String getDestinacao() {
		return destinacao;
	}
	
	

}//END ENUM
