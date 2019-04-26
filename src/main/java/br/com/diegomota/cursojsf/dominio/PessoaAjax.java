package br.com.diegomota.cursojsf.dominio;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class PessoaAjax implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="O nome deve ser informado")
	@Length(max=40, message="O nome não deve ultrapassar {max} caracteres")
	private String nome;
	
	@NotEmpty(message="O Email deve ser informado")
	@Email(message="Informe um email valido")
	private String email;
	
	public PessoaAjax() {
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
