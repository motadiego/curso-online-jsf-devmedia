package br.com.diegomota.cursojsf.dao.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.diegomota.cursojsf.dao.GrupoRepository;
import br.com.diegomota.cursojsf.dominio.devmedia.Grupo;
import br.com.diegomota.cursojsf.excecao.DataIntegrationException;
import br.com.diegomota.cursojsf.excecao.ObjectNotFoundException;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository dao;
	
	public Grupo find(Integer id) {
		Grupo cat =  dao.findOne(id);
		
		if(cat == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
					+ ", Tipo: " + Grupo.class.getName());
		}
		
		
		return cat;
	}
	
	public void insert(Grupo obj) {
		obj.setId(null);
		dao.save(obj);
	}
	
	public void update(Grupo obj) {
		Grupo newObj = find(obj.getId());
		updateData(newObj , obj);
		dao.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			dao.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrationException("Não é possível excluir um GRUPO associado a outros dados");
		}
	}
	
	public List<Grupo> findAll(){
		return dao.findAll();
	}
	
	
	private void updateData(Grupo newObj, Grupo obj) {
		newObj.setNome(obj.getNome());
	}
	
}

