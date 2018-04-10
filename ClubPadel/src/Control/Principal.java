package Control;

import java.util.Scanner;

import Vista.Menu;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		Menu m = new Menu();

		while (opcion != 8) {
			System.out.println("¿Que quieres realizar? Selecciona una opción");
			System.out.println("1 - Insertar Jugador");
			System.out.println("2 - Realizar reserva");
			System.out.println("3 - Consultar reservas");
			System.out.println("4 - Consultar jugadores");
			System.out.println("5 - Consultar pistas");
			System.out.println("6 - Escribir jugadores en fichero");
			System.out.println("7 - Escribir reservas en fichero");
			System.out.println("8 - Salir");
			opcion = sc.nextInt();
			m.menu(opcion);
		}

	}
}
