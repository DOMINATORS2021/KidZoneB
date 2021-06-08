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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date DateOfBill;
	
	private float TotalPrice;
	


@Transient
   private String  usnm ;
@JsonIgnore
	@ManyToOne
	private User user;
	@Transient
	   private String  kindername ;

	@JsonIgnore
	@ManyToOne
	private Kindergarten kindergarten;
	
	public Bill () {}
	

	public String getKindername() {
		return kindername;
	}


	public void setKindername(String kindername) {
		this.kindername = kindername;
	}


	public int getId() {
		return id;
	}

	public String getUsnm() {
		return usnm;
	}

	public void setUsnm(String usnm) {
		this.usnm = usnm;
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

	public Bill(String description, Date dateOfBill, float totalPrice) {
		super();
		Description = description;
		DateOfBill = dateOfBill;
		TotalPrice = totalPrice;
	}
	
	
	public Bill(int id ,String description, Date dateOfBill, float totalPrice) {
		super();
		this.id=id;
		Description = description;
		DateOfBill = dateOfBill;
		TotalPrice = totalPrice;
	}
	
	




	public Bill(String description, Date dateOfBill, float totalPrice, User user, Kindergarten kindergarten) {
		super();
		Description = description;
		DateOfBill = dateOfBill;
		TotalPrice = totalPrice;
		this.user = user;
		this.kindergarten = kindergarten;
	}

	public Bill(int id, String description, Date dateOfBill, float totalPrice, User user, Kindergarten kindergarten) {
		super();
		this.id = id;
		Description = description;
		DateOfBill = dateOfBill;
		TotalPrice = totalPrice;
		this.user = user;
		this.kindergarten = kindergarten;
	}





	



	
	
	

	
}
