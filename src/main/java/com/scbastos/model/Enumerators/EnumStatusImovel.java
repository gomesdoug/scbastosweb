package com.scbastos.model.Enumerators;

public enum EnumStatusImovel {
	
	Ativo("Ativo"),
	Inativo("Inativo");
	
	private String status_imovel;
	
	private EnumStatusImovel(String status) {
		this.status_imovel = status;
	}

	public String getStatus_imovel() {
		return status_imovel;
	}
	
	

}//END ENUM
