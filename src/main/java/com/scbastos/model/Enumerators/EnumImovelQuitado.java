package com.scbastos.model.Enumerators;

public enum EnumImovelQuitado {
	
	S("sim"),
	N("não");
	
	private String imovel_quitacao;
	
	EnumImovelQuitado(String imovel_quitacao) {
		this.imovel_quitacao = imovel_quitacao;
	}

	public String getImovel_quitacao() {
		return imovel_quitacao;
	}
	
}
