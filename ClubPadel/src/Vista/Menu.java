package Vista;

import java.util.Scanner;

import Modelo.BBDD;
import Modelo.Jugador;
import Modelo.ReservasPista;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static BBDD c = new BBDD();
	static ReservasPista rp = new ReservasPista();
	static Jugador j = new Jugador();
	static EscrituraLectura e = new EscrituraLectura();

	public Menu() {

	}

	public void menu(int opcion) {
		switch (opcion) {
		case 1:
			j.registrarJugador();

			break;

		case 2:
			rp.realizarReserva();
			break;

		case 3:
			System.out.println("Elige el dia");
			int dia = sc.nextInt();
			System.out.println("Elige el mes");
			int mes = sc.nextInt();
			c.consultarPistas();
			System.out.println("Elige la pista");
			int pista = sc.nextInt();
			c.consultarReservas(dia, mes, pista);
			break;
		case 4:
			c.consultarJugadores();

			break;
		case 5:
			c.consultarPistas();
			break;
		case 6:
			e.guardarJugadorLista();
			e.escribirJugadores();
			break;
		case 7:
			e.guardarReservas();
			e.escribirReservas();
			break;
		}
	}
}
