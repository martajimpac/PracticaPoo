package clases;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class VendingCityTest {

	@Test
	public void testAnadirMaquina() {
		VendingCity sede = new VendingCity(01);
		VendingMachine maquina = new VendingMachine(3,5);
		sede.anadirMaquina(maquina);
		ArrayList<VendingMachine> listamaquinas = sede.getListaMaquinas();
		assertEquals(maquina,listamaquinas.get(0));
	}

	
	@Test
	public void testEliminarMaquina() {
		VendingCity sede = new VendingCity(01);
		VendingMachine maquina = new VendingMachine(3,5);
		sede.anadirMaquina(maquina);
		sede.anadirMaquina(maquina);
		sede.eliminarMaquina(0);
		ArrayList<VendingMachine> listamaquinas = sede.getListaMaquinas();
		assertEquals(1,listamaquinas.size());
	}
	
	//casos incorrectos
	@Test(expected=IllegalArgumentException.class)
	public void testEliminarMaquinaLineaNeg() {
		VendingCity sede = new VendingCity(01);
		sede.eliminarMaquina(-1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEliminarMaquinaLineaIncorrecta() {
		VendingCity sede = new VendingCity(01);
		sede.eliminarMaquina(0);
	}
	
	@Test
	public void testGetNumeroMaquinasOperativas() {
		VendingCity sede = new VendingCity(01);
		VendingMachine maquina1 = new VendingMachine(3,5);
		VendingMachine maquina2 = new VendingMachine(3,5);
		sede.anadirMaquina(maquina1);
		sede.anadirMaquina(maquina2);
		maquina2.setEstado(false);
		
		assertEquals(1,sede.getNumeroMaquinasOperativas());
	}

	@Test
	public void testGetMaquinasVacias() {
		VendingCity sede = new VendingCity(01);
		VendingMachine maquina1 = new VendingMachine(3,5);
		VendingMachine maquina2 = new VendingMachine(3,5);
		sede.anadirMaquina(maquina1);
		sede.anadirMaquina(maquina2);
		
		LocalDate date = LocalDate.of(2018, 10, 30);
		Product producto =new Product("111111111113",10.50,date,"leche");
		maquina2.rellenar(producto);
		
		ArrayList<VendingMachine> maquinas = sede.getMaquinasVacias();
		assertEquals(1,maquinas.size());
		assertEquals(maquina1,maquinas.get(0));
	}
	
	@Test
	public void testGetCodigo() { 
		VendingCity sede = new VendingCity(01);
		int codigo = sede.getCodigo();
		assertEquals(1,codigo);
	}
	
	@Test
	public void testGetNombreProvincia() {
		VendingCity sede = new VendingCity(01);
		int codigo = sede.getCodigo();
		String provincia = Provincias.getProvincia(codigo);
		String provincia2 = sede.getNombreProvincia();
		assertEquals(provincia,provincia2);
	}

}
