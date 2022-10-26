package clases;

import java.util.ArrayList;
import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * Clase que contiene la funcionalidad de la maquina vending.
 * Cada maquina consta de un numero fijo de lineas y cada liena contiene un numero maximo de productos.
 * El cliente puede comprar el producto que elija y consultar informacion de los productos.
 * La maquina tiene metodos que permiten reponer los productos y anadir productos nuevos.
 * El estado de la maquina puede ser operativo o fuera de sevicio.
 * @author Marta Jimenez Pacheco
 * 
 */
public class VendingMachine{
	//Atributos de clase
	private boolean estado; //true: operativo, false: fuera de servicio
	private int numeroLineas;
	private int numeroProductos;
	private ArrayList<ArrayList<Vendible>> maquina;
	private ArrayList<Vendible> linea;


/**
 *@throws IllegalArgumentException cuando la fila esta vacia
 */
	@SuppressWarnings("unchecked")
	public VendingMachine(int numeroLineas,int numeroProductos){
		if (numeroLineas<=0)
			throw new IllegalArgumentException ("El numero de lineas tiene que ser positivo");
		if (numeroProductos<=0)
			throw new IllegalArgumentException ("El numero de productos tiene que ser positivo");
		
		setEstado(true);
		this.numeroLineas = numeroLineas;
		this.numeroProductos = numeroProductos;
		
		maquina=new ArrayList<ArrayList<Vendible>>(numeroLineas);
	    linea=new ArrayList<Vendible>(numeroProductos);
	    
	    for(int i=0;i<numeroLineas;i++){
			if(maquina.contains(i)) {
				throw new IllegalStateException("No puede haber dos identificadores repetidos");
			}
	    	maquina.add((ArrayList<Vendible>)linea.clone()); 
	    }
	}
	
	
	//CONSULTAR PRODUCTOS Y SUS ATRIBUTOS ----------------------------------------------------------------------------------------------------
	
	/**
    * Devuelve el producto que hay en la linea indicada
    * @param indiceLinea: Numero de la linea
    * @return producto: Producto de la linea
	* @throws IllegalArgumentException cuando la linea esta vacia
    */
	public Vendible getProducto(int indiceLinea){
		if (getLinea(indiceLinea).isEmpty()) {
			throw new IllegalArgumentException ("La linea esta vacia"); 
		}
				
		ArrayList<Vendible> milinea = getLinea(indiceLinea);
	    Vendible producto = milinea.get(0);
	    return producto;
	 }
	
	
	/**
    * Devuelve el nombre del producto que hay en la linea indicada
    * @param indiceLinea: Numero de la linea
    * @return nombre: Nombre del producto
    */
     public String getNombreProducto(int indiceLinea){
    	 Vendible producto = getProducto(indiceLinea);
		 String nombre = producto.getNombre();
		 return nombre;
     }
     
     /**
      * Devuelve el precio del producto que hay en la linea indicada
      * @param indiceLinea: Numero de la linea
      * @return precio: Precio del producto
      */
     public double getPrecioProducto(int indiceLinea){
    	 Vendible producto = getProducto(indiceLinea);
		 double precio = producto.getPrecio();
		 return precio;
     }
     
     /**
      * Devuelve el upc del producto que hay en la linea indicada
      * @param indiceLinea: Numero de la linea
      * @return upc: Upc del producto
      */
     public String getUpcProducto(int indiceLinea){
    	 Vendible producto = getProducto(indiceLinea);
		 String upc = producto.getId();
		 return upc;
     }
     

     
     //ANADIR PRODUCTOS NUEVOS Y REPONER ---------------------------------------------------------------------------------------------
     
     /**
      * Nos dice si una linea esta llena
      * @param indiceLinea
      * @return true si esta llena, false si no
      */
     public boolean lineaLlena(int indiceLinea){
    	 int cantidad = getCantidad(indiceLinea);
         int numeroProductos = getnumeroProductos();
         if(cantidad == numeroProductos) {return true;}
         else { return false;}
     }
     
