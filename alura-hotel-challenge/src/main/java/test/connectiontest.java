package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectiontest {
	
	public static void main(String[] args) {

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost/alura_hotel?useTimeZone=true&serverTimeZone=UTC"
						,"root"
						,"Ka313054");
				System.out.println("conexion correcta");
				con.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
	
	}
	
}
