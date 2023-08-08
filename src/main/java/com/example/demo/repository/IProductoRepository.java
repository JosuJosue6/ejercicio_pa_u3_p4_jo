package com.example.demo.repository;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepository {

	public void insertar(Producto producto);
	
	public Producto seleccionarPorCodigo(String codigo);
	
	public int actualizarPorCodigo(String codigo, Integer stock);
}
