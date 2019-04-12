package br.com.diegomota.cursojsf.mb;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("indexController")
@Scope(value="request")
public class IndexController {
	
	private String mensagem;
	
	public IndexController() {
		mensagem = "Ola mundo 2"; 
	}
	
	public String home() {
		return "index.jsf";
	}
	
	@RequestMapping("*/")
	private String index() {
		return "index.jsf";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
