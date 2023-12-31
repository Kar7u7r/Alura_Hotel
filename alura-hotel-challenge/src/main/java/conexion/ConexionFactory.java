package conexion;

import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConexionFactory {

	private DataSource datasource;

	public ConexionFactory() {
		
		var poolDataSource = new ComboPooledDataSource();
		poolDataSource.setJdbcUrl("jdbc:mysql://localhost/alura_hotel?useTimeZone=true&serverTimeZone=UTC");
		poolDataSource.setUser("root");
		poolDataSource.setPassword("karolaadrian23");
		poolDataSource.setMaxPoolSize(10);

		this.datasource = poolDataSource;
	}

	public Connection recuperaConexion() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
