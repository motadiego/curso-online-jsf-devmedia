package br.com.diegomota.cursojsf.mb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.diegomota.cursojsf.dominio.Pessoa;

@Component("controleTabela")
@Scope("session")
public class ControleTabela {
	
	private List<Pessoa> lista;
	
	
	public ControleTabela() {
		lista = new ArrayList<Pessoa>();
		lista.add(new Pessoa(1, "joao", "3216548988"));
		lista.add(new Pessoa(2, "pedro", "67657657"));
		lista.add(new Pessoa(3, "maria", "76745754y4"));
		lista.add(new Pessoa(4, "ana", "4754754754"));
		lista.add(new Pessoa(5, "felipe", "7457547547"));
		lista.add(new Pessoa(6, "adriana", "754754754"));
		lista.add(new Pessoa(7, "sergio", "5754754754"));
		lista.add(new Pessoa(8, "andre", "5475475477"));
	}
	
	
	public String entrarTabela() {
		return "tabelaRepeat.jsf";
	}

	public String entrarTabelaSimples() {
		return "tabelaSimples.jsf";
	}
	
	public List<Pessoa> getLista() {
		return lista;
	}


	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	
}
