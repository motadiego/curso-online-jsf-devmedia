package br.com.diegomota.cursojsf.mb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.diegomota.cursojsf.dominio.Pagamento;

@Component()
@Scope("session")
public class ControlePagamento {
	
	private Pagamento pagamento;
	private List<Pagamento> lista = new ArrayList<Pagamento>();
	
	public ControlePagamento(){
		pagamento = new Pagamento();
	}
	
	public String entrarForm() {
		return "formPagamento.jsf";
	}
	
	public String adicionarPagamento(){
		lista.add(pagamento);
		pagamento = new Pagamento();
		return "formPagamento.jsf";
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public List<Pagamento> getLista() {
		return lista;
	}
	public void setLista(List<Pagamento> lista) {
		this.lista = lista;
	}
	
	
}
