package model;

import java.util.Date;

public class Donation {
	private int id;
	private String nic;
	private Date date;
	private String city;
	private String bloodType;
	
	
	public Donation(int id, String nic, Date date, String city, String bloodType) {
		super();
		this.id = id;
		this.nic = nic;
		this.date = date;
		this.city = city;
		this.bloodType = bloodType;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getBloodType() {
		return bloodType;
	}


	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	
}
