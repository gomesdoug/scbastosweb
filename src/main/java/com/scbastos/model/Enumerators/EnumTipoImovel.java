package com.scbastos.model.Enumerators;

public enum EnumTipoImovel {
	
	Apartamento("Apartamento"),
	Casa("Casa"),
	Terreno("Terreno"),
	Comercio("Comércio"),
	Galpao("Galpão"),
	Deposito("Depósito");
	
	private String enum_tipoImovel;
	
	EnumTipoImovel(String tipoImovel){
		this.enum_tipoImovel = tipoImovel;
		
	}

	public String getEnum_tipoImovel() {
		return enum_tipoImovel;
	}



}//END ENUM
