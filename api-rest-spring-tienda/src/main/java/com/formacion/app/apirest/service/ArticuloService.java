package com.formacion.app.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formacion.app.apirest.entity.Articulo;

@Service
public interface ArticuloService {

	List<Articulo> getArticulos();

	Articulo getArticulo(long id);
	
	Articulo postArticulo(Articulo articulo);
	
	
	Articulo putArticulo(Articulo articulo, long id);	
	
	Articulo deleteArticulo(long id);
}
