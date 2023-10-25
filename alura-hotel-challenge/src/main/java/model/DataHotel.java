package model;

import java.sql.Date;

public class DataHotel {

	private Integer id;
	private String gname;
	private String gsurname;
	private Date date;
	private String nationality;
	private String phone;
	private Integer idR;

	public DataHotel(int id, String gname, String gsurname, Date date, String nationality, String phone, int idR) {
		this.id = id;
		this.gname = gname;
		this.gsurname = gsurname;
		this.date = date;
		this.nationality = nationality;
		this.phone = phone;
		this.idR = idR;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGsurname() {
		return gsurname;
	}

	public void setGsurname(String gsurname) {
		this.gsurname = gsurname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIdR() {
		return idR;
	}

	public void setIdR(Integer idR) {
		this.idR = idR;
	}
	
	 @Override
	    public String toString() {
	        return "DataHotel [id=" + id + ", gname=" + gname + ", gsurname=" + gsurname +
	                ", date=" + date + ", nationality=" + nationality + ", phone=" + phone +
	                ", idR=" + idR + "]";
	    }

}
