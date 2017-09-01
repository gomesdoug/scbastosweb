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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="imovel")
public class Imovel implements Serializable{
	

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS ----------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImovel;
	
	@NotBlank(message = "O código SC é obrigatório.")
	private Long codigocs;
	private int garagem;
	
	@Column(name="idade_imovel")
	private int idadeImovel;
	
	private String matricula;
	
	@Column(name="insc_imob")
	private String inscricaoImobiliaria;
	
	private String foto;
	private String corretor;
	private String opcionista;
	
	private boolean ativo;
	private boolean exclusividade;
	
	@NotBlank(message = "A data de captação é obrigatória.")
	@Column(name="data_captacao")
	private Date dataCaptacao;
	
	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@Column(name="area_total")
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
	
	//ENUMERATORS ----------------------
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_imovel")
	private TipoImovel tipoImovel;
	
	@Enumerated(EnumType.STRING)
	private Destinacao destinacao;
	
	@Enumerated(EnumType.STRING)
	private Conservacao conservacao;
	
	@Enumerated(EnumType.STRING)
	private Classificacao classificacao;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	//GETTERS AND SETTERS ----------------------
	
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
	
	//HASHCODE AND EQUALS ----------------------
	
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
