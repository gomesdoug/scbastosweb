package com.scbastos.model;

public enum EnumExclusividadeImovel {
	
	IMOVELEXCLUSIVO("Exclusividade"),
	IMOVELNAOEXCLUSIVO("Não");
	
	private String imovel_exclusividade;
	
	private EnumExclusividadeImovel(String exclusividade) {
		this.imovel_exclusividade = exclusividade;
	}

	public String getImovel_exclusividade() {
		return imovel_exclusividade;
	}
	

}//END ENUM
