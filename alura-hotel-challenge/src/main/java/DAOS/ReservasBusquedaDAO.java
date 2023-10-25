package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.category;
import views.ReservasView;

public class ReservasBusquedaDAO {
	private Connection con;

	public ReservasBusquedaDAO(Connection con) {
		this.con = con;
	}

	public List<category> list(String selected) {
		List<category> result = new ArrayList<>();
		try {
			final PreparedStatement statement = con
					.prepareStatement("select * " + " from ?" + "where gsurname like '?' ");
			try (statement) {
				final ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					while (resultSet.next()) {
						var category = new category(resultSet.getInt("id"), resultSet.getString("Gname"),
								resultSet.getString("Gsurname"), resultSet.getDate("Date_of_birth"),
								resultSet.getString("nationality"), resultSet.getString("Phone_number"),
								resultSet.getInt("Idreservation"));
						result.add(category);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

}