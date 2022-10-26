package clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 *En la clase Pack se realizará una inicializacion basada en un array de Producto (Producto[]). 
 *Debe garantizarse que un pack tenga siempre un minimo de 2 productos, que nunca seran productos repetidos.
De un pack, ademas de poder conocer su nombre, su precio y su identificador unico (como de cualquier elemento Vendible), 
debera poder conocerse la cantidad de productos que forman el pack, si un
producto dado forma parte del pack, asi como saber que productos en concreto forman dicho pack. 
El precio del pack se calculara con un descuento del 20 % a la suma de los precios de los productos contenidos en el pack.
Debera garantizarse que si el precio de algunos de los productos del pack cambia, el
precio del pack tambien.
Se debera poder gestionar el pack anadiendo y eliminando elementos siempre que se respeten los
detalles anteriores. En ningun caso se permitira tener packs formados por otros packs.
 * @author marta
 */
public class Pack extends Vendible{
	private ArrayList<Product> productos;
	private String nombre;

	/**
	 * Constructor de la clase product
	 * @param upc
	 * @param precio
	 * @param fecha
	 * @param nombre
	 */
	public Pack(String nombre, ArrayList<Product> productos, String id) {
		super(nombre);
		if(productos.size() < 2) throw new IllegalArgumentException("El pack tiene que tener minimo dos productos");
		if(productos.size() == 2 && productos.get(0).equals(productos.get(1))) { //comprobar que los productos no estan repetidos
			throw new IllegalArgumentException("Los productos no pueden ser iugales");
		}
		this.productos = productos;
	    setId(id);
	}
	
	/**
	 * metodo para obtener el numero de productos en un pack
	 * @return productos
	 */
	public int getNumeroProductosPack() {
		return productos.size();
	}
	
	/**
	 * obtiene los productos de un pack
	 * @return productos
	 */
	
	public ArrayList<Product> getProductosPack() {
		return productos;
	}
	
	
	/**
	 * metodo para saber si un producto pertence al pack
	 * @param producto
	 * @return
	 */
	
	public boolean pertenece(Product producto) {
		boolean pertenece = false;
		if(productos.contains(producto)) {
			pertenece = true;
		}
		return pertenece;
	}

	/**
	 * metodo para anadir elemento al pack
	 * @param producto
	 * @return productos
	 */
	public void anadirProducto(Product producto) {
		productos.add(producto);
	}
	
	/**
	 * metodo para eliminar elemento al pack
	 * @param producto
	 * @return productos
	 * @throw IllegalArgumentException si el pack tiene solo dos prodcutos
	 */
	public void eliminarProducto(Product producto) {
		if(productos.size() == 2) throw new IllegalArgumentException("No se puede eliminar el producto ya que el pack solo tiene dos productos");
		productos.remove(producto);
	}
	
	/**
	 * Devuelve el valor de la suma de los precios con un 20%
	 * @return precio
	 */
	@Override
	public double getPrecio() {
		double precio = 0;
		for(Product producto: productos) {
			precio = precio + (producto.getPrecio() * 0.8);
		}
		return precio;
	}
}