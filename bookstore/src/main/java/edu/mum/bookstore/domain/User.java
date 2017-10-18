package edu.mum.bookstore.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private int id;
	
	@NotEmpty
	private String username;
	
	@NotEmpty	
	private String firstName;

	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String zipcode;
	
	@NotEmpty
	private String phone;
	
	//0- admin, 1-user;
	private int role = 1;
	
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = true)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = true)
    private Date updated;

    @PrePersist
    protected void onCreate() {
    	updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	
    	updated = new Date();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	public String getRoleDescription() {
		return role==0?"admin":"user";
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", address=" + address + ", zipcode=" + zipcode + ", phone=" + phone
				+ ", role=" + role + ", created=" + created + ", updated=" + updated + "]";
	}

}
