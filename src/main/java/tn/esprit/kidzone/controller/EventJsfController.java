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

import tn.esprit.kidzone.services.IEventService;
import tn.esprit.kidzone.entity.Event;

@Scope(value = "session")
@Component(value = "eventJsfController")
@ELBeanName(value = "eventJsfController")
@Join(path = "/eventJsf", to = "/SpringMVC/eventAdd.jsf")
public class EventJsfController {
	private int idEventToBeUpdated;

	@Autowired
	IEventService eventservice;
	
	
	private int id;
	private String name;
	private String description;
	@Temporal (TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfEvent;

	
	public int getIdEventToBeUpdated() {
		return idEventToBeUpdated;
	}
	public void setIdEventToBeUpdated(int idEventToBeUpdated) {
		this.idEventToBeUpdated = idEventToBeUpdated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateOfEvent() {
		return dateOfEvent;
	}
	public void setDateOfEvent(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}

	
	public EventJsfController() {
		super();
	}
	
	public EventJsfController(int id, String name, String description, Date dateOfEvent) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateOfEvent = dateOfEvent;
	}
	
	public List<Event> getAllEvents() {
		return eventservice.getAllEvents();
	}
	 
	public String addEvent() {
		 eventservice.ajouterEventbyUser(new Event(name,description,dateOfEvent) );
		return "/SpringMVC/eventAll.xhtml?faces-redirect=true";

		}
	
	

public void deleteEvent(int Eventid) {

	eventservice.deleteEventById(Eventid);

}


public String displayEvent(Event event){
	String navigateTo = "/eventUpdate.xhtml?faces-redirect=true";
	this.setIdEventToBeUpdated(event.getId());
	this.setName(event.getName());
	this.setDescription(event.getDescription());
	this.setDateOfEvent(event.getDateOfEvent());
	return navigateTo;
}

public String updateEventjsf(){

	String navigateTo = "/eventsAll.xhtml?faces-redirect=true";
	eventservice.addorupdateEvent(new Event(idEventToBeUpdated,name,description,dateOfEvent));
	return navigateTo;
}


public String gopageEvent(Long Eventid){
	
	return "/eventUpdate.xhtml?faces-redirect=true&idevent=" + Eventid.toString();
}
}
