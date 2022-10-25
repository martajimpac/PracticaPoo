package clases;

import java.time.LocalDate;

/**
 * Esta clase corresponde a una instancia de producto de la maquina vending
 * @author Marta Jimenez Pacheco
 * @author Victoria Ivanova Dobreva
 */
public class Product extends Vendible {
	private static final int LONGITUDUPC = 12;
	private LocalDate fecha;
	  
	/**
	 * Constructor de la clase product
	 * @param upc
	 * @param precio
	 * @param fecha
	 * @param nombre
	 */
	public Product(String upc, double precio, LocalDate fecha,String nombre) {
		super(nombre);
		comprobarUpc(upc);
	    setId(upc);
	    setPrecio(precio);
	    
	    this.fecha = fecha;
	}
	
	//COMPROBAR UPC ---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param upc
	 * @throws IllegalArgumentException cuando el upc tiene más de 12 digitos
	 * @throws IllegalArgumentException cuando el upc tiene dígitos distintos a números
	 * @throws IllegalArgumentException cuando el digito de control es incorrecto
	 */
	public void comprobarUpc(String upc) {
		
		if(upc.length() != LONGITUDUPC) { //ver longitud upc
			throw new IllegalArgumentException("El upc introducido tiene que tener 12 digitos");
		}
		
		for(char c: upc.toCharArray()){
		    if (!Character.isDigit(c)){
		    	throw new IllegalArgumentException("El upc introducido no puede tener letras");
		    } 
		}
		
		Long upcNumerico = Long.parseLong(upc);
		int numero;
		int digitoDado = (int) (upcNumerico%10);
		upcNumerico = upcNumerico/10;
		int suma=0;
		
		for(int i=1;i<=11;i++) {
			numero = (int) (upcNumerico%10);
			if(i%2!=0) numero= numero*3;
			suma = suma + numero;
		}
		
		int multiplo10 = (int) (Math.round((suma)/10.0) * 10);  //aproximar el valor al múltiplo de 10
		
		int digitoControl = Math.abs(suma-multiplo10);
	
		if(digitoDado != digitoControl){
		 	throw new IllegalArgumentException("El digito de control es incorrecto.");
		}
	}
	
	//SET Y GET ---------------------------------------------------------------------------------------------------------------------------

	
	/**
	 * Devuelve el valor de la fecha
	 * @return fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
	 * Devuelve el valor del precio
	 * @return precio
	 */
	@Override
	public double getPrecio() {
		return precio;
	}
   	 

}
