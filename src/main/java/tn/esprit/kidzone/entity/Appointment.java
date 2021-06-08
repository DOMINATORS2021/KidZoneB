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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Description;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String Beginhour;
	
	private String Endhour;
	
	private int Status;
	@JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private User doctor;
	
	public Appointment () {}


	public Appointment(String description, Date date, String beginhour, String endhour) {
		super();
		Description = description;
		this.date = date;
		Beginhour = beginhour;
		Endhour = endhour;
	}

	public Appointment(int id , String description, Date date, String beginhour, String endhour) {
		super();
	this.id=id;
		Description = description;
		this.date = date;
		Beginhour = beginhour;
		Endhour = endhour;
	}

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



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public String getBeginhour() {
		return Beginhour;
	}

	public void setBeginhour(String beginhour) {
		Beginhour = beginhour;
	}

	public String getEndhour() {
		return Endhour;
	}

	public void setEndhour(String endhour) {
		Endhour = endhour;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	
	

	
	
	
 
}
