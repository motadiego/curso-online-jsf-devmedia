package br.com.diegomota.cursojsf.mb;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleAjax")
@Scope("view")
public class ControleAjax {
	
	private String texto;
	private String saida;
	
	public ControleAjax() {
		
	}
	
	public String entrarForm() {
		return "ajax.jsf";
	}

	public void inverteTexto() {
		StringBuffer stb = new StringBuffer(texto);
		saida = stb.reverse().toString();
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
	
		
}
