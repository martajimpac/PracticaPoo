package clases;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class VendingSystemTest {

	//Constructor
	@Test
	public void testConstructorValido() {
		VendingSystem sistema = new VendingSystem();
		assertNotNull(sistema);
	}
	
	//anadirSede
	@Test
	public void testAnadirSede() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		sistema.anadirSede(sede);
		assertEquals(1,sistema.getListaSedes().size());
		assertEquals(sede,sistema.getListaSedes().get(0));
	}
	

	@Test(expected=IllegalArgumentException.class) 
	public void testAnadirSedeInvalidoCodigoIncorrectoAVLNegativo() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(0);
		sistema.anadirSede(sede);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testAnadirSedeInvalidoCodigoIncorrectoAVLPositivo() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(51);
		sistema.anadirSede(sede);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testAnadirSedeInvalidoCodigoRepetido() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		sistema.anadirSede(sede);
		sistema.anadirSede(sede);
	}
	
	//eliminarSede
	@Test
	public void testEliminarSedeValido() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		sistema.anadirSede(sede);
		sistema.eliminarSede(1);
		assertEquals(0,sistema.getListaSedes().size());
	}
	
	//getNumeroMaquinas
	@Test
	public void testgetNumeroMaquinasValido() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		VendingMachine maquina = new VendingMachine(3,5);
		sistema.anadirSede(sede);
		sede.anadirMaquina(maquina);
		sede.anadirMaquina(maquina);
		assertEquals(2,sistema.getNumeroMaquinas(1));
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testgetNumeroMaquinasInvalidoCodigoIncorrecto() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		VendingMachine maquina = new VendingMachine(3,5);
		sede.anadirMaquina(maquina);
		sede.anadirMaquina(maquina);
		sistema.getNumeroMaquinas(1);
	}
	
	//getMaquinas
	@Test
	public void testgetMaquinasValido() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		VendingMachine maquina = new VendingMachine(3,5);
		sistema.anadirSede(sede);
		sede.anadirMaquina(maquina);
		sede.anadirMaquina(maquina);
		assertEquals(maquina,sistema.getMaquinas(1).get(0));
		assertEquals(2,sistema.getMaquinas(1).size());
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testgetMaquinasInvalidoCodigoIncorrecto() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		VendingMachine maquina = new VendingMachine(3,5);
		sistema.anadirSede(sede);
		sede.anadirMaquina(maquina);
		sede.anadirMaquina(maquina);
		sistema.getNumeroMaquinas(2);
	}
	
	//getNumeroProvincias
	@Test
	public void testgetNumeroProvincias() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede1 = new VendingCity(1);
		VendingCity sede2 = new VendingCity(2);
		sistema.anadirSede(sede1);
		sistema.anadirSede(sede2);
		assertEquals(2,sistema.getNumeroProvincias());
	}
	
	//getNombreProvinciasconSede
	@Test
	public void testgetNombreProvinciasConSede() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede1 = new VendingCity(1);
		VendingCity sede2 = new VendingCity(2);
		sistema.anadirSede(sede1);
		sistema.anadirSede(sede2);
		ArrayList<String> nombreProvincias = new ArrayList<>();
		nombreProvincias.add("Alava");
		nombreProvincias.add("Albacete");
		assertEquals(nombreProvincias,sistema.getNombreProvinciasConSede());
	}

	//getTotalMaquinas
	@Test
	public void testgetTotalMaquinas() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede1 = new VendingCity(1);
		VendingCity sede2 = new VendingCity(2);
		
		VendingMachine m = new VendingMachine(3,5);
		VendingMachine m2 = new VendingMachine(3,5);
		m2.setEstado(false);
		
		sede1.anadirMaquina(m);
		sede1.anadirMaquina(m);
		sede2.anadirMaquina(m);
		sede2.anadirMaquina(m);
		sede2.anadirMaquina(m);
		sede2.anadirMaquina(m2);
		
		sistema.anadirSede(sede1);
		sistema.anadirSede(sede2);
		
		assertEquals(5,sistema.getTotalMaquinas());
	}
	
	//getListaSedes
	@Test
	public void testgetListaSedes() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede1 = new VendingCity(1);
		VendingCity sede2 = new VendingCity(2);
		sistema.anadirSede(sede1);
		sistema.anadirSede(sede2);
		
		ArrayList<VendingCity> listaSedes = new ArrayList<>();
		listaSedes.add(sede1);
		listaSedes.add(sede2);
		assertEquals(listaSedes,sistema.getListaSedes());
	}
	
	//getSede
	@Test
	public void testgetSede() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		sistema.anadirSede(sede);
	
		assertEquals(sede,sistema.getSede(1));
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testgetSedeInvalido() {
		VendingSystem sistema = new VendingSystem();
		VendingCity sede = new VendingCity(1);
		sistema.anadirSede(sede);
	
		assertEquals(sede,sistema.getSede(2));
	}
	


}
