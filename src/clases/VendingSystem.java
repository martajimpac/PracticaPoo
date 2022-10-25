package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import clases.VendingCity;
/**
 * @author Victoria
 * @author Marta Jimenez Pacheco
 *
 */
public class VendingSystem {
	private ArrayList<VendingCity> listaSedes;
	   
	/**
	 * Constructor
	 * @param city
	 */
    public VendingSystem() {
    	this.listaSedes = new ArrayList<>();
    }

   /**
    * Anadir una sede a partir del codigo de la ciudad
    * @param cod
    * @throws IllegalArgumentException si ya hay una sede en esa provincia
    * @throws IllegalArgumentException si el codigo es incorrecto
    */
	public void anadirSede(VendingCity sede) {
		if(sede.getCodigo() <=0 || sede.getCodigo() >50 ) {
			throw new IllegalArgumentException("Codigo incorrecto. Intervalo de codigos : [0,50]");
		}
		
		for(VendingCity s: listaSedes) { //ver si ya hay otra sede con el mismo codigo de provincia
			if(s.getCodigo() == sede.getCodigo()) {
				throw new IllegalArgumentException("Ya hay una sede en esa provincia!");
			}
		}
		getListaSedes().add(sede);
	}
	
	/**
	 * Eliminar sede
	 * @param cod
	 */
	public void eliminarSede(int codigo) {
		listaSedes.remove(getSede(codigo));
	}
	
	/**
	 * Obtener numero de maquinas de una sede a partir del codigo
	 * @throws IllegalArgumentException si el codigo no corresponde a ninguna provincia
	 * @return 
	 */
	 public int getNumeroMaquinas(int codigo) {
	     return getSede(codigo).getNumeroMaquinasOperativas();
	 }
	
	/**
	 * Obtener la lista de las maquinas vending de una sede
	 *  @throws IllegalArgumentException si el codigo no corresponde a ninguna provincia
	 */
	public ArrayList<VendingMachine> getMaquinas(int codigo) {
		return(getSede(codigo).getListaMaquinas());
	}
	
	/**
	 * Conocer el  numero de provincias que se gestionan
	 */
	public int getNumeroProvincias() {
		return(getListaSedes().size());
	}
	
	/**
	 * Obtener los nombres de todas las provincias donde hay una sede
	 */ 
	public ArrayList<String> getNombreProvinciasConSede() {
		ArrayList<String> nombresProvincias  = new ArrayList<>();
		for(VendingCity sede: listaSedes) {
			nombresProvincias.add(sede.getNombreProvincia());
		}
		return(nombresProvincias);
	}
	
	/**
	 * Obtener el numero total de maquinas operativas que hay en todas las provincias
	 */
	public int getTotalMaquinas() {
		int numeroMaquinas = 0;//inicializar
		for(VendingCity sede: listaSedes) {
			numeroMaquinas= numeroMaquinas + sede.getNumeroMaquinasOperativas();
		}
		return(numeroMaquinas);
	}
	
    /**
     * Obtener lista de sedes
     * @return
     */
	public ArrayList<VendingCity> getListaSedes() {
		return listaSedes;
	}
	
	
	/**
	 * Devuele la sede correspondiente al codigo dado
	 * @throws IllegalArgumentException si el codigo no corresponde a ninguna provincia
	 */
	public VendingCity getSede(int codigo) {
		boolean encontrado = false;
		VendingCity sede = null;
		for(VendingCity s: listaSedes) {
			if(s.getCodigo() == codigo) {
				encontrado = true;
				sede = s;
			}
		}
		if(!encontrado) {
			throw new IllegalArgumentException("El codigo no corresponde a ninguna provincia de las gestionadas");
		}
		return sede;
	}
}
