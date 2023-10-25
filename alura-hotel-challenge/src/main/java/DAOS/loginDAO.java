package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import conexion.ConexionFactory;

public class loginDAO {
	private Connection con;

	public loginDAO(Connection con) {
		this.con = con;
	}

	public boolean useracces(String a, String b) throws SQLException {


		PreparedStatement statement = con.prepareStatement(
				"select user_name, user_password from users where user_name = ? and user_password = ?");

		statement.setString(1, a);
		statement.setString(2, b);

		statement.execute();

		ResultSet resultset = statement.getResultSet();

		return resultset.next();

	}

	

}
