package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import conexion.ConexionFactory;

public class registroDAO {
	private Connection con;

	public registroDAO(Connection con) {
		this.con = con;
	}
	public void guardarRegistro(String a,String b,java.util.Date  c, String d, String e,int f) throws SQLException {
		try (
			     PreparedStatement statement = con.prepareStatement(
			         "INSERT INTO Guests (Gname, Gsurname, Date_of_birth, nationality, Phone_Number, Idreservation) ( VALUES (?, ?, ?, ?,?,?)")) {

			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			    statement.setString(1, a);
			    statement.setString(2, b);
			    statement.setDate(3, new java.sql.Date(c.getTime()));
			    statement.setString(4, d);
			    statement.setString(5, e);
			    statement.setInt(6, f);

			    statement.execute();
			} catch (SQLException ex) {
			    ex.printStackTrace();
			}

}
}
