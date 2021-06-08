package tn.esprit.kidzone.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 2, max = 30)
	private String Name;
	
	@Size(min = 5, max = 300)
	private String Description;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateOfActivity;
	
	@Lob
	@Column (columnDefinition="MEDIUMBLOB")
	private String Photo;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public Activity(String name, String description, Date dateOfActivity, Category category) {
		super();
		Name = name;
		Description = description;
		DateOfActivity = dateOfActivity;
		this.category = category;
	}

	public Activity(int id,String name, String description, Date dateOfActivity, Category category) {
		super();
		this.id=id;
		Name = name;
		Description = description;
		DateOfActivity = dateOfActivity;
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Activity () {}
   @JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private Kindergarten kindergarten;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDateOfActivity() {
		return DateOfActivity;
	}

	public void setDateOfActivity(Date dateOfActivity) {
		DateOfActivity = dateOfActivity;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
