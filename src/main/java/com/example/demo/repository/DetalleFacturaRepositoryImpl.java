package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.EjercicioPaU3P4JoApplication;
import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository {

	private static final Logger LOG = LoggerFactory.getLogger(DetalleFacturaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleFactura);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertarFactura(List<Producto> lista, String cedula) {
		// TODO Auto-generated method stub
		DetalleFactura detalle = new DetalleFactura();
		Integer cantidad;
		BigDecimal precioUnitario;
		BigDecimal subtotal;
		BigDecimal total = new BigDecimal(0);
		Integer stock;
		List<DetalleFactura> listaVenta = new ArrayList<>();
		
		for (Producto p : lista) {
			//datos de los elemntos de la lista
			cantidad = p.getCantidad();	
			Producto pEncontrado = this.productoRepository.seleccionarPorCodigo(p.getCodigoBarra());
			
			//Datos de los productos de la DB
			stock = pEncontrado.getStock();
			precioUnitario = pEncontrado.getPrecio();
			
			if(stock == 0) {
				new NullPointerException();
			}else {
				if(stock<cantidad) {
					this.productoRepository.actualizarPorCodigo(pEncontrado.getCodigoBarra(), 0);
				}else {

					this.productoRepository.actualizarPorCodigo(pEncontrado.getCodigoBarra(), stock-cantidad;);
				}
			}
			//Calculos
			subtotal = precioUnitario.multiply(new BigDecimal(cantidad));
			total = total.add(subtotal);
			
			//Agreagar los detalles de venta

			detalle.setPrecioUnitario(precioUnitario);
			detalle.setSubtotal(subtotal);
			detalle.setProducto(pEncontrado);
			detalle.setCantidad(cantidad);
			
			listaVenta.add(detalle);
		}
		
		Factura factura = new Factura();
		factura.setCedula(cedula);
		factura.setTotalFactura(total);
		factura.setDetalles(listaVenta);
		
		this.insertar(detalle);
		
	}

}
