package clases;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class VendingMachineTest {
	
	//CONSTRUCTOR *************************************************************************************************************************************************************************
	//constructor VendingMachine. Casos validos
	@Test
	public void testConstructorVendingMachinenLineasNumeroProductosValido() {
		VendingMachine m = new VendingMachine(3,5);
		
		assertNotNull(m);
		assertEquals(3,m.getnumeroLineas());
		assertEquals(5,m.getnumeroProductos());
	}
	
	
	// constructor VendingMachine. Casos invalidos
	@Test(expected=IllegalArgumentException.class) //excepcion que se espera
	public void testConstructorVendingMachineNumeroLineasInvalido() {
		VendingMachine m = new VendingMachine(0,5);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testConstructorVendingMachineNumeroProductosInvalido() {
		VendingMachine m = new VendingMachine(5,0);
	}
	
	//CONSULTAR PRODUCTOS Y SUS ATRIBUTOS ***********************************************************************************************************************************************
	// getProducto. Casos validos
	@Test
	public void testgetProductoValido() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.anadirProducto(1,producto);
		
		assertEquals(producto,maquina.getProducto(1));
	}
	
	// getProducto. Casos invalidos 
	@Test(expected=IllegalArgumentException.class) 
	public void testGetProductoLineaVacia() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getProducto(1);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testGetProductoLineaIncorrectaAVLMax() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getProducto(3);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testGetProductoLineaIncorrectaAVLMin() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getProducto(-1);
	}
	
	// getNombreProducto. Casos validos
	@Test
	public void testGetNombreProductoValido() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.anadirProducto(1,producto);
	    
		assertEquals(producto.getNombre(),maquina.getNombreProducto(1));
	}
	//casos invalidos
	@Test(expected=IllegalArgumentException.class) 
	public void testgetNombreProductoLineaVacia() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getNombreProducto(1);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testgetNombreProductoLineaIncorrectaAVLMax() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getNombreProducto(3);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testgetNombreProductoLineaIncorrectaAVLMin() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getNombreProducto(-1);
	}
	
	// getPrecioProducto. Casos validos
	@Test
	public void testgetPrecioProductoValido() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.anadirProducto(1,producto);
	    
		assertEquals(producto.getPrecio(),maquina.getPrecioProducto(1),0.0);
	}
	//casos invalidos
	
	@Test(expected=IllegalArgumentException.class) 
	public void testgetPrecioProductoLineaVacia() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getPrecioProducto(1);
	}
		@Test(expected=IllegalArgumentException.class) 
		public void testgetPrecioProductoLineaIncorrectaAVLMax() {
			VendingMachine maquina = new VendingMachine(3,5);
			maquina.getPrecioProducto(3);
		}
		@Test(expected=IllegalArgumentException.class) 
		public void testgetPrecioProductoLineaIncorrectaAVLMin() {
			VendingMachine maquina = new VendingMachine(3,5);
			maquina.getPrecioProducto(-1);
		}
		
	// getUpcProducto. Casos validos
	@Test
	public void testgetUpcProductoValido() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.anadirProducto(1,producto);
		assertEquals(producto.getId(),maquina.getUpcProducto(1));
	}
	
	//casos invalidos
	@Test(expected=IllegalArgumentException.class) 
	public void testgetUpcProductoLineaVacia() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.getUpcProducto(1);
	}
	
		@Test(expected=IllegalArgumentException.class) 
		public void testgetUpcProductoLineaIncorrectaAVLMax() {
			VendingMachine maquina = new VendingMachine(3,5);
			maquina.getUpcProducto(3);
		}
		@Test(expected=IllegalArgumentException.class) 
		public void testgetUpcProductoLineaIncorrectaAVLMin() {
			VendingMachine maquina = new VendingMachine(3,5);
			maquina.getUpcProducto(-1);
		}
	 
	//ANADIR PRODUCTOS NUEVOS Y REPONER ***********************************************************************************************************************************************
	// lineaLlena. Casos validos
	@Test
	public void testLineaLlenaValido() {
		VendingMachine maquina = new VendingMachine(2,2);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");
	    maquina.rellenarLinea(0,producto);
	    
		assertEquals(true,maquina.lineaLlena(0));
	}
	//casos invalidos
	@Test(expected=IllegalArgumentException.class) 
	public void testLineaLlenaLineaIncorrectaAVLMax() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.lineaLlena(3);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testLineaLlenaLineaIncorrectaAVLMin() {
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.lineaLlena(-1);
	}
	
	// anadirProducto. Casos validos
	@Test
	public void testAnadirProdcutoValido() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.anadirProducto(0,producto);
	    assertEquals(producto,maquina.getProducto(0));
	    assertEquals(1,maquina.getCantidad(0));
	}
	
	//casos invalidos
	@Test(expected=IllegalArgumentException.class) 
	public void testanadirProductoLineaLlena() {
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto = new Product("111111111113",10.50,date2,"leche");
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.rellenarLinea(1,producto);
		maquina.anadirProducto(1,producto);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testanadirProductoNulo() {
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		VendingMachine maquina = new VendingMachine(3,5);
		maquina.anadirProducto(1,null);
	}
	
		@Test(expected=IllegalArgumentException.class) 
		public void testanadirProductoLineaIncorrectaAVLMax() {
			LocalDate date2 = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",10.50,date2,"leche");
			VendingMachine maquina = new VendingMachine(3,5);
			maquina.anadirProducto(3,producto);
		}
		@Test(expected=IllegalArgumentException.class) 
		public void testanadirProductoLineaIncorrectaAVLMin() {
			LocalDate date2 = LocalDate.of(2018, 10, 30);
			Product producto =new Product("111111111113",10.50,date2,"leche");
			VendingMachine maquina = new VendingMachine(3,5);
			maquina.anadirProducto(-1,producto);
		}
	
	// rellenarLinea. Casos validos
	@Test
	public void testRellenarLineaValido() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.rellenarLinea(0,producto);
	    assertEquals(producto,maquina.getProducto(0));
	    assertEquals(true,maquina.lineaLlena(0));
	}
	
	// rellenarLinea. Casos invalidos  
	@Test (expected=IllegalArgumentException.class) 
	public void testRellenarLineaInvalidoProductoNulo() {
		VendingMachine maquina = new VendingMachine(3,5);
		
		Product producto = null;
	    maquina.rellenarLinea(0,producto);
	}
	
	@Test (expected=IllegalArgumentException.class) 
	public void testRellenarLineaAVLLineaIncorrectaMin() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.rellenarLinea(-1,producto);
	}
	
	@Test (expected=IllegalArgumentException.class) 
	public void testRellenarLineaAVLLineaIncorrectaMax() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");

	    maquina.rellenarLinea(3,producto);
	}
	

	// reponerLinea. Casos validos
	@Test
	public void testReponerLineaValido() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");
		
		maquina.anadirProducto(0,producto);
	    maquina.reponerLinea(0);
	    assertEquals(producto,maquina.getProducto(0));
	    assertEquals(true,maquina.lineaLlena(0));
	}
	
	// reponerLinea. Casos invalidos  
	@Test (expected=IllegalArgumentException.class) 
	public void testReponerLineaInvalidoLineaVacia() {
		VendingMachine maquina = new VendingMachine(3,5);
	    maquina.reponerLinea(0);
	}
	
	@Test (expected=IllegalArgumentException.class) 
	public void testReponerLineaInvalidoAVLLineaincorrectaMin() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");
		maquina.rellenarLinea(-1,producto);
	}
	
	@Test (expected=IllegalArgumentException.class) 
	public void testReponerLineaInvalidoAVLLineaincorrectaMax() {
		VendingMachine maquina = new VendingMachine(3,5);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");
		maquina.rellenarLinea(3,producto);
	}
	
	// reponer. Casos validos
	@Test
	public void testReponer() {
		VendingMachine maquina = new VendingMachine(3,2);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto0 =new Product("111111111113",10.50,date2,"leche");
		Product producto1 =new Product("111111111113",10.50,date2,"patatas");
		
		maquina.anadirProducto(0,producto0);
		maquina.anadirProducto(1,producto1);

		maquina.reponer();
		
		assertEquals(producto0,maquina.getProducto(0));
		assertEquals(producto1,maquina.getProducto(1));
	    assertEquals(true,maquina.lineaLlena(0));
		assertEquals(true,maquina.lineaLlena(1));
		assertEquals(0,maquina.getCantidad(2));
	}
	
	// rellenar. Casos validos
	@Test
	public void testRellenarValido() {
		VendingMachine maquina = new VendingMachine(2,2);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto0 =new Product("111111111113",10.50,date2,"leche");
		Product producto1 =new Product("111111111113",10.50,date2,"patatas");
		
		maquina.anadirProducto(0,producto0);
		maquina.rellenar(producto1);
		
		assertEquals(producto0,maquina.getProducto(0));
		assertEquals(producto1,maquina.getProducto(1));
	    assertEquals(true,maquina.lineaLlena(0));
		assertEquals(true,maquina.lineaLlena(1));
	}
	
	//COMPRAR *******************************************************************************************************************************************************************************
	
	// comprar. Casos validos
	@Test
	public void testComprarValido() {
		VendingMachine maquina = new VendingMachine(2,2);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");
		maquina.rellenarLinea(0, producto);
		int cantidadAntes = maquina.getCantidad(0);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",20.00);
		maquina.comprar(0,tarjeta);
		
		double precioProducto = maquina.getPrecioProducto(0);
		double saldo = 20.00 - precioProducto;
		
		assertEquals(cantidadAntes-1,maquina.getCantidad(0));
		assertEquals(saldo,tarjeta.getSaldoActual(),0.1);
	}
	
	//casos incorrectos
	@Test (expected=IllegalArgumentException.class) 
	public void testComprarSaldoInsuficiente() {
		VendingMachine maquina = new VendingMachine(2,2);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");
		maquina.rellenarLinea(0, producto);
		int cantidadAntes = maquina.getCantidad(0);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",10.49);
		maquina.comprar(0,tarjeta);
	}
	
	@Test (expected=IllegalArgumentException.class) 
	public void testComprarLineaVacia() {
		VendingMachine maquina = new VendingMachine(2,2);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",10.00);
		maquina.comprar(0,tarjeta);
	}
	
	@Test (expected=IllegalArgumentException.class) 
	public void testComprarAVLLineaIncorrectaMin() {
		VendingMachine maquina = new VendingMachine(2,2);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",10.00);
		maquina.comprar(-1,tarjeta);
	}
	@Test (expected=IllegalArgumentException.class) 
	public void testComprarAVLLineaIncorrectaMax() {
		VendingMachine maquina = new VendingMachine(2,2);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",10.00);
		maquina.comprar(2,tarjeta);
	}
	
	//SET Y GET *****************************************************************************************************************************************************************************
		
	// getEstado. Casos validos
	@Test
	public void getEstadoValido() {
		VendingMachine maquina = new VendingMachine(2,2);
		boolean estado=maquina.getEstado();
		assertEquals(true,estado);
	}	
	
	// setEstado. Casos validos
	@Test
	public void setEstadoValido() {
		VendingMachine maquina = new VendingMachine(2,2);
		maquina.setEstado(false);
		boolean estado=maquina.getEstado();
		assertEquals(false,estado);
	}	
	
	// getnLineas. Casos validos
	@Test
	public void getnLineasValido() {
		VendingMachine maquina = new VendingMachine(2,4);
		int nLineas = maquina.getnumeroLineas();
		assertEquals(2,nLineas);
	}	
	
	// getProductos. Casos validos
	@Test
	public void getnProductosValido() {
		VendingMachine maquina = new VendingMachine(2,4);
		int nProductos = maquina.getnumeroProductos();
		assertEquals(4,nProductos);
	}	
	
	// getLinea. Casos invalidos
	@Test (expected=IllegalArgumentException.class) 
	public void getLineaInvalidoAVLLineaMin() {
		VendingMachine maquina = new VendingMachine(2,4);
		maquina.getLinea(-1);
	}	
	@Test (expected=IllegalArgumentException.class) 
	public void getLineaInvalidoAVLLineaMax() {
		VendingMachine maquina = new VendingMachine(2,4);
		maquina.getLinea(2);
	}	
	
	// getCantidad. Casos validos
	@Test
	public void getCantidadValido() {
		VendingMachine maquina = new VendingMachine(2,4);
		LocalDate date2 = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date2,"leche");
		maquina.anadirProducto(1,producto);
		maquina.anadirProducto(1,producto);
		assertEquals(2,maquina.getCantidad(1));
	}	
	//casos invalidos
	@Test (expected=IllegalArgumentException.class) 
	public void getCantidadAVLLineaMin() {
		VendingMachine maquina = new VendingMachine(2,4);
		maquina.getCantidad(-1);
	}	
	@Test (expected=IllegalArgumentException.class) 
	public void getCantidadAVLLineaMax() {
		VendingMachine maquina = new VendingMachine(2,4);
		maquina.getCantidad(2);
	}	
	
}

