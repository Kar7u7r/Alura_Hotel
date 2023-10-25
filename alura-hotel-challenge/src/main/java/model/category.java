package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class category {

	private Integer id;
	private String gname;
	private String gsurname;
	private Date date;
	private String nationality;
	private String phone;
	private Integer idR;

	private List<DataHotel> dataH;

	public category(int id, String gname, String gsurname, Date date, String nationality, String phone, int idR) {
		this.id = id;
		this.gname = gname;
		this.gsurname = gsurname;
		this.date = date;
		this.nationality = nationality;
		this.phone = phone;
		this.idR = idR;
	}

	@Override
	public String toString() {
		return "Category [gname=" + gname + ", gsurname=" + gsurname + ", date=" + date + ", nationality=" + nationality
				+ ", phone=" + phone + "]";
	}

	public int getId() {
		return this.id;
	}

	public int getIdR() {
		return this.idR;
	}

	public void add(DataHotel data) {
		if (this.dataH == null) {
			this.dataH = new ArrayList<>();
		}
		this.dataH.add(data);
	}
	

	public List<DataHotel> getProducts() {
		return this.dataH;
	}

}
