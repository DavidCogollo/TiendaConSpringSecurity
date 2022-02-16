package com.formacion.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.apirest.entity.Cliente;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente,Long> {

}
