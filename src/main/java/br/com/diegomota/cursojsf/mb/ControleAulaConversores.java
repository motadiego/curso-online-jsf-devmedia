package br.com.diegomota.cursojsf.mb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.diegomota.cursojsf.conversores.ConverterCidade;
import br.com.diegomota.cursojsf.dominio.Cidade;

@Component("controleAulaConversores")
@Scope("request")
public class ControleAulaConversores {
	private Calendar nascimento;
	
	private Cidade cidade;

	private List<Cidade> listaCidades = new ArrayList<>();
	
	private ConverterCidade converterCidade;

	
	public ControleAulaConversores(){
		nascimento = Calendar.getInstance();
		listaCidades.add(new Cidade(1, "São Paulo", "SP"));
		listaCidades.add(new Cidade(2, "Porto Alegre", "RS"));
		listaCidades.add(new Cidade(3, "Passo Fundo", "RS"));
		converterCidade = new ConverterCidade(listaCidades);
	}
	
	public String entrarForm() {
		return "formConversores.jsf";
	}
	
	
	public String lerDados(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		FacesMessage msg = new FacesMessage("Informe uma data valida!");
		if (nascimento != null){
			msg = new FacesMessage("Nascimento: "+sdf.format(nascimento.getTime()) +
					" Cidade: "+cidade.getNome() + " UF: "+cidade.getUf());
		} 
		FacesContext.getCurrentInstance().addMessage("", msg);
		nascimento = null;
		return "formConversores.jsf";
	}
	
	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public ConverterCidade getConverterCidade() {
		return converterCidade;
	}

	public void setConverterCidade(ConverterCidade converterCidade) {
		this.converterCidade = converterCidade;
	}
	
	
}
