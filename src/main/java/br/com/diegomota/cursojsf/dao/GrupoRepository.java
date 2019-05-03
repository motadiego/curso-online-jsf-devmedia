package br.com.diegomota.cursojsf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diegomota.cursojsf.dominio.devmedia.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer>  {

}
