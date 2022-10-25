package clases;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import clases.Vendible;


public class VendibleTest {

			//getId. Casos validos
			@Test public void testgetIdValido(){
				LocalDate date = LocalDate.of(2018, 10, 30);
				Product producto =new Product("111111111113",10.50,date,"leche");
				String upc2 = producto.getId();
				assertEquals("111111111113",upc2);
			}


			//setPrecio. Casos validos
			@Test public void testsetPrecioValido(){
				LocalDate date = LocalDate.of(2018, 10, 30);
				Product producto =new Product("111111111113",10.50,date,"leche");
				producto.setPrecio(11.50);
				double precio =producto.getPrecio();
				assertEquals(11.50,precio,0.0);
			}

			//Casos invalidos
			@Test(expected=IllegalArgumentException.class)
			public void testsetPrecioNegativo (){
				LocalDate date = LocalDate.of(2018, 10, 30);
				Product producto =new Product("111111111113",10.50,date,"leche");
				producto.setPrecio(-0.1);
			}

			@Test(expected=IllegalArgumentException.class)
			public void testsetPrecioCero (){
				LocalDate date = LocalDate.of(2018, 10, 30);
				Product producto =new Product("111111111113",10.50,date,"leche");
				producto.setPrecio(0);
			}


			//getNombre. Casos validos
			@Test public void testgetNombreValido(){
				LocalDate date = LocalDate.of(2018, 10, 30);
				Product producto =new Product("111111111113",10.50,date,"leche");
				String nombre2 = producto.getNombre();
				assertEquals("leche",nombre2);
			}

			//setNombre. Casos validos
			@Test public void testSetNombreValido(){
				LocalDate date = LocalDate.of(2018, 10, 30);
				Product producto =new Product("111111111113",10.50,date,"leche");
				
				producto.setNombre("patatas");
				String nombre2 = producto.getNombre();
				assertEquals("patatas",nombre2);
			}
		
			//casos invalidos
			@Test(expected=IllegalArgumentException.class)
			public void testSetNombreCadenaVacia(){
				LocalDate date = LocalDate.of(2018, 10, 30);
				Product producto =new Product("111111111113",10.50,date,"");

			}
	}

	
