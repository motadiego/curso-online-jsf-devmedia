package br.com.diegomota.cursojsf.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controlePessoa")
@Scope("session")
public class ControlePessoa {
	
	private Boolean opcaoSelecionado;
	private Boolean pessoaFisica;
	private Integer id;
	private String nome;
	private String cpf;
	private String cnpj;
	private String saida;
	
	
	public ControlePessoa() {
		opcaoSelecionado = false;
	}
	
	public void init() {
		opcaoSelecionado = false;
		id = null;
		nome ="";
		cpf="";
		cnpj="";
		saida="";
	}
	
	public String entrarForm() {
		init();
		return "formPessoa.jsf";
	}
	
	
	public void tipoChange(ValueChangeEvent event) {
		pessoaFisica = (Boolean) event.getNewValue();
		selecionar();
	}

	public String selecionar() {
		opcaoSelecionado = true;
		String selecao = pessoaFisica == true ? "Pessoa Fisica" : "Pessoa Juridica";
		FacesMessage msg = new FacesMessage("Tipo selecionado: " + selecao);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "formPessoa.jsf";
	}
	
	
	public String exibirDados() {
		saida = "Valores recebidos";
		saida += "<br/>" + (pessoaFisica ? "Nome: " + nome : "Razão social: " +  nome );
		saida += "<br/>" + (pessoaFisica ? "Cpf: " + cpf : "Cnpj: " +  cnpj );
		
		FacesMessage msg = new FacesMessage("Dados recebidos com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return "dadosPessoa.jsf";
	}
	
	public String voltar() {
		init();
		return "formPessoa.jsf"; 
	}
	
	
	public Boolean getOpcaoSelecionado() {
		return opcaoSelecionado;
	}


	public void setOpcaoSelecionado(Boolean opcaoSelecionado) {
		this.opcaoSelecionado = opcaoSelecionado;
	}


	public Boolean getPessoaFisica() {
		return pessoaFisica;
	}


	public void setPessoaFisica(Boolean pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
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


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getSaida() {
		return saida;
	}


	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	
	
	
}
