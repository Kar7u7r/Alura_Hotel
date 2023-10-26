package DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Booking;
import model.Guest;

public class ReservasBusquedaDAO {

	final private Connection con;

	public ReservasBusquedaDAO(Connection con) {
		this.con = con;
	}

	public List<Object> listarporId(Long id) {
		List<Object> resultado = new ArrayList<>();
		String sql = "SELECT guests.id, guests.gname, guests.gsurname, guests.nationality, "
		           + "guests.phone_number, guests.date_of_birth, guests.idreservation, "
		           + "reservations.id, reservations.date_of_entry, reservations.departure_date, "
		           + "reservations.gvalue, reservations.payment"
		           + " FROM guests INNER JOIN reservations ON guests.id = reservations.id "
		           + "WHERE guests.idreservation = ?";
		try (con) {
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setLong(1,id);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					 Guest filaHuesped = new Guest(
							 rs.getLong("id"),
							 rs.getString("gname"),
							 rs.getString("gsurname"),
			                 rs.getString("nationality"),
			                 rs.getString("phone_number"), 
			                 rs.getDate("date_of_birth"),
			                 rs.getLong("idreservation"));
					 Booking filaReserva = new Booking(
							 rs.getLong("guests.idreservation"),
							 rs.getDate("reservations.date_of_entry"),
							 rs.getDate("reservations.departure_date"),
							 rs.getDouble("reservations.gvalue"),
							 rs.getString("reservations.payment"));

					resultado.add(filaHuesped);
					resultado.add(filaReserva);
				}
			}

			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> listarporApellido(String apellido) {
		List<Object> resultado = new ArrayList<>();
		String sql = "SELECT guests.id, guests.gname, guests.gsurname, guests.nationality, "
		           + "guests.phone_number, guests.date_of_birth, guests.idreservation, "
		           + "reservations.id, reservations.date_of_entry, reservations.departure_date, "
		           + "reservations.gvalue, reservations.payment"
		           + " FROM guests INNER JOIN reservations ON guests.id = reservations.id "
		           + "WHERE guests.gsurname like ?";
		try (con) {
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setString(1,apellido);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					 Guest filaHuesped = new Guest(
							 rs.getLong("id"),
							 rs.getString("gname"),
							 rs.getString("gsurname"),
			                 rs.getString("nationality"),
			                 rs.getString("phone_number"), 
			                 rs.getDate("date_of_birth"),
			                 rs.getLong("idreservation"));
					 Booking filaReserva = new Booking(
							 rs.getLong("guests.idreservation"),
							 rs.getDate("reservations.date_of_entry"),
							 rs.getDate("reservations.departure_date"),
							 rs.getDouble("reservations.gvalue"),
							 rs.getString("reservations.payment"));

					resultado.add(filaHuesped);
					resultado.add(filaReserva);
				}
			}

			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void modificarHuespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono) {
		String sql = "UPDATE guests SET first_name= ? , last_name = ?,nationality = ?,phone_number = ?,"
				+ " birth_date = ? WHERE id = ? ";
		try (con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setString(1, nombre);
				pstmt.setString(2, apellido);
				pstmt.setString(4, nacionalidad);
				pstmt.setString(3, telefono);
				pstmt.setDate(5, fechaNacimiento);
				pstmt.setInt(6, id);
				
				pstmt.executeUpdate();
				} 
			}catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public void modificarReservas(Integer id, Date checkIn, Date checkOut, Double valor, String formaPago) {
			String sql = "UPDATE reservations SET date_of_entry = ? , departure_date = ?,gvalue= ?,payment = ?"
					+ " WHERE id = ? ";
			try (con) {
				try(PreparedStatement pstmt = con.prepareStatement(sql)){
					
					pstmt.setDate(1, checkIn);
					pstmt.setDate(2, checkOut);
					pstmt.setDouble(3, valor);
					pstmt.setString(4, formaPago);
					pstmt.setInt(5, id);
					
					pstmt.executeUpdate();
					} 
				}catch (SQLException e) {
					throw new RuntimeException(e);
			}
		
	}

	public void eliminarReserva(Integer id) {
		String sql = "DELETE FROM reservations WHERE id = ?";
		try (con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1, id);
				
				pstmt.executeUpdate();
				} 
			}catch (SQLException e) {
				throw new RuntimeException(e);
		}
		
	}

	public void eliminarHuesped(Integer id) {
		String sql = "DELETE FROM guests WHERE id = ?";
		try (con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1, id);
				
				pstmt.executeUpdate();
				} 
			}catch (SQLException e) {
				throw new RuntimeException(e);
		}
		
	}

	public List<Object> listartodo() {
	    List<Object> resultado = new ArrayList<>();
	    String sql = "SELECT * FROM guests, reservations";
	    try (con) {
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Guest filaHuesped = new Guest(
	                        rs.getLong("id"),
	                        rs.getString("gname"),
	                        rs.getString("gsurname"),
	                        rs.getString("nationality"),
	                        rs.getString("phone_number"), 
	                        rs.getDate("date_of_birth"),
	                        rs.getLong("idreservation"));
	                Booking filaReserva = new Booking(
	                        rs.getLong("idreservation"),
	                        rs.getDate("date_of_entry"),
	                        rs.getDate("departure_date"),
	                        rs.getDouble("gvalue"),
	                        rs.getString("payment"));
	                resultado.add(filaHuesped);
	                resultado.add(filaReserva);
	            }
	        }
	        return resultado;
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


}