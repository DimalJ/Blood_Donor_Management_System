package model;

import java.sql.Time;
import java.util.Date;

public class Campaign {
    private int id;
    private Date date;
    private String location;
    private String city;
    private Time time;
    public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	// Constructors
    public Campaign(int id, Date date, String location, String city, Time time) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.city = city;
        this.time = time;
    }

    public Campaign(Date date, String location, String city) {
    	this.date = date;
        this.location = location;
        this.city = city;
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
}
