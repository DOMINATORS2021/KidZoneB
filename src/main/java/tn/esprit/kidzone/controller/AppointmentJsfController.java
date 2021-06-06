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

import tn.esprit.kidzone.services.IAppointmentService;
import tn.esprit.kidzone.entity.Activity;
import tn.esprit.kidzone.entity.Appointment;

@Scope(value = "session")
@Component(value = "appointmentJsfController")
@ELBeanName(value = "appointmentJsfController")
@Join(path = "/appointmentJsf", to = "/SpringMVC/appointmentAdd.jsf")
public class AppointmentJsfController {

	@Autowired
	IAppointmentService appointmentservice;
	
	private int idAppointmentToBeUpdated;
	
	private int id;

	private String description;

	@Temporal (TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
	
	private String beginhour;
	
	private String endhour;
	
	private String status;	
	
	
	public int getIdAppointmentToBeUpdated() {
		return idAppointmentToBeUpdated;
	}

	public void setIdAppointmentToBeUpdated(int idAppointmentToBeUpdated) {
		this.idAppointmentToBeUpdated = idAppointmentToBeUpdated;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBeginhour() {
		return beginhour;
	}

	public void setBeginhour(String beginhour) {
		this.beginhour = beginhour;
	}

	public String getEndhour() {
		return endhour;
	}

	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AppointmentJsfController() {
		super();
	}
	
	
	public AppointmentJsfController(int id, String description, Date date,String beginhour, String endhour) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.beginhour = beginhour;
		this.endhour = endhour;
	}

	public List<Appointment> getAllAppointments() {
		return appointmentservice.getAllAppointment();
	}
	public String addAppointment() {
		appointmentservice.ajouterAppointment(new Appointment(description,date,beginhour,endhour) );
		return "/SpringMVC/eventAll.xhtml?faces-redirect=true";

		}
	
public void deleteAppointment(int appointmentId) {

	appointmentservice.deleteAppointmentbyId(appointmentId);

}


public void displayAppointment(Appointment appointment){
	String navigateTo = "/appointmentUpdate.xhtml?faces-redirect=true";
	this.setIdAppointmentToBeUpdated(appointment.getId());
	this.setDescription(appointment.getDescription());
	this.setDate(appointment.getDate());
	this.setBeginhour(appointment.getBeginhour());
	this.setEndhour(appointment.getEndhour());
	
}

public String updateAppointmentjsf(){
	String navigateTo = "/appointmentAll.xhtml?faces-redirect=true";
	appointmentservice.addorupdateAppointment(new Appointment(idAppointmentToBeUpdated,description,date,beginhour,endhour));
	return navigateTo;
}


public String gopageAppointment(Long appointmentId){
	
	return "/appointmentUpdate.xhtml?faces-redirect=true&idappointment=" + appointmentId.toString();
}




public List<Appointment> getAllAppointmentsPourToday() {
	return appointmentservice.getAllAppointmentsPourToday();
}


public int getNombreAppointmentJPQL() {
	return appointmentservice.getNombreAppointmentJPQL();
}
}
