package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sun.istack.NotNull;



@Entity
public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String FirstName;
	
	private String LastName;
	@NotNull
	private String Email;
	
	private String Password;
	
	private String Phone;
	
	private boolean isActif;
	
	@Temporal(TemporalType.DATE)
	private Date DateOfBirth;
	
	private String Photo;
	
	private String Adress;
	
	
	@ManyToMany(mappedBy="user")
	private List<Kindergarten> kinder;
	

	
	
	@OneToOne(mappedBy="userkinder")
	private Kindergarten kindergarten;

	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User () 
	{
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getPhone() {
		return Phone;
	}



	public void setPhone(String phone) {
		Phone = phone;
	}



	public String getPhoto() {
		return Photo;
	}



	public void setPhoto(String photo) {
		Photo = photo;
	}



	public String getAdress() {
		return Adress;
	}



	public void setAdress(String adress) {
		Adress = adress;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}







	public Kindergarten getKindergarten() {
		return kindergarten;
	}



	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}




	public List<Kindergarten> getKinder() {
		return kinder;
	}



	public void setKinder(List<Kindergarten> kinder) {
		this.kinder = kinder;
	}








	



	

	

	



	
	
	
	
	
	
}
