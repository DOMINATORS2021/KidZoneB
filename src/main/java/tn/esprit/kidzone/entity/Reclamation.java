package tn.esprit.kidzone.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reclamation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 10, max = 300)
	private String Description;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date DateOfReclam;
	
	private String Type;

	private Status Status;

	@Lob
	@Column (columnDefinition="MEDIUMBLOB")
	private String Photo;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@JsonIgnore
	@ManyToOne
	private Kindergarten kindergarten;
	
	public Reclamation () {}
	
	public Reclamation(String description, Date dateOfReclam, String type, Status status,String photo) {
		super();
		Description = description;
		DateOfReclam = dateOfReclam;
		Type = type;
		Status = status;
		Photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDateOfReclam() {
		return DateOfReclam;
	}

	public void setDateOfReclam(Date dateOfReclam) {
		DateOfReclam = dateOfReclam;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
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

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}

}
