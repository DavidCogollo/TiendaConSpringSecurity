package com.formacion.app.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codArticulo")
	private long codArticulo;

	@Column(nullable = false)
	private String nombre, descripcion;

	@Column(name = "precio_unidad")
	private float precioUnidad;

	@Column(name = "unidades_stock", nullable = false)
	private int unidadesStock;
	@Column(name = "stock_seguriad", nullable = false)
	private int stockSeguriad;
	private String imagen;

	public long getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(long codArticulo) {
		this.codArticulo = codArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getUnidadesStock() {
		return unidadesStock;
	}

	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}

	public int getStockSeguriad() {
		return stockSeguriad;
	}

	public void setStockSeguriad(int stockSeguriad) {
		this.stockSeguriad = stockSeguriad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
