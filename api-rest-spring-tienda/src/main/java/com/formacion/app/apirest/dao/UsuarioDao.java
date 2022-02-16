package com.formacion.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.apirest.entity.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
	/*@Query("select u from Usuario u where u,username=?!")
	public Usuario findByUsername2 (String username);*/
	
}
