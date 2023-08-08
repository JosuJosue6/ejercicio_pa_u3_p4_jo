package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface IDetalleService {

	public void insertarFactura(List<Producto> lista, String cedula);
}
