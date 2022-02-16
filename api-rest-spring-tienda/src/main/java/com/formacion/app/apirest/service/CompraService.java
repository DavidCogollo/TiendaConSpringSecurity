package com.formacion.app.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formacion.app.apirest.entity.Compra;

@Service
public interface CompraService {

	List<Compra> getCompras();

	Compra getCompra(long id);

	Compra postCompra(Compra compra);
	
	Compra putCompra(Compra compra, long id);	
		
	Compra deleteCompra(long id);
}
