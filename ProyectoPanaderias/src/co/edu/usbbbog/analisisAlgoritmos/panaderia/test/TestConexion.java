package co.edu.usbbbog.analisisAlgoritmos.panaderia.test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.mysql.jdbc.Connection;
//
//import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.ConexionMySQL;
//import co.edu.usbbog.analisisAlgoritmos.panaderia.controlador.conexion.ProductosDAO;
//import co.edu.usbbog.analisisAlgoritmos.panaderia.modelo.Productos;
//
//class TestConexion {
//
//	ConexionMySQL co;
//	Connection con;
//
//	ProductosDAO pDAO;
//	Productos productoN1;
//	Productos productoN2;
//
//	public TestConexion() {
//		this.co = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "root", "password");
//		this.pDAO = new ProductosDAO();
//		this.productoN1 = new Productos("Bom bom bun Lulo", "Colombina", 200.0, 10);
//	}
//
//	@Test
//	public void testConexion() {
//		assertTrue(co.conectar());
//		con = co.getCon();
//	}
//
//	@Test
//	public void testObtenerConexion() {
//		assertTrue(con == co.getCon());
//	}
//
//	@BeforeEach
//	public void agregarABase() {
//		equals(true==pDAO.crearMySQL(productoN1));
//	}
//
//	@AfterEach
//	public void eliminarDeBase() {
//		equals(pDAO.eliminarMySQL(productoN1.getNombre()));
//	}
//
//	@Test
//	public void buscarDeBase() {
//		equals(null==pDAO.buscarPorNombre(productoN1.getNombre()));
//	}
//
//}