package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private User userkinder;
	
	@OneToMany(mappedBy="kindergarten")
	private List<Event> list_events;
	
	@OneToMany(mappedBy="kindergarten")
	private List<Child> list_child;
	
	@OneToMany(mappedBy="kindergarten")
	private List<Bill> list_fact;
	
	@OneToMany(mappedBy="kindergarten")
	private List<Activity> list_act;
	
	@OneToMany(mappedBy="kindergarten")
	private List<Reclamation> list_reclam;
	
	@OneToMany(mappedBy="kindergarten")
	private List<Publication> list_pub;
	
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getUserkinder() {
		return userkinder;
	}


	public void setUserkinder(User userkinder) {
		this.userkinder = userkinder;
	}


	public List<Event> getList_events() {
		return list_events;
	}


	public void setList_events(List<Event> list_events) {
		this.list_events = list_events;
	}


	public List<Child> getList_child() {
		return list_child;
	}


	public void setList_child(List<Child> list_child) {
		this.list_child = list_child;
	}


	public List<Bill> getList_fact() {
		return list_fact;
	}


	public void setList_fact(List<Bill> list_fact) {
		this.list_fact = list_fact;
	}


	public List<Activity> getList_act() {
		return list_act;
	}


	public void setList_act(List<Activity> list_act) {
		this.list_act = list_act;
	}


	public List<Reclamation> getList_reclam() {
		return list_reclam;
	}


	public void setList_reclam(List<Reclamation> list_reclam) {
		this.list_reclam = list_reclam;
	}


	

	

	
}
