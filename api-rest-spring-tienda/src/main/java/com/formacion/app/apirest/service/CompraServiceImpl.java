package com.formacion.app.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.apirest.dao.CompraDAO;
import com.formacion.app.apirest.entity.Compra;

@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
	CompraDAO compraDAO;

	@Transactional(readOnly=true)
	@Override
	public List<Compra> getCompras() {
		return (List<Compra>) this.compraDAO.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Compra getCompra(long id) {
		return this.compraDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Compra postCompra(Compra compra) {
		return this.compraDAO.save(compra);
	}

	
	@Transactional
	@Override
	public Compra putCompra(Compra compra, long id) {
		Compra toUpdateCompra = getCompra(id);
		
		if (toUpdateCompra==null) return null;
		
		toUpdateCompra.setCliente(compra.getCliente());
		toUpdateCompra.setArticulo(compra.getArticulo());
		toUpdateCompra.setFecha(compra.getFecha());
		toUpdateCompra.setUnidades(compra.getUnidades());
		return this.compraDAO.save(toUpdateCompra);
	}
	

	@Transactional
	@Override
	public Compra deleteCompra(long id) {
		Compra deletedCompra = this.compraDAO.findById(id).orElse(null);
		this.compraDAO.deleteById(id);
		return deletedCompra;
	}
}
