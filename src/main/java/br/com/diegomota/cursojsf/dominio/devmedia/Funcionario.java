package br.com.diegomota.cursojsf.dominio.devmedia;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="FUNCIONARIO") 
public class Funcionario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Length(max=50, message="Nome n�o pode ultrapassar {max} caracteres")
	@NotEmpty(message="O nome deve ser informado")
	@Column(name="NOME", length=50, nullable=false)
	@Index(name="IDX_NOME_FUNCIONARIO")
	private String nome;
	
	@NotEmpty(message="O CPF deve ser informado")
	@CPF(message="Informe um CPF v�lido")
	@Column(name="CPF", length=14, nullable=false, unique=true)	
	private String cpf;
	
	@NotEmpty(message="Email deve ser informado")
	@Email(message="O email deve ser informado")
	@Column(length=40, nullable=false, name="EMAIL")
	private String email;
	
	@NotNull(message="O salario deve ser informado")
	@Column(name="SALARIO", nullable=false, columnDefinition="numeric(10,2)")
	private Double salario;
	
	@NotNull(message="A data de nascimento deve ser informada")
	@Column(name="NASCIMENTO", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
	@NotNull(message="O campo ativo deve ser informado")
	@Column(name="ATIVO", nullable=false)
	private Boolean ativo;
	
	@Column(name="FOTO")
	@Lob
	private byte[] foto;
	
	@NotEmpty(message="Nome de usuario deve ser informado")
	@Length(max=20, message="O nome de usuario n�o pode ultrapassar {max} caracteres")
	@Column(name="NOME_USUARIO", length=20, nullable=false, unique=true)
	@Index(name="IDX_USUARIO_NOME_USUARIO")
	private String nomeUsuario;
	
	@NotEmpty(message="Senha deve ser informada")
	@Length(max=10, message="Senha n�o pode ultrapassar {max} caracteres")
	@Column(name="SENHA", length=10, nullable=false)	
	private String senha;
	
	@NotNull(message="O grupo deve ser informado")
	@ManyToOne
	@JoinColumn(name="GRUPO", referencedColumnName="ID", nullable=false)
	private Grupo grupo;
	
	@NotNull(message="O Setor deve ser informado")
	@ManyToOne
	@JoinColumn(name="SETOR", referencedColumnName="ID", nullable=false)	
	private Setor setor;
	
	public Funcionario(){
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "nome";
	}
}
