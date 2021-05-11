package tn.esprit.controller;

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

import tn.esprit.services.IEventService;
import tn.esprit.entities.Event;

@Scope(value = "session")
@Component(value = "eventJsfController")
@ELBeanName(value = "eventJsfController")
@Join(path = "/eventJsf", to = "/SpringMVC/eventAdd.jsf")
public class EventJsfController {

	@Autowired
	IEventService eventservice;
	
	
	private int id;
	private String name;
	private String description;
	@Temporal (TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfEvent;

	
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


public void displayEvent(Event event){
	this.setName(event.getName());
	this.setDescription(event.getDescription());
	this.setDateOfEvent(event.getDateOfEvent());
	
}

public String updateEventjsf(int Eventid){
	String navigateTo = "/event";
	Event e=eventservice.getEventbyId(Eventid);
	
	e.setName(name);
	System.out.println("****************"+name);
	e.setDescription(description);
	System.out.println("****************"+description);
	e.setDateOfEvent(dateOfEvent);
	eventservice.saveEvent(e);
	return navigateTo;
}


public String gopageEvent(Long Eventid){
	
	return "/eventUpdate.xhtml?faces-redirect=true&idstock=" + Eventid.toString();
}
}