     /**
      * Anade un producto indicado a la fila senalada de la maquina
      * @param producto Producto a anadir a la fila
      * @param index int del numero de la fila.
	  * @throws IllegalArgumentException cuando el producto es nulo
	  * @throws IllegalArgumentException cuando la linea esta llena
      */
     public void anadirProducto(int indiceLinea, Vendible producto){
		  if (producto == null) {
    		 throw new IllegalArgumentException("El producto no puede ser nulo");
		  }
		  if (lineaLlena(indiceLinea))
    		 throw new IllegalArgumentException("La linea esta llena");
		    
    	 ArrayList<Vendible> milinea = getLinea(indiceLinea);
    	 
    	 if(!milinea.isEmpty() && !getProducto(indiceLinea).equals(producto)) {
    		 milinea.clear(); //vaciar la linea si no esta vacia y el producto que hay no es igual al que queremos anadir
    	 }
	     milinea.add(producto);
  	 }
     
     
     /**
      * Rellena la fila con el producto dado, si antes habia otro producto lo reemplaza por el nuevo.
      * @param indiceLinea
      * @param producto
      */
     public void rellenarLinea(int indiceLinea, Vendible producto){
    	 do{
    		 anadirProducto(indiceLinea,producto);
    	 } while(!lineaLlena(indiceLinea));
     }
    
     /**
      * Repone la fila con el producto que ya habia antes en esa linea.
      * @param indiceLinea
      * @param producto
      */
     public void reponerLinea(int indiceLinea){
    	 Vendible producto = getProducto(indiceLinea);
    	 rellenarLinea(indiceLinea,producto);
     }
     
     /**
      * Repone todos los productos de la maquina
      */
     public void reponer(){
    	 numeroLineas = getnumeroLineas();
    	 
    	 for(int i=0;i<numeroLineas;i++){
    		 ArrayList<Vendible> milinea = getLinea(i);
    		 if(!milinea.isEmpty()){
    			 reponerLinea(i);
    		 }
    	 }
  	 }
     
     /**
      * Repone todos los productos de la maquina y rellena las linas vacias con el producto dado
      * @param productoRelleno: Producto para llenar lineas vacias
      */
     public void rellenar(Vendible productoRelleno){
    	 reponer();
    	 numeroLineas = getnumeroLineas();
    	 
    	 for(int i=0;i<numeroLineas;i++){
    		 ArrayList<Vendible> milinea = getLinea(i);
    		 if(milinea.isEmpty()){
    			 rellenarLinea(i,productoRelleno);
    		 }
    	 }
  	 }
     
     //COMPRAR ---------------------------------------------------------------------------------------------------------------------
     
     /**
      * Compramos el primer producto de la fila seleccionada
      * @param indiceLinea
      * @param tarjeta
      * @throws IllegalArgumentException cuando no hay saldo suficiente en la tarjeta
      */
     public void comprar(int indiceLinea, TarjetaMonedero tarjeta) {
    	 if(tarjeta.getSaldoActual()<getPrecioProducto(indiceLinea)) {
    		 throw new IllegalArgumentException("No hay saldo en la tarjeta");
    	 }
  	     double precio = getPrecioProducto(indiceLinea);
  	     
    	 tarjeta.descontarDelSaldo("6Z1y00Nm31aA-571", precio);
    	 linea = getLinea(indiceLinea);
    	 linea.remove(0);
     }

	//SET Y GET ---------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Consulta el valor de estado
	 * @return estado
	 */
	public boolean getEstado() {
		boolean estadoAux = estado;
		return estadoAux;
	}

	/**
	 * Actualizar el valor de estado
	 * @param estado valor nuevo de estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Consulta el valor de nLineas
	 * @return nLineas
	 */
	public int getnumeroLineas() {
		int nLineasAux = numeroLineas;
		return nLineasAux;
	}

	/**
	 * Consulta el valor de nProductos
	 * @return nProductos
	 */
	public int getnumeroProductos() {
		int nProductosaux = numeroProductos;
		return nProductosaux;
	}

	/**
	 * Devuele la linea correspondiente al indice dado
	 * @return linea
	 * @throws IllegalArgumentException si el indice es negativo
	 * @throws IllegalArgumentException si el indice es mayor o igual que el numero de lineas de la maquina
	 * 
	 * intervalo valido 0-(nLineas-1)
	 */
	public ArrayList<Vendible> getLinea(int indiceLinea) {
		if(indiceLinea<0)
			throw new IllegalArgumentException ("El �ndice de la linea tiene que ser positivo");
		if(indiceLinea>=getnumeroLineas())
			throw new IllegalArgumentException ("El �ndice no puede ser mayor que el numero total de lineas de la maquina.");
		
		return maquina.get(indiceLinea);
	}
	
	/**
	 * Consulta el valor de la cantidad actual de productos que hay en una linea
	 * @return cantidad
	 */
	public int getCantidad(int indiceLinea) {
		linea  = getLinea(indiceLinea);
		int cantidad = linea.size();
		return cantidad;
	}
}
