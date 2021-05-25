package tn.esprit.kidzone.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Child implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Name;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date DateOfBirth;
	
	private String Photo;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Kindergarten kindergarten;
	
	public Child () {}

	public Child(int id, String name, Date dateOfBirth, String photo) {
		super();
		this.id = id;
		Name = name;
		DateOfBirth = dateOfBirth;
		Photo = photo;
	}




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

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	
}
