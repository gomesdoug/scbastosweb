package com.scbastos.model;

public enum TipoImovel {
	
	APARTAMENTO("Apartamento"),
	CASA("Casa"),
	TERRENO("Terreno"),
	COMERCIO("Comércio"),
	GALPAO("Galpão"),
	DEPOSITO("Depósito");
	
	private String descricao;
	
	TipoImovel(String descricao){
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
	}

}//END ENUM
