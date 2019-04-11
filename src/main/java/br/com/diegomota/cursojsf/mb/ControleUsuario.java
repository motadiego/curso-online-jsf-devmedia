package br.com.diegomota.cursojsf.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.diegomota.cursojsf.dominio.Usuario;;


@Component("controleUsuario")
@Scope("request")
public class ControleUsuario{
	private Usuario usuario;

	public ControleUsuario(){
		usuario = new Usuario();
	}
	
	public String entrarForm() {
		return "formUsuario.jsf";
	}
	
	public String recebeDados(){
		FacesMessage msg = new FacesMessage("Dados recebidos com sucesso!");
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "formUsuario.jsf";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
	
	
}
