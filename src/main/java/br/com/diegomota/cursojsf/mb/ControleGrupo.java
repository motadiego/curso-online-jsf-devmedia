package br.com.diegomota.cursojsf.mb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.diegomota.cursojsf.dao.servico.GrupoService;
import br.com.diegomota.cursojsf.dominio.devmedia.Grupo;
import br.com.diegomota.cursojsf.utils.UtilMensagens;

@Component("controleGrupo")
@Scope("session")
public class ControleGrupo {
	
	@Autowired
	private GrupoService service;
	
	private Grupo objeto;
	
	
	public ControleGrupo() {
		objeto = new Grupo();
	}
	
	public String listar(){
		return "/privado/grupo/listar.jsf?faces-redirect=true";
	}
	
	
	public String novo(){
		objeto = new Grupo();
		return "form.jsf";		
	}
	
	public String cancelar(){
		return listar();
	}
	
	public String salvar(){
		try {
			if(objeto.getId() == null) {
				service.insert(objeto);
			}else {
				service.update(objeto);
			}
			UtilMensagens.mensagemInformacao("Objeto salvo com sucesso!");
			
		} catch (Exception e) {
			UtilMensagens.mensagemInformacao(e.getMessage());
		}
		
		return "listar.jsf";
	}
	
	
	public String alterar(Grupo obj){
		objeto = obj;
		return "form.jsf";
	}
	
	public String excluir(Grupo obj){
		try {
			service.delete(obj.getId());
			UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
		} catch (Exception e) {
			UtilMensagens.mensagemInformacao(e.getMessage());
		}
		return "listar.jsf";
	}
	
	public List<Grupo> listarTodos(){
		return service.findAll();
	}

	public Grupo getObjeto() {
		return objeto;
	}

	public void setObjeto(Grupo objeto) {
		this.objeto = objeto;
	}
	
	
}
