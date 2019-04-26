package br.com.diegomota.cursojsf.mb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.diegomota.cursojsf.dominio.PessoaAjax;

@Component("controleCRUDAjax")
@Scope("view")
public class ControleCRUDAjax {
	
	private List<PessoaAjax> lista = new ArrayList<PessoaAjax>();
	private PessoaAjax objeto;
	private boolean editando;
	
	
	public ControleCRUDAjax() {
		editando = false;
	}
	
	
	public String listar() {
		return "crudAjax.jsf?faces-redirect=true";
	}
	
	

	public List<PessoaAjax> getLista() {
		return lista;
	}
	
	
	public void novo() {
		objeto = new PessoaAjax();
		editando = true;
	}
	
	public void salvar() {
		if(objeto.getId() == null) {
			objeto.setId(lista.size() + 1);
			lista.add(objeto);
		}
		
		editando = false;
	}
	
		
	public void cancelar() {
		editando = false;
	}
	

	public void alterar(PessoaAjax obj) {
		objeto  = obj;
		editando = true;
	}
	
	
	public void excluir(PessoaAjax obj) {
		lista.remove(obj);
	}
	
	
	public void setLista(List<PessoaAjax> lista) {
		this.lista = lista;
	}


	public PessoaAjax getObjeto() {
		return objeto;
	}


	public void setObjeto(PessoaAjax objeto) {
		this.objeto = objeto;
	}


	public boolean isEditando() {
		return editando;
	}


	public void setEditando(boolean editando) {
		this.editando = editando;
	}
	
		
}
