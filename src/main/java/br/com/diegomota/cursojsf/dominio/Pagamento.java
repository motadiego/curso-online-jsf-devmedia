package br.com.diegomota.cursojsf.dominio;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Double valor;
	private Date data;
	
	public Pagamento(){
		data = new Date();
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
