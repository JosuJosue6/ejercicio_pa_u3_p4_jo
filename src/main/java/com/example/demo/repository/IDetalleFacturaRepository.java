package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IDetalleFacturaRepository {

	public void insertar(DetalleFactura detalleFactura);
	
	public void insertarFactura(List<Producto> lista, String cedula);
}
