package Vista;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Modelo.BBDD;
import Modelo.Jugador;
import Modelo.Pista;
import Modelo.ReservasPista;

public class EscrituraLectura {
	private ArrayList<Pista> pistaL = new ArrayList<Pista>();
	private ArrayList<ReservasPista> reservasPistaL = new ArrayList<ReservasPista>();
	private ArrayList<String> jugadorL = new ArrayList<String>();
	private ArrayList<String> reservasL = new ArrayList<String>();

	static BBDD c = new BBDD();

	/*
	 * ************* SELECCION DE LA RUTA DEL FICHERO *************
	 */

	public static Path jugadoresS = Paths
			.get("/Users/sergioromero/Documents/SR/workspace/ClubPadel/ficheros/clubpadel.txt");
	public static Path jugadoresE = Paths
			.get("/Users/sergioromero/Documents/SR/workspace/ClubPadel/ficheros/clubpadel.txt");

	/*
	 * ************* CONSULTAR ARTICULO PARA ESCRIBIR EN EL FICHERO
	 * *************
	 */

	public ArrayList<String> guardarJugadorLista() {
		Connection con = null;
		Statement stmt = null;
		String usuario;
		int cont = 0;
		try {

			con = c.conectar(con);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select usuario from jugadores");
			while (rs.next()) {
				usuario = rs.getString(1);
				cont++;
				jugadorL.add(usuario);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugadorL;
	}

	public void escribirJugadores() {
		String temp = "";
		for (int i = 0; i < jugadorL.size(); i++) {
			temp = temp + "\r" + jugadorL.get(i);
		}
		byte[] b = temp.getBytes();
		try {
			Files.write(jugadoresS, b);
		} catch (IOException io) {
			System.err.println(io);
		}
	}

	public ArrayList<String> guardarReservas() {
		Connection con = null;
		Statement stmt = null;
		String polideportivo = "";
		int hora;
		int dia;
		int mes;
		String usuario = "";
		int cont = 0;
		try {

			con = c.conectar(con);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select usuario, polideportivo, dia, mes, hora from jugadores j, pistas p, reservas r where r.idjugador=j.id and p.id=r.idpista ");
			while (rs.next()) {
				usuario = rs.getString(1);
				polideportivo = rs.getString(2);
				dia = rs.getInt(3);
				mes = rs.getInt(4);
				hora = rs.getInt(5);
				cont++;
				String reserva = cont + " - " + polideportivo + " | Dia: " + dia + " | Mes: " + mes + " | Hora : "
						+ hora + " | Usuario: " + usuario;
				reservasL.add(reserva);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservasL;
	}

	public void escribirReservas() {
		String temp = "";
		for (int i = 0; i < reservasL.size(); i++) {
			temp = temp + "\r" + reservasL.get(i);
		}
		byte[] b = temp.getBytes();
		try {
			Files.write(jugadoresS, b);
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
