package clases;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import clases.Pack;

public class PackTest {
	
	//Constructor
	@Test
	public void testConstructorValido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		assertNotNull(pack1);
		assertEquals("pack1",pack1.getNombre());
		assertEquals("1",pack1.getId());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorInvalidoSolo1Producto() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorInvalidoProductosRepetidos() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto1);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
	}
	
	//getNumeroProductosPack
	@Test
	public void testgetNumeroProductosPackValido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		assertEquals(2,pack1.getNumeroProductosPack());
	}
	
	//getProductosPack
	@Test
	public void testgetProductosPackValido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		assertEquals(2,pack1.getProductosPack().size()); 
		assertEquals(producto1,pack1.getProductosPack().get(0)); 
		assertEquals(producto2,pack1.getProductosPack().get(1)); 
	}
	
	//pertenece
	@Test
	public void testPerteneceValido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		Product producto3 =new Product("111111111113",10,date,"galletas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		
		assertTrue(pack1.pertenece(producto1)); 
		assertFalse(pack1.pertenece(producto3)); 
	}
	
	//anadirProducto
	@Test
	public void testAnadirProductoValido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		Product producto3 =new Product("111111111113",10,date,"galletas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		pack1.anadirProducto(producto3);
		
		assertEquals(producto3,pack1.getProductosPack().get(2)); 
	}
	
	//eliminarProducto
	@Test
	public void testEliminarProductoValido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		Product producto3 =new Product("111111111113",10,date,"galletas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		pack1.eliminarProducto(producto3);
		
		assertEquals(2,pack1.getProductosPack().size()); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEliminarProductoInvalido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		pack1.eliminarProducto(producto2);
	}
	
	
	//getPrecio
	@Test
	public void testgetPrecioValido() {
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto1 =new Product("111111111113",10,date,"leche");
		Product producto2 =new Product("111111111113",10,date,"patatas");
		ArrayList<Product> listaProductos= new ArrayList<>();
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		Pack pack1 =new Pack("pack1",listaProductos,"1");
		assertEquals(16,pack1.getPrecio(),0.0); 
	}
}
