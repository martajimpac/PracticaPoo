package clases;

/**
 * La clase Vendible es una abstracci�n. Se podr� saber como m�nimo su nombre, su precio y el identificador �nico que manejar� la empresa.
 *  En el caso de los Productos este identificador podr� estar dado por el UPC
 * @author Marta Jimenez Pacheco
 *
 */

public abstract class Vendible {
	protected String nombre;
	protected double precio;
	protected String id;
	
	/**
	 * Constructor de la clase Vendible
	 * @param id
	 * @param nombre
	 */
	protected Vendible(String nombre){
	    setNombre(nombre);
	}


	//SET Y GET ---------------------------------------------------------------------------------------------------------------------

		/**
		 * Devuelve el valor del id
		 * @return upc
		 */
		public String getId() {
			return id;
		}

		
		/**
		 * Actualiza el valor de  precio
		 * @param precio
		 * @throws IllegalArgumentException cuando el precio es negativo
		 * @throws IllegalArgumentException cuando el prcio es 0
		 */
		public void setPrecio(double precio) {
			if(precio==0) {
				throw new IllegalArgumentException("El precio no puede ser 0");
			}
			if(precio<0) {
				throw new IllegalArgumentException("El precio no puede ser negativo");
			}
			this.precio = precio;
		}


		/**
		 * Devuelve el valor de nombre
		 * @return nombre
		 */
		public String getNombre() {
			String nombreAux = nombre;
			return nombreAux;
		}

		/**
		 * Actualiza el valor de  nombre
		 * @param nombre
		 * @throws IllegalArgumentException cuando el nombre representa una cadena vacia
		 */
		public void setNombre(String nombre) {
		   	if (nombre.equals("")) { throw new IllegalArgumentException ("El nombre no puede ser una cadena vacia"); }
			this.nombre = nombre;
		}
		
		/**
		 * Actualiza el valor del id
		 * @param nombre
		 */
		public void setId(String id) {
			this.id = id;
		}
	   	 
		
		//METODO ABSTRACTO
	
		/**
		 * Metodo que nos devuelve el valor de getPrecio dependiendo de si es un producto o un pack
		 * @return precio
		 */
		public abstract double getPrecio();

}
