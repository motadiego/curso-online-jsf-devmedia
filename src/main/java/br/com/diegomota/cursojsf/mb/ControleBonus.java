package br.com.diegomota.cursojsf.mb;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleBonus")
@Scope("request")
public class ControleBonus {
	
	private String nome;
	private Double salario;
	private Double bonus;
	private Integer cargo;
	
	public ControleBonus() {
		
	}
	
	public String entrarForm() {
		return "formBonus.jsf";
	}
	
	public String calcular() {
		switch (cargo) {
		case 0:
			bonus = salario * 15 /100;
			break;
		case 1:
			bonus = salario * 10 /100;
			break;
		case 2:
			bonus = salario * 10 /100;
			break;	
		default:
			break;
		}
		
		return "dadosBonus.jsf";
	}
	
	public String dadosBonus() {
		return "dadosBonus.jsf?cargo="+cargo+"&nome="+nome+"&salario="+salario+"&faces-redirect=true";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}
	
}
