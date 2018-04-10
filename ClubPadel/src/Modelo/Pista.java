package Modelo;

public class Pista {
	int id;
	String urbanizacion;

	/*
	 * ************ CONSTRUCTOR ************
	 */

	public Pista() {

	}

	public Pista(int id, String urbanizacion) {
		super();
		this.id = id;
		this.urbanizacion = urbanizacion;
	}

	/*
	 * ************ GETTERS & SETTERS ************
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

}
