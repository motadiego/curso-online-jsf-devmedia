package br.com.diegomota.cursojsf.mb;

import java.util.Locale;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controleLocale")
@Scope("session")
public class ControleLocale {
	
	Locale currentLocale = new Locale("pt","BR");
	public ControleLocale(){
		
	}
	
	public void englishLocale(){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = Locale.US;
		viewRoot.setLocale(currentLocale);
	}
	
	public void portugueseLocale(){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale =  new Locale("pt","BR");
		viewRoot.setLocale(currentLocale);
	}
	
	
	public Locale getCurrentLocale() {
		return currentLocale;
	}
	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}
}
