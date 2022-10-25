package clases;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que gestiona las maquinas vending
 * @author Marta Jimenez Pacheco
 */

public class VendingCity{
	
	//Atributos de clase
	private ArrayList<VendingMachine> listaMaquinas; //lista de maquinas vending creadas
	private int codigo;
	private String nombreProvincia;
	
	public VendingCity(int codigo) {
		this.listaMaquinas = new ArrayList<>();
		this.codigo = codigo;
		this.nombreProvincia = Provincias.getProvincia(codigo);
	}

	/**
	 * Crea una maquina y la a�ade a la lisa de maquinas
	 * El id de la maquina corresponde al indice que ocupa en el arrayList
	 * @param nLineas
	 * @param nProductos
	 * @return listaMaquinas
	 * @throws IllegalStateException si el id esta repetido
	 */
	public void anadirMaquina(VendingMachine maquina) {
		listaMaquinas.add(maquina);
	}
	
	/**
	 * Elimina la maquina por su id
	 * @param idMaquina
	 * @throws IllegalArgumentException si el id no corresponde a una maquina
	 * @throws IllegalArgumentException si el id es negativo
	 */
	public void eliminarMaquina(int idMaquina) {
		if(idMaquina>=listaMaquinas.size()) {
			throw new IllegalArgumentException ("El id no corresponde a una maquina");
		}
		if(idMaquina<0)
			throw new IllegalArgumentException ("El id no puede ser negativo");
		listaMaquinas.remove(idMaquina);
	}
		
	/**
	 * Devuelve el numero de maquinas operativas, es decir, cuyo estado es correcto
	 * @return nMaquinasOp
	 */
	public int getNumeroMaquinasOperativas() {
		int nMaquinasOp = 0;
		for(VendingMachine  maquina: listaMaquinas) {
			boolean estado = maquina.getEstado();
			if(estado) nMaquinasOp++; //si la maquina est fuera de servicio no la contamos
		}
		return nMaquinasOp;
	}
	
	/**
	 * Devuelve las maquinas con una linea vacia
	 * @return
	 */
	public ArrayList<VendingMachine> getMaquinasVacias() {
		boolean vacia;
		ArrayList<VendingMachine> listaMaquinasVacias =  new ArrayList<VendingMachine>();
		
		for(VendingMachine  maquina: listaMaquinas) {
			int nLineas = maquina.getnumeroLineas();
			for(int j=0;j<nLineas;j++) {
				vacia = maquina.getLinea(j).isEmpty();
				if(vacia) {
					listaMaquinasVacias.add(maquina); //si encontramos una linea vacia aadimos la maquina a la lista y pasamos a la siguiente
					break;
				}
			}
		}
		return listaMaquinasVacias;
	}
	
	// SET Y GET ----------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Nos devuelve una lista de las m�quinas
	 */
	public ArrayList<VendingMachine> getListaMaquinas() { 
		return(listaMaquinas);
	}
	
	/**
	 * Nos devuelve el codgio
	 */
	public int getCodigo() { 
		return(codigo);
	}
	
	/**
	 * @return the nombreProvincia
	 */
	public String getNombreProvincia() {
		return nombreProvincia;
	}
}
