package com.scbastos.model.Enumerators;

public enum EnumImovelQuitado {
	
	QUITADO("sim"),
	NAOQUITADO("não");
	
	private String imovel_quitacao;
	
	private EnumImovelQuitado(String imovel_quitacao) {
		this.imovel_quitacao = imovel_quitacao;
	}

	public String getImovel_quitacao() {
		return imovel_quitacao;
	}
	
}
