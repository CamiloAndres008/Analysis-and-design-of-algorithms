package co.edu.usbbbog.analisisAlgoritmos.panaderia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.logica.ControladorProductos;
import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;

class TestControlador {

	ControladorProductos controladorProductos = new ControladorProductos();
	Productos productoN1 = new Productos("Coca Cola 1.25 ml", "Coca Cola", 1250.0, 6);
	Productos productoN2 = new Productos("Chokis", "Gamesa", 600.0, 12);
	Productos productoN3 = new Productos("Margarita de limon", "Frito Lay", 1500.0, 10);
	Productos productoN4 = new Productos("Chicles Splot", "Colombina", 200.0, 25);
	Productos productoN5 = new Productos("Todo Rico Criollo", "Super Ricas", 1700.0, 6);

	/*
	 * public void entrorno() { controladorProductos = new ControladorProductos(); }
	 */

	@BeforeEach
	public void agregadosInicio() {
		controladorProductos.agregarProducto(productoN1);
		controladorProductos.agregarProducto(productoN3);
		controladorProductos.agregarProducto(productoN4);
	}

	@Test
	void pruebaAgregado() {
		Boolean espected = true;
		Boolean actual = controladorProductos.agregarProducto(productoN5);
		assertEquals(espected, actual);
	}

	@ParameterizedTest
	@ValueSource(strings = { "Chokis" })
	void pruebaBuscadoRepetido() {
		String buscado = productoN1.getNombre();
		Productos productoHallado = controladorProductos.buscarPorNombre(buscado);
		assertNotNull(productoHallado);
	}

	@AfterEach
	@DisplayName("Test de eliminacion de los productos de la lista")
	public void eliminarTodos() {
		controladorProductos.eliminarProducto(productoN1);
		//controladorProductos.eliminarProducto(productoN2);
		controladorProductos.eliminarProducto(productoN3);
	}

	@ParameterizedTest
	@ValueSource(strings = { "Chokis", "Todo Rico Criollo" })
	void testBuscar(String productoABuscar) {
		assertNotNull(controladorProductos.buscarPorNombre(productoABuscar));
	}

	@RepeatedTest(value = 5, name = "{displayName} Repeticion {currentRepetition} de {totalRepetitions}")
	public void testRepetido() {
		assertEquals(productoN2, controladorProductos.buscarPorNombre(productoN2.getNombre()));
	}

}
