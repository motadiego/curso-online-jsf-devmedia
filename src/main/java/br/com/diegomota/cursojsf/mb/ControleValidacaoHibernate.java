package br.com.diegomota.cursojsf.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleValidacaoHibernate")
@Scope("request")
public class ControleValidacaoHibernate {
	
	@NotEmpty(message="O nome deve ser informado")
	@Length(max=40 , min=3, message="O nome deve ter entre {min} e {max} caracteres")
	private String nome;
	
	@NotEmpty(message="O telefone deve ser informado")
	@Pattern(regexp="\\(\\d{2}\\)\\d{4}\\-\\d{4}", message="O valor do telefone deve ser no formato (99)9999-9999")
	private String telefone;
	
	@Email(message="Informe um e-mail valido")
	@NotEmpty(message="O email deve ser informado")
	private String email;
	
	@Range(min=12, max=80, message="A idade deve estar entre {min} e {max} anos")
	@NotNull(message="A idade deve ser informada")
	private Long idade;
	
	@Range(min=0, max=10, message="A nota deve estar entre {min} e {max}")
	@NotNull(message="A idade deve ser informada")
	private Double nota;
	
	public ControleValidacaoHibernate() {
		
	}
	
	public String entrarForm() {
		nome ="";
		telefone="";
		email="";
		idade=null;
		nota=null;
		return "formValidacaoHibernate.jsf";
	}
	
	public String processaDados() {
		String saida = "";
		saida += " Nome: "+nome;
		saida += " Telefone: "+telefone;
		saida += " Email: "+email;
		saida += " Idade: "+idade;
		saida += " Nota: "+ nota;
		FacesMessage  msg = new FacesMessage(saida);
		FacesContext.getCurrentInstance().addMessage("", msg);
		nome = "";
		telefone = "";
		email = "";
		idade = null;
		nota = null;
		return "formValidacaoHibernate.jsf";
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
