package model;

public class Donor {
	private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String birthday;
    private String bloodType;
    private String email;
    private String nic;
    private String password;
    private String mobile;

    // Constructor
    public Donor(int id,String firstName, String lastName, String city, String birthday, String bloodType, String email, String nic, String password, String mobile) {
        this.setId(id);
    	this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.birthday = birthday;
        this.bloodType = bloodType;
        this.email = email;
        this.nic = nic;
        this.setPassword(password);
        this.mobile = mobile;
    }

    public Donor(int id2, String nic2, String firstName2, String lastName2) {
    	this.setId(id2);
    	this.firstName = firstName2;
        this.lastName = lastName2;
        this.nic = nic2;
       
	}

	// Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    
}

