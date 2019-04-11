package br.com.diegomota.cursojsf.conversores;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

@Component("converterCalendar")
public class ConverterCalendar implements Converter{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	// converte da tela para o objeto
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String stringTela) {
		Calendar c = Calendar.getInstance();
		sdf.setLenient(false);
		try {
			c.setTime(sdf.parse(stringTela));
		} catch (Exception e) {
			return null;
		}
		return c;
	}

	// converte do objeto para a tela	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objetoConvertido) {
		Calendar c = (Calendar) objetoConvertido;
		String str = sdf.format(c.getTime());
		return str;
	}
	
}
