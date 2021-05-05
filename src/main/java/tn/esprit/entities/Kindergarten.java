package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;

@Entity
public class Kindergarten implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Name;
	
	private String Email;
	
	private String Location;
	
	private String Phone;
	
	private String Description;
	
	private String Photo;
	
	private float PricePerChild;
	
	
	
	
	@OneToOne
	private User userkinder;

	@ManyToMany
	private List<User> user;
	
	
	public Kindergarten () {}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public float getPricePerChild() {
		return PricePerChild;
	}

	public void setPricePerChild(float pricePerChild) {
		PricePerChild = pricePerChild;
	}




	




	


	public User getUserkinder() {
		return userkinder;
	}


	public void setUserkinder(User userkinder) {
		this.userkinder = userkinder;
	}


	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}






	


	

	

	
}
