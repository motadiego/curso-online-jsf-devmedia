package br.com.diegomota.cursojsf.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleValidacao")
@Scope("request")
public class ControleValidacao {
	
	private String nome;
	private String telefone;
	private String email;
	private Long idade;
	private Double nota;
	
	public ControleValidacao() {
		
	}
	
	public String entrarForm() {
		return "formValidacao.jsf";
	}
	
	public String processaDados() {
		String saida = "";
		saida += "Nome: " + nome;
		saida += "Telefone: " + telefone;
		saida += "Email: " + email;
		saida += "Idade: " + idade;
		saida += "Nota: " + nota;
		
		FacesMessage msg = new FacesMessage(saida);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "formValidacao.jsf";
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
	
}
