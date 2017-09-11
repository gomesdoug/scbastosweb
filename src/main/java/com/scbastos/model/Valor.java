package com.scbastos.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.scbastos.model.Enumerators.EnumImovelQuitado;
import com.scbastos.validation.Nome;

@Entity
public class Valor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_valor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idValor;
	
	@NotNull(message = "Por favor, especifique o valor do imóvel")
	@DecimalMin(value="0.00", message = "O valor do imóvel deve ser positivo")
	@Column(name ="valor_imovel")
	private BigDecimal valorImovel;
	
	@DecimalMin(value="0.00", message = "O valor do sinal deve ser positivo")
	private BigDecimal sinal;
	
	@Min(value = 0, message="O prazo de financiamento deve ser um valor positivo")
	@Column(name = "prazo_financiamento")
	private int prazoFinanciamento;
	
	@DecimalMin(value="0.00", message = "O saldo devedor deve ser positivo")
	@Column(name = "saldo_devedor")
	private BigDecimal saldoDevedor;
	
	@Nome
	@Column(name ="org_financeira")
	private String OrgFinanceira;
	
	@NotNull(message = "Por favor, especifique a se o imóvel está quitado ou não")
	@Enumerated(EnumType.STRING)
	private EnumImovelQuitado quitado;

	// GETTERS AND SETTERS
	
	public Long getIdValor() {
		return idValor;
	}

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
				//(valorImovel.subtract(sinal));
	}

	public String getOrgFinanceira() {
		return OrgFinanceira;
	}

	public void setOrgFinanceira(String orgFinanceira) {
		OrgFinanceira = orgFinanceira;
	}
	
	public EnumImovelQuitado getQuitado() {
		return quitado;
	}

	public void setQuitado(EnumImovelQuitado quitado) {
		this.quitado = quitado;
	}

	//HASHCODE AND EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idValor == null) ? 0 : idValor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valor other = (Valor) obj;
		if (idValor == null) {
			if (other.idValor != null)
				return false;
		} else if (!idValor.equals(other.idValor))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	

}
