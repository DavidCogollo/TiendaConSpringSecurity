package com.formacion.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.apirest.entity.Articulo;

@Repository
public interface ArticuloDAO extends CrudRepository<Articulo,Long> {

}
