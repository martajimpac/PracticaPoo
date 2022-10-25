package clases;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class ProductTest {

	//contructor. Casos validos
		@Test public void testConstructorValido(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",10.50,date,"leche");
			assertNotNull(producto);
			assertEquals("leche",producto.getNombre());
			assertEquals("111111111113",producto.getId());
			assertEquals(date,producto.getFecha());
			assertEquals(10.50,producto.getPrecio(),0.0);
		}

		// Casos invalidos

		@Test(expected=IllegalArgumentException.class)
		public void testConstructorUpcLongitudInvalida(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("11111111113",10.50,date,"leche");
		}
		@Test(expected=IllegalArgumentException.class)
		public void testConstructorUpcConLetras(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("1111111111a3",10.50,date,"leche");
		}
		@Test(expected=IllegalArgumentException.class)
		public void testConstructorUpcDigitoControlIncorrecto(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111114",10.50,date,"leche");
		}

		@Test(expected=IllegalArgumentException.class)
		public void testConstructorPrecioNegativo(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",-0.1,date,"leche");
		}

		@Test(expected=IllegalArgumentException.class)
		public void testConstructorPrecioCero(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",0,date,"leche");
		}

		@Test(expected=IllegalArgumentException.class)
		public void testConstructorNombreCadenaVacia(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",10.50,date,"");
		}

	//COMPROBAR UPC ----------------------------------------------------------------------------------
	//comprobarUpc. Casos validos
		public void testcomprobarUpcValido(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("11111111113",10.50,date,"leche");
		}
	//casos invalidos
	@Test(expected=IllegalArgumentException.class)
		public void testcomprobarUpcUpcLongitudInvalida(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("11111111113",10.50,date,"leche");
		}
		
	@Test(expected=IllegalArgumentException.class)
		public void testcomprobarUpcUpcConLetras(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("1111111111a3",10.50,date,"leche");
		}
		@Test(expected=IllegalArgumentException.class)
		public void testcomprobarUpcUpcDigitoControlIncorrecto(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111114",10.50,date,"leche");
		}

	//SET Y GET ---------------------------------------------------------------------------------------------------------------------
		
		//getPrecio. Casos validos
		@Test public void testgetPrecioValido(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",10.50,date,"leche");
			double precio =producto.getPrecio();
			assertEquals(10.50,precio,0.0);
		}


		//getFecha. Casos validos
		@Test public void testgetFechaValido(){
			LocalDate date = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",10.50,date,"leche");;
			LocalDate date2 = producto.getFecha();
			assertEquals(date,date2);
		}
}
