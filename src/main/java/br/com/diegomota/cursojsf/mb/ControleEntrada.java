package br.com.diegomota.cursojsf.mb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleEntrada")
@Scope("session")
public class ControleEntrada {
	
	private Integer id;
	private String nome;
	private String senha;
	private String observacoes;
	private String saida;
	private String grauInstrucao;
	private List<String> graus = new ArrayList<String>();
	private List<String> tecnologias = new ArrayList<String>();
	private List<String> tecnologiasSelecionadas = new ArrayList<String>();
	
	public ControleEntrada() {
		id = 1;
		graus.add("Ensino Fundamental");
		graus.add("Ensino Médio");
		graus.add("Ensino Superior");
		
		tecnologias.add("Java");
		tecnologias.add("Spring");
		tecnologias.add("JS");
		tecnologias.add("CSS");
	}
	
	
	public String processa() {
		saida = "ID: " + id + "<br/>";
		saida += "Nome: " + nome + "<br/>";
		saida += "Senha: " + senha + "<br/>";
		saida += "Obs: " + observacoes + "<br/>";
		saida += "Grau: " + grauInstrucao + "<br/>";
		saida += "Tecnologias: <br/>";
		for(String s : tecnologiasSelecionadas) {
			saida += s + ";";
		}
		
		return "componentesParte5.jsf";
	}
	
	
	
	
	public String componentes5() {
		return "componentesParte5.jsf";
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


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getObservacoes() {
		return observacoes;
	}


	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	public String getSaida() {
		return saida;
	}


	public void setSaida(String saida) {
		this.saida = saida;
	}


	public String getGrauInstrucao() {
		return grauInstrucao;
	}


	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}


	public List<String> getGraus() {
		return graus;
	}


	public void setGraus(List<String> graus) {
		this.graus = graus;
	}


	public List<String> getTecnologias() {
		return tecnologias;
	}


	public void setTecnologias(List<String> tecnologias) {
		this.tecnologias = tecnologias;
	}


	public List<String> getTecnologiasSelecionadas() {
		return tecnologiasSelecionadas;
	}


	public void setTecnologiasSelecionadas(List<String> tecnologiasSelecionadas) {
		this.tecnologiasSelecionadas = tecnologiasSelecionadas;
	}
	
	
}
