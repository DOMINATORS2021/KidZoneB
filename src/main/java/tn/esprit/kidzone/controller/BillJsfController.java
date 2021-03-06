package tn.esprit.kidzone.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import tn.esprit.kidzone.entity.Bill;
import tn.esprit.kidzone.services.IBillService;

@Scope(value = "session")
@Component(value = "billJsfController")
@ELBeanName(value = "billJsfController")
@Join(path = "/billJsf", to = "/SpringMVC/billAdd.jsf")
public class BillJsfController {

	@Autowired
	IBillService billsservice;
	
	
	private int id;

	private String description;

	@Temporal (TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBill;
	
	private float totalPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfBill() {
		return dateOfBill;
	}

	public void setDateOfBill(Date dateOfBill) {
		this.dateOfBill = dateOfBill;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public BillJsfController() {
		super();
	}
	
	
	public BillJsfController(int id, String description, Date dateOfBill,float totalPrice) {
		super();
		this.id = id;
		this.description = description;
		this.dateOfBill = dateOfBill;
		this.totalPrice = totalPrice;
	}

	
	public String addBill() {
		billsservice.ajouterBill(new Bill(description,dateOfBill,totalPrice) );
		return "/SpringMVC/billAll.xhtml?faces-redirect=true";

		}
	
public void deleteBill(int bill_Id) {

	billsservice.deleteBillbyId(bill_Id);

}


public void displayAppointment(Bill appointment){
	this.setDescription(appointment.getDescription());
	this.setDateOfBill(appointment.getDateOfBill());
	this.setTotalPrice(appointment.getTotalPrice());
	
}

public String updateAppointmentjsf(int bill_Id){
	String navigateTo = "/event";
	Bill e=billsservice.getBillbyId(bill_Id);
	
	e.setDescription(description);
	System.out.println("****************"+description);
	e.setDateOfBill(dateOfBill);
	System.out.println("****************"+dateOfBill);
	e.setTotalPrice(totalPrice);
	System.out.println("****************"+totalPrice);
	billsservice.saveBill(e);
	return navigateTo;
}
}
