package br.com.diegomota.cursojsf.mb;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
@Component("languageBean")
@Scope("request")
public class LanguageBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String localeCode;
	
	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("English", Locale.ENGLISH); //label, value
		countries.put("Chinese", Locale.SIMPLIFIED_CHINESE);
		countries.put("Francês", Locale.FRANCE);
		countries.put("Portugues", new Locale("pt_BR"));
	}
	
	public LanguageBean() {
		localeCode = countries.get("Portugues").toString();
	}
	
	
	public String entrarForm() {
		return "internacionalizacao.jsf";
	}
	
	
	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	
	public String getLocaleCode() {
		return localeCode;
	}


	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}


	public void countryLocaleCodeChanged(ValueChangeEvent e){
		
		String newLocaleValue = e.getNewValue().toString();
		
		//loop a map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
        
        	if(entry.getValue().toString().equals(newLocaleValue)){
        		
        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());
        		
        	}
        }

	}
	

	public void countryLocaleCodeChanged(){
		
		String newLocaleValue = localeCode;
		
		//loop a map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
        
        	if(entry.getValue().toString().equals(newLocaleValue)){
        		
        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());
        		
        	}
        }

	}

}