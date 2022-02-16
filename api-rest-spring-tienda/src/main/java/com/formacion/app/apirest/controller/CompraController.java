package com.formacion.app.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.apirest.entity.Compra;
import com.formacion.app.apirest.service.CompraServiceImpl;

@RestController
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	CompraServiceImpl compraServiceImpl;

	
	@GetMapping("/all")
	public ResponseEntity<List<Compra>> getAllClientes() {
		return new ResponseEntity<>(compraServiceImpl.getCompras(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCompra(@PathVariable Long id) {
		Compra compra = null;
		Map<String, Object> response = new HashMap<>();
		try {
			compra = compraServiceImpl.getCompra(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar consulta a la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (compra == null) {
			response.put("mensaje", "El cliente ID: " + id.toString() + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Compra>(compra, HttpStatus.OK);

	}	
	
	@PostMapping("")
	public ResponseEntity<?> postCompra(@RequestBody Compra compra) {
		Compra newCompra = null;
		Map<String, Object> response = new HashMap<>();
		try {
			newCompra = compraServiceImpl.postCompra(compra);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (newCompra == null) {
			response.put("mensaje", "La compra: " + compra.getArticulo()+" no se ha guardado en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
		response.put("compra", newCompra);
		response.put("mensaje", "Se ha guardado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	@PutMapping("/{id}")
	public ResponseEntity<?> putCompra(@RequestBody Compra compra, @PathVariable long id) {
		Compra editCompra = null;
		Map<String, Object> response = new HashMap<>();
		try {
			editCompra = compraServiceImpl.putCompra(compra, id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al editar la comrpa");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (editCompra == null) {
			response.put("mensaje", "No se han hecho cambios para esta compra");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
		response.put("compra", editCompra);
		response.put("mensaje", "Se ha editado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompra(@PathVariable long id) {
		Compra deleteCompra = null;
		Map<String, Object> response = new HashMap<>();
		try {
			deleteCompra = compraServiceImpl.deleteCompra(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			if (deleteCompra == null) {
				response.put("error2", "No existe la compra: " + id);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
			}
			response.put("mensaje", "Error al eliminar la compra");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("compra", deleteCompra);
		response.put("mensaje", "Se ha eliminado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
