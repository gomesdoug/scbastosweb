package com.scbastos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valor {
	
	@Id
	@Column(name="id_valor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idValor;
	
	@Column(name ="valor_decimal")
	private BigDecimal valorImovel;
	
	private BigDecimal sinal;
	
	@Column(name = "prazo_financiamento")
	private int prazoFinanciamento;
	
	@Column(name = "saldo_devedor")
	private BigDecimal saldoDevedor;
	
	@Column(name ="org_financeira")
	private String OrgFinanceira;
	
	private boolean quitado;

	public Long getIdValor() {
		return idValor;
	}

	// GETTERS AND SETTERS
	
	public void setIdValor(Long idValor) {
		this.idValor = idValor;
	}

	public BigDecimal getValorImovel() {
		return valorImovel;
	}

	public void setValorImovel(BigDecimal valorImovel) {
		this.valorImovel = valorImovel;
	}

	public BigDecimal getSinal() {
		return sinal;
	}

	public void setSinal(BigDecimal sinal) {
		this.sinal = sinal;
	}

	public int getPrazoFinanciamento() {
		return prazoFinanciamento;
	}

	public void setPrazoFinanciamento(int prazoFinanciamento) {
		this.prazoFinanciamento = prazoFinanciamento;
	}

	public BigDecimal getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(BigDecimal saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	public String getOrgFinanceira() {
		return OrgFinanceira;
	}

	public void setOrgFinanceira(String orgFinanceira) {
		OrgFinanceira = orgFinanceira;
	}

	public boolean isQuitado() {
		return quitado;
	}

	public void setQuitado(boolean quitado) {
		this.quitado = quitado;
	}
	
	
	
	
	

}
