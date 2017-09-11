package com.scbastos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.scbastos.model.Enumerators.EnumClassificacao;
import com.scbastos.model.Enumerators.EnumConservacao;
import com.scbastos.model.Enumerators.EnumDestinacao;
import com.scbastos.model.Enumerators.EnumExclusividadeImovel;
import com.scbastos.model.Enumerators.EnumSituacao;
import com.scbastos.model.Enumerators.EnumStatusImovel;
import com.scbastos.model.Enumerators.EnumTipoImovel;

@Entity
@Table(name="imovel")
public class Imovel implements Serializable{
	

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS ----------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_imovel;
	
	@NotNull(message = "O código SC é obrigatório.")
	private Long codigosc;
	
	private int garagem;
	
	@Column(name="idade_imovel")
	private int idadeImovel;
	
	private String matricula;
	
	@Column(name="insc_imob")
	private String inscricaoImobiliaria;
	
	private String foto;
	private String corretor;
	private String opcionista;
	
	//@NotBlank(message = "A data de captação é obrigatória.")
	@Column(name="data_captacao")
	private Date dataCaptacao;
	
	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@Column(name="area_total")
	private BigDecimal areaTotal;
	
	@ManyToOne
	@JoinColumn(name = "Usuario_id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name ="Proprietario_id_proprietario")
	private Proprietario proprietario;
	
	@OneToOne
	@JoinColumn (name ="Endereco_id_endereco")
	private Endereco endereco;
	
	@OneToOne
	@JoinColumn(name="valor_id_valor")
	private Valor valor;
	
	//ENUMERATORS ----------------------
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_imovel")
	private EnumTipoImovel tipoImovel;
	
	@Enumerated(EnumType.STRING)
	private EnumDestinacao destinacao;
	
	@Enumerated(EnumType.STRING)
	private EnumConservacao conservacao;
	
	@Enumerated(EnumType.STRING)
	private EnumClassificacao classificacao;
	
	@Enumerated(EnumType.STRING)
	private EnumSituacao situacao;
	
	@Enumerated(EnumType.STRING)
	private EnumStatusImovel status_imovel;
	
	@Enumerated(EnumType.STRING)
	private EnumExclusividadeImovel exclusividade_imovel;
	
	//GETTERS AND SETTERS ----------------------
	
	
	public Long getIdImovel() {
		return id_imovel;
	}
	public void setIdImovel(Long idImovel) {
		this.id_imovel = idImovel;
	}
	public Long getCodigosc() {
		return codigosc;
	}
	public void setCodigosc(Long codigosc) {
		this.codigosc = codigosc;
	}
	public int getGaragem() {
		return garagem;
	}
	public EnumStatusImovel getStatus_imovel() {
		return status_imovel;
	}
	public void setStatus_imovel(EnumStatusImovel status_imovel) {
		this.status_imovel = status_imovel;
	}
	public void setGaragem(int garagem) {
		this.garagem = garagem;
	}
	public int getIdadeImovel() {
		return idadeImovel;
	}
	public void setIdadeImovel(int idadeImovel) {
		this.idadeImovel = idadeImovel;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getInscricaoImobiliaria() {
		return inscricaoImobiliaria;
	}
	public void setInscricaoImobiliaria(String inscricaoImobiliaria) {
		this.inscricaoImobiliaria = inscricaoImobiliaria;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getCorretor() {
		return corretor;
	}
	public void setCorretor(String corretor) {
		this.corretor = corretor;
	}
	public String getOpcionista() {
		return opcionista;
	}
	public void setOpcionista(String opcionista) {
		this.opcionista = opcionista;
	}
	
	public Date getDataCaptacao() {
		return dataCaptacao;
	}
	public void setDataCaptacao(Date dataCaptacao) {
		this.dataCaptacao = dataCaptacao;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public BigDecimal getAreaTotal() {
		return areaTotal;
	}
	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal = areaTotal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Valor getValor() {
		return valor;
	}
	public void setValor(Valor valor) {
		this.valor = valor;
	}
	public EnumTipoImovel getTipoImovel() {
		return tipoImovel;
	}
	public void setTipoImovel(EnumTipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	public EnumDestinacao getDestinacao() {
		return destinacao;
	}
	public void setDestinacao(EnumDestinacao destinacao) {
		this.destinacao = destinacao;
	}
	public EnumConservacao getConservacao() {
		return conservacao;
	}
	public void setConservacao(EnumConservacao conservacao) {
		this.conservacao = conservacao;
	}
	public EnumClassificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(EnumClassificacao classificacao) {
		this.classificacao = classificacao;
	}
	public EnumSituacao getSituacao() {
		return situacao;
	}
	public void setSituacao(EnumSituacao situacao) {
		this.situacao = situacao;
	}
	
	
	public EnumExclusividadeImovel getExclusividade_imovel() {
		return exclusividade_imovel;
	}
	public void setExclusividade_imovel(EnumExclusividadeImovel exclusividade_imovel) {
		this.exclusividade_imovel = exclusividade_imovel;
	}
	
	//HASHCODE AND EQUALS ----------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_imovel == null) ? 0 : id_imovel.hashCode());
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
		Imovel other = (Imovel) obj;
		if (id_imovel == null) {
			if (other.id_imovel != null)
				return false;
		} else if (!id_imovel.equals(other.id_imovel))
			return false;
		return true;
	}
	

}//END CLASS
