package co.edu.usbbbog.analisisAlgoritmos.panaderia.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.After;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorProductos;
//import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorVentas;
//import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
//import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Ventas;
//
//class TestControladorVentas {
//
//	ControladorVentas controladorVentas = new ControladorVentas();
//	Productos productoN1=new Productos("Margarita de limon", "Frito Lay", 1500.0, 10);
//	Ventas ventasN1 = new Ventas(productoN1.getNombre(), "Dia: 2,Mes:3, Anio,2000", 5);
//	
//	@BeforeEach
//	void agregadoDeElementos() {
//		assertTrue("Venta nueva", controladorVentas.nuevaVenta(ventasN1, productoN1, 5));
//	}
//
//	@Test
//	void agregadoVerificacion() {
//		controladorVentas.nuevaVenta(ventasN1, productoN1, 5);
//	}
//
//	@AfterEach
//	void verificacionAgregaso() {
//		boolean expected = false;
//		boolean current = controladorVentas.nuevaVenta(ventasN1, productoN1, 5);
//		assertEquals(expected, current);
//	}
//	
//	
//	@After 
//	void verCantidad() {
//		equals(controladorVentas.getTotalVentas() == 8);
//	}
//	
//}
