package br.com.diegomota.cursojsf.mb;



import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleComponentes")
@Scope("session")
public class ControleComponentes {
		
	private String texto;
	private String idComponente;
	
	public ControleComponentes() {
		
	}
	
	public String componentes2() {
		return "componentesParte2.jsf";
	}
	
	
	public String gerarTexto() {
		texto = "Texto gerado < > & <b> Texto em negrito</b>";
		return "componentesParte2.jsf";
	}
	
	public String executar() {
		return "componentesParte3.jsf";
	}
	
	public void listener(ActionEvent event) {
		UIComponent source = event.getComponent();
		idComponente = "Componente que executou a ação " +source.getId();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(String idComponente) {
		this.idComponente = idComponente;
	}
	
	
}
