package Modelo;

import java.sql.*;

public class BBDD {

	public BBDD() {

	}

	public Connection conectar(Connection c) {
		String sDriver = "com.mysql.jdbc.Driver";
		String sURL = "jdbc:mysql://localhost:3306/clubpadel";

		try {
			Class.forName(sDriver).newInstance();
			c = DriverManager.getConnection(sURL, "root", "");

			/*
			 * if (c != null)
			 * System.out.println("Conectado a la base de datos");
			 */

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void insertarJugador(Jugador j) {

		Connection con = null;
		con = conectar(con);
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("insert into jugadores values (?,?)");
			stmt.setInt(1, 0);
			stmt.setString(2, j.getUsuario());

			stmt.executeUpdate();

			/*
			 * if (filaInsertada > 0) System.out.println("fila insertada");
			 */

			con.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	public void consultarPistas() {

		Connection con = null;
		Statement stmt = null;
		try {

			con = conectar(con);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from pistas");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " ");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void realizarReserva(ReservasPista rp, Jugador j) {
		Connection con = null;
		con = conectar(con);
		PreparedStatement stmt = null;
		int idjugador = consultarIdJugadorBbdd(j);

		try {

			stmt = con.prepareStatement("insert into reservas values (?,?,?,?,?)");
			stmt.setInt(1, idjugador);
			stmt.setInt(2, rp.getId());
			stmt.setInt(3, rp.getDia());
			stmt.setInt(4, rp.getMes());
			stmt.setInt(5, rp.getHora());

			stmt.executeUpdate();

			/*
			 * if (filaInsertada > 0) System.out.println("fila insertada");
			 */

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int consultarIdJugadorBbdd(Jugador j) {
		Connection con = null;
		Statement stmt = null;
		int id = 0;
		try {

			con = conectar(con);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id from jugadores where usuario='" + j.getUsuario() + "'");
			rs.next();
			id = rs.getInt(1);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String consultarJugadores() {
		Connection con = null;
		Statement stmt = null;
		String usuario = "";
		int cont = 0;
		try {

			con = conectar(con);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select usuario from jugadores");
			while (rs.next()) {
				usuario = rs.getString(1);
				cont++;
				System.out.println(cont + " - " + usuario);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void consultarReservas(int dia, int mes, int pista) {
		Connection con = null;
		Statement stmt = null;
		String polideportivo = "";
		int hora;
		String usuario = "";
		int cont = 0;
		try {

			con = conectar(con);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select p.polideportivo, r.hora, j.usuario from reservas r, pistas p, jugadores j where r.dia="
							+ dia + " and r.mes=" + mes + " and r.idpista=" + pista
							+ " and r.idpista=p.id and r.idjugador=j.id");
			while (rs.next()) {
				usuario = rs.getString(1);
				hora = rs.getInt(2);
				usuario = rs.getString(3);
				cont++;
				System.out.println(cont + " - " + polideportivo + " | Hora : " + hora + " | Usuario: " + usuario);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
