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
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Description;
	
	@Temporal(TemporalType.DATE)
	private Date DateOfBill;
	
	private float TotalPrice;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Kindergarten kindergarten;
	
	public Bill () {}

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

	public Date getDateOfBill() {
		return DateOfBill;
	}

	public void setDateOfBill(Date dateOfBill) {
		DateOfBill = dateOfBill;
	}

	public float getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
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
