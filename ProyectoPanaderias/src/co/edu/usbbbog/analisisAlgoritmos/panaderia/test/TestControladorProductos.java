package co.edu.usbbbog.analisisAlgoritmos.panaderia.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.After;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorProductos;
//import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
//
//class TestControladorProductos {
//
//	ControladorProductos controladorProductos = new ControladorProductos();
//	Productos productoN1 = new Productos("Coca Cola 1.25 ml", "Coca Cola", 1250.0, 6);
//	Productos productoN2 = new Productos("Chokis", "Gamesa", 600.0, 12);
//	Productos productoN3 = new Productos("Margarita de limon", "Frito Lay", 1500.0, 10);
//	Productos productoN4 = new Productos("Chicles Splot", "Colombina", 200.0, 25);
//	Productos productoN5 = new Productos("Todo Rico Criollo", "Super Ricas", 1700.0, 6);
//
//	@BeforeEach
//	void agregadoDeElementos() {
//		assertTrue("Elemento a�adido", controladorProductos.agregarProducto(productoN1));
//		assertTrue("Elemento a�adido",controladorProductos.agregarProducto(productoN2));
//	}
//
//	@Test
//	void agregadoVerificacion() {
//		controladorProductos.agregarProducto(productoN3);
//	}
//
//	@AfterEach
//	void verificacionAgregaso() {
//		boolean expected = false;
//		boolean current = controladorProductos.agregarProducto(productoN3);
//		assertEquals(expected, current);
//	}
//
//	@BeforeEach
//	public void eliminarProductosAgregados() {
//		controladorProductos.eliminarProducto(productoN1);
//		controladorProductos.eliminarProducto(productoN2);
//	} 
//	
//	@AfterEach
//	void mostrarProductos() {
//		controladorProductos.darProductos();
//	}
//	
//	@After 
//	void verCantidad() {
//		equals(controladorProductos.getTotalProductos() == 8);
//	}
//	
//	@AfterEach
//	void buscar() {
//		assertNotNull(controladorProductos.buscarPorNombre(productoN3.getNombre()));
//	}
//}
