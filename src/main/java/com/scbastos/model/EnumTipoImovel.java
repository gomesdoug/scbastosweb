package com.scbastos.model;

public enum EnumTipoImovel {
	
	APARTAMENTO("Apartamento"),
	CASA("Casa"),
	TERRENO("Terreno"),
	COMERCIO("Comércio"),
	GALPAO("Galpão"),
	DEPOSITO("Depósito");
	
	private String enum_tipoImovel;
	
	EnumTipoImovel(String tipoImovel){
		this.enum_tipoImovel = tipoImovel;
		
	}

	public String getEnum_tipoImovel() {
		return enum_tipoImovel;
	}



}//END ENUM
