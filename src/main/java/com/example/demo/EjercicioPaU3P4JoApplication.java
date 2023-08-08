package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class EjercicioPaU3P4JoApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(EjercicioPaU3P4JoApplication.class);
	
	@Autowired
	private IProductoService productoService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4JoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//P1....Productos 
		Producto producto1 = new Producto();
		producto1.setCategoria("enlatados");
		producto1.setCodigoBarra("1C");
		producto1.setNombre("sardinas");
		producto1.setPrecio(new BigDecimal(2));
		producto1.setStock(10);

		this.productoService.agregar(producto1);
		
		Producto producto2 = new Producto();
		producto2.setCategoria("no consumibles");
		producto2.setCodigoBarra("1D");
		producto2.setNombre("Detergente");
		producto2.setPrecio(new BigDecimal(15));
		producto2.setStock(5);

		this.productoService.agregar(producto2);
		
		//P2... 
		Producto producto3 = new Producto();
		producto3.setCodigoBarra("1C");
		producto3.setCantidad(2);
		
		Producto producto4 = new Producto();
		producto4.setCodigoBarra("1D");
		producto4.setCantidad(3);
		
		List<Producto> lista = new ArrayList<>();
		lista.add(producto3);
		lista.add(producto4);
		
		String cedula = "1720525516";
		
		
	}

}
