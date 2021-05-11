package tn.esprit.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import tn.esprit.services.IActivityService;
import tn.esprit.entities.Activity;
import tn.esprit.entities.Category;

@Scope(value = "session")
@Component(value = "activityJsfController")
@ELBeanName(value = "activityJsfController")
@Join(path = "/activityJsf", to = "/SpringMVC/activityAdd.jsf")
public class ActivityJsfController {

	@Autowired
	IActivityService activityservice;
	
	
	private int id;
	private String name;
	private String description;
	@Temporal (TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfActivity;
	
	@Enumerated(EnumType.STRING) 
	private Category category;
	
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
	public Date getDateOfActivity() {
		return dateOfActivity;
	}
	public void setDateOfActivity(Date dateOfActivity) {
		this.dateOfActivity = dateOfActivity;
	}

	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ActivityJsfController() {
		super();
	}
	
	public ActivityJsfController(int id, String name, String description, Date dateOfActivity) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateOfActivity = dateOfActivity;
	}
	
	public List<Activity> getAllActivities() {
		return activityservice.getAllActivity();
	}
	 
	public String addActivity() {
		activityservice.ajouterActivity(new Activity(name,description,dateOfActivity,category) );
		return "/SpringMVC/eventAll.xhtml?faces-redirect=true";

		}
	
	public Category[] getCategories() { return Category.values(); }	

public void deleteEvent(int activityId) {

	activityservice.deleteActivityById(activityId);

}


public void displayEvent(Activity activity){
	this.setName(activity.getName());
	this.setDescription(activity.getDescription());
	
}

public String updateEventjsf(int Eventid){
	String navigateTo = "/event";
	Activity e=activityservice.getActivitybyId(Eventid);
	
	e.setName(name);
	System.out.println("****************"+name);
	e.setDescription(description);
	System.out.println("****************"+description);
	e.setDateOfActivity(dateOfActivity);
	activityservice.saveActivity(e);
	return navigateTo;
}


public String gopageEvent(Long Eventid){
	
	return "/eventUpdate.xhtml?faces-redirect=true&idstock=" + Eventid.toString();
}
}
