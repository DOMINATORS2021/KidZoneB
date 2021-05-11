package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Description;
	
	@Temporal(TemporalType.DATE)
	private Date DateDelivered;
	
	@ManyToOne 
	private Subject sub;
	
	@ManyToOne
	private User user;
	
	public Comment () {}

	public Comment(int id, String description, Date dateDelivered) {
		super();
		this.id = id;
		Description = description;
		DateDelivered = dateDelivered;
	}

	public Comment(String description, Date dateDelivered) {
		super();
		Description = description;
		DateDelivered = dateDelivered;
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

	public Date getDateDelivered() {
		return DateDelivered;
	}

	public void setDateDelivered(Date dateDelivered) {
		DateDelivered = dateDelivered;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	

}
