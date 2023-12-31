package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import conexion.ConexionFactory;

public class RegistroHuespedesDAO {
	private Connection con;

	public RegistroHuespedesDAO(Connection con) {
		this.con = con;
	}
	public void guardarHuespedes(String nombre, String apellido, java.util.Date  date,String object,String telefono, String reservaN) {
			try (
					// statement para obtener id
					PreparedStatement statement = con.prepareStatement(
							"INSERT INTO guests (Gname, Gsurname, Date_of_birth, nationality, Phone_Number, Idreservation)"
							+ "VALUES (? ,? ,? ,? ,? ,? )")) {

				// conseguir Id de reserva guardada
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				 statement.setDate(3, new java.sql.Date(date.getTime()));
				statement.setString(4, object);
				statement.setString(5, telefono);
				statement.setString(6, reservaN);

				statement.execute();
	
			} catch (SQLException e) {
				e.printStackTrace(); // Manejar la excepción adecuadamente
			}

		
	}
}
