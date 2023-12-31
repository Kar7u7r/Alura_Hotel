package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import conexion.ConexionFactory;

public class reservasDAO {
	private Connection con;

	public reservasDAO(Connection con) {
		this.con = con;
	}
	private int idreservation;

	public int guardarreservas(java.util.Date date, java.util.Date date2, String c, String d) throws SQLException {
	    try (
	            // statement para guardar reserva
	            PreparedStatement statement = con.prepareStatement(
	                    "INSERT INTO reservations (DATE_OF_ENTRY, DEPARTURE_DATE, Gvalue, payment) VALUES (?, ?, ?, ?);",
	                    Statement.RETURN_GENERATED_KEYS)) {

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        // guardar reserva
	        statement.setDate(1, new java.sql.Date(date.getTime()));
	        statement.setDate(2, new java.sql.Date(date2.getTime()));
	        statement.setString(3, c);
	        statement.setString(4, d);

	        int filasAfectadas = statement.executeUpdate();

	        if (filasAfectadas > 0) {
	            ResultSet generatedKeys = statement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int  idInsertado = generatedKeys.getInt(1);
	                
	                System.out.println("ID de la fila insertada: " + idInsertado);
	                return idInsertado;
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    return 0;
	}

	public int GetIdreservation(java.util.Date date, java.util.Date date2, String c, String d) throws SQLException {
		try (
				// statement para obtener id
				PreparedStatement statement2 = con.prepareStatement(
						"SELECT id FROM reservations WHERE DATE_OF_ENTRY = ? AND DEPARTURE_DATE = ? AND Gvalue = ? AND payment = ? ")) {

			// conseguir Id de reserva guardada
			statement2.setDate(1, new java.sql.Date(date.getTime()));
			statement2.setDate(2, new java.sql.Date(date2.getTime()));
			statement2.setString(3, c);
			statement2.setString(4, d);

			statement2.execute();
			ResultSet resultSet = statement2.executeQuery();
			if (resultSet.next()) {
				idreservation = resultSet.getInt("id");
				System.out.println((resultSet.getInt("id")));
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Manejar la excepción adecuadamente
		}
		return idreservation;
	}
}