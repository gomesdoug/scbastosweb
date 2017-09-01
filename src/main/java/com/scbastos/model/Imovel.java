package com.scbastos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="imovel")
public class Imovel implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImovel;
	
	private Long codigocs;
	private int garagem;
	private int idadeImovel;
	
	private String matricula;
	private String inscricaoImobiliaria;
	private String destinacao;
	private String situacao;
	private String classificacao;
	private String conservacao;
	private String foto;
	private String corretor;
	private String opcionista;
	
	private boolean ativo;
	private boolean exclusividade;
	
	private Date dataCaptacao;
	private Date dataCadastro;
	
	private BigDecimal areaTotal;
	
	@ManyToOne
	@JoinColumn(name = "Usuario_idUsuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name ="Proprietario_idProprietario")
	private Proprietario proprietario;
	
	@OneToOne
	@JoinColumn (name ="Endereco_idEndereco")
	private Endereco endereco;
	
	//GETTERS AND SETTERS
	
	public Long getIdImovel() {
		return idImovel;
	}
	public void setIdImovel(Long idImovel) {
		this.idImovel = idImovel;
	}
	public Long getCodigocs() {
		return codigocs;
	}
	public void setCodigocs(Long codigocs) {
		this.codigocs = codigocs;
	}
	public int getGaragem() {
		return garagem;
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
	public String getDestinacao() {
		return destinacao;
	}
	public void setDestinacao(String destinacao) {
		this.destinacao = destinacao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getConservacao() {
		return conservacao;
	}
	public void setConservacao(String conservacao) {
		this.conservacao = conservacao;
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isExclusividade() {
		return exclusividade;
	}
	public void setExclusividade(boolean exclusividade) {
		this.exclusividade = exclusividade;
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
	
	//HASHCODE AND EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idImovel ^ (idImovel >>> 32));
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
		if (idImovel != other.idImovel)
			return false;
		return true;
	}
	
	
	
	
	

}//END CLASS
