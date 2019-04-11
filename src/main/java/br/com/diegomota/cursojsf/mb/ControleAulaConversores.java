package br.com.diegomota.cursojsf.mb;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleAulaConversores")
@Scope("request")
public class ControleAulaConversores {
	private Calendar nascimento;

	public ControleAulaConversores(){
		nascimento = Calendar.getInstance();
	}
	
	public String entrarForm() {
		return "formConversores.jsf";
	}
	
	
	public String lerDados(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		FacesMessage msg = new FacesMessage("Informe uma data valida!");
		if (nascimento != null){
			msg = new FacesMessage("Nascimento: "+sdf.format(nascimento.getTime()));
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
}
