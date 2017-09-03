package com.scbastos.model;

public enum EnumDestinacao {
	
	COMPRA("Compra"),
	VENDA("Venda");
	
	private String enum_destinacao;
	
	private EnumDestinacao(String destinacao) {
		this.enum_destinacao = destinacao;
	}

	public String getEnum_destinacao() {
		return enum_destinacao;
	}


	
	

}//END ENUM
