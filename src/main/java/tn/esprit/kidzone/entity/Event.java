package tn.esprit.kidzone.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event implements Serializable {

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
	
	private int NbPlaces;
	

	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateOfEvent;
	@Lob
	@Column (columnDefinition="MEDIUMBLOB")
	private String Photo;
	
	public Event(String name, String description, Date dateOfEvent, String photo,int nbPlaces) {
		super();
		Name = name;
		Description = description;
		DateOfEvent = dateOfEvent;
		Photo = photo;
		NbPlaces=nbPlaces;
	}


	public int getNbPlaces() {
		return NbPlaces;
	}


	public void setNbPlaces(int nbPlaces) {
		NbPlaces = nbPlaces;
	}


	public String getPhoto() {
		return Photo;
	}


	public void setPhoto(String photo) {
		Photo = photo;
	}

	@JsonIgnore
	@OneToMany(mappedBy="event")
	private  List<ListParticipants> list_participants;
	@JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private Kindergarten kindergarten;
	
	public Event() {}


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

	public Date getDateOfEvent() {
		return DateOfEvent;
	}

	public void setDateOfEvent(Date dateOfEvent) {
		DateOfEvent = dateOfEvent;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	

	public List<ListParticipants> getList_participants() {
		return list_participants;
	}

	public void setList_participants(List<ListParticipants> list_participants) {
		this.list_participants = list_participants;
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


	public Event(int id, String name, String description, Date dateOfEvent,int nbPlaces) {
		super();
		this.id = id;
		Name = name;
		Description = description;
		DateOfEvent = dateOfEvent;
		NbPlaces=nbPlaces;

	}


	public Event(String name, String description, Date dateOfEvent,int nbPlaces) {
		super();
		Name = name;
		Description = description;
		DateOfEvent = dateOfEvent;
		NbPlaces=nbPlaces;

	}








	
	

	
	
	

}
