package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DetalleFacturaRepositoryImpl;
import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductoServiceImpl implements IProductoService{

	private static final Logger LOG = LoggerFactory.getLogger(ProductoServiceImpl.class);


	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void agregar(Producto producto) {
		// TODO Auto-generated method stub
		Integer stock = producto.getStock();
        if(this.productoRepository.actualizarPorCodigo(producto.getCodigoBarra(), stock)==0) {
            LOG.info("Se agrego un producto");
        	this.productoRepository.insertar(producto);
        }else {
        	LOG.info("Se actualizo un producto");
            Producto productoEncontrado = this.productoRepository.seleccionarPorCodigo(producto.getCodigoBarra());
            Integer stockPE = productoEncontrado.getStock();
            Integer stockActualizado = stockPE + producto.getStock();
            this.productoRepository.actualizarPorCodigo(productoEncontrado.getCodigoBarra(),stockActualizado);
        }
	}
	
}
