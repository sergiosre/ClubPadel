package Modelo;

import java.util.Scanner;

public class Jugador {
	int id;
	String usuario;
	static Scanner sc = new Scanner(System.in);

	static BBDD c = new BBDD();

	public Jugador() {

	}

	public Jugador(int id, String usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public Jugador(String usuario) {
		this.usuario = usuario;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/*
	 * ************ REGISTRO DE JUGADOR ************
	 */

	public Jugador registrarJugador() {

		System.out.println("Inserta el nombre de usuario");
		usuario = sc.nextLine();

		Jugador j = new Jugador(usuario);
		c.insertarJugador(j);
		return j;
	}

}
