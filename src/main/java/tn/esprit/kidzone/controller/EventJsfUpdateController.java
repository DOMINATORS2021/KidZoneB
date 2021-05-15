package tn.esprit.kidzone.controller;

import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;
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
@Component(value = "eventJsfUpdateController")
@ELBeanName(value = "eventJsfUpdateController")
@Join(path = "/eventJsf", to = "/SpringMVC/eventAdd.jsf")
public class EventJsfUpdateController {

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

	
	public EventJsfUpdateController() {
		super();
	}
	
	public EventJsfUpdateController(int id, String name, String description, Date dateOfEvent) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateOfEvent = dateOfEvent;
	}
	String a;

	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("Eventid");
	}

	public Long outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println("****************"+a);
		return Long.parseLong(a);

	}
	
	public Event getEvetnbyId(int Eventid){
		return eventservice.getEventbyId(Eventid);
	}

public String updateEventjsf(int Eventid){
	String navigateTo = "/event";
	Event e=eventservice.getEventbyId(Eventid);
	
	e.setName(name);
	System.out.println("****************"+name);
	e.setDescription(description);
	System.out.println("****************"+description);
	e.setDateOfEvent(dateOfEvent);
	eventservice.addorupdateEvent(e);
	return navigateTo;
}
}
