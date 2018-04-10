package Modelo;

import java.util.Scanner;

public class ReservasPista {
	int id;
	int mes;
	int dia;
	int hora;
	static BBDD c = new BBDD();
	static Jugador j = new Jugador();
	static Scanner sc = new Scanner(System.in);

	/*
	 * ************ CONSTRUCTOR ************
	 */

	public ReservasPista() {

	}

	public ReservasPista(int id, int mes, int dia, int hora) {
		this.id = id;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
	}

	/*
	 * ************ GETTERS & SETTERS ************
	 */

	public int getMes() {
		return mes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	/*
	 * ************ DATOS RESERVAS PISTA ************
	 */

	public ReservasPista realizarReserva() {

		System.out.println("Introduce el dia");
		dia = sc.nextInt();

		System.out.println("Introduce el mes");
		mes = sc.nextInt();

		System.out.println("Introduce la hora");
		hora = sc.nextInt();

		c.consultarPistas();

		System.out.println("Selecciona una pista");
		id = sc.nextInt();

		ReservasPista rp = new ReservasPista(id, dia, mes, hora);
		c.realizarReserva(rp, j.registrarJugador());

		return rp;
	}

}
