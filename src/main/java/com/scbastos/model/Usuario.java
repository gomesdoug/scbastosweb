package com.scbastos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.scbastos.model.Enumerators.EnumStatusUsuario;
import com.scbastos.validation.AtributoSenha;
import com.scbastos.validation.Nome;

@AtributoSenha(atributo="senha", atributoConfirmacao="confirmaSenha")
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Nome
	@NotBlank(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@NotBlank(message = "Por favor, informe o telefone do usuário.")
	private String telefone;
	
	@Email(message="E-mail inválido.")
	@NotBlank(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@CPF(message = "CPF inválido.")
	@NotBlank(message = "Por favor, informe o CPF do usuário.")
	private String cpf;
	
	private String senha;
	
	@Transient
	private String confirmaSenha;
	
	@NotNull(message = "Por favor, especifique o Status do usuário")
	@Enumerated(EnumType.STRING)
	private EnumStatusUsuario  status_usuario;
	
	@NotNull(message = "Selecione ao menos 1(um) grupo.")
	@ManyToMany
	@JoinTable(name = "usuario_grupo",joinColumns=@JoinColumn(name="codigo_usuario"), inverseJoinColumns = @JoinColumn(name="codigo_grupo"))
	private List<Grupo> grupos;
	
	private LocalDate data_cadastro;
	
	private LocalDate data_nascimento;
	
	
	//REMOVER FORMATO CPF PARA SALVA NO BANCO DE DADOS ----------
	
	@PrePersist @PreUpdate
	private void prePersistPreUpdate() {
		this.cpf = this.cpf.replaceAll("\\.|-", "");
	}
	
	
	
	// GETTERS AND SETTERS ---------------------------------------
	
	public Long getIdUsuario() {
		return codigo;
	}

	public void setIdUsuario(Long idUsuario) {
		this.codigo = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}



	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnumStatusUsuario getStatus_usuario() {
		return status_usuario;
	}

	public void setStatus_usuario(EnumStatusUsuario status_usuario) {
		this.status_usuario = status_usuario;
	}

	public LocalDate getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	//HASHCODE AND EQUALS -----------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	
	
}//END CLASS
