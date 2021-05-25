package tn.esprit.kidzone.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.kidzone.entity.Event;
import tn.esprit.kidzone.services.IEventService;

@Scope(value = "session")
@Component(value = "eventController")
@ELBeanName(value = "eventController")
@Join(path = "/event", to = "/SpringMVC/eventsAll.jsf")
public class EventController {

	@Autowired
	IEventService ieventservice;

	// http://localhost:8081/SpringMVC/servlet/ajout/1/2
	// attributes ,values,file
	@PostMapping(value = "/ajout/{idkinder}/{iduser}")

	public ResponseEntity<String> ajout(@ModelAttribute Event event, @PathVariable("idkinder") int kinderId,
			@PathVariable("iduser") Long userId, @RequestParam("file") MultipartFile file) {

		return ieventservice.ajout(event, kinderId, userId, file);
	}

	// http://localhost:8081/SpringMVC/servlet/getAllEvent

	public List<Event> getAllEvents() {
		return ieventservice.getAllEvents();
	}

	//http://localhost:8081/SpringMVC/servlet/Eventname
	@GetMapping("/Eventname")
	@ResponseBody
	public List<String> getAllEventNamesJPQL() {
		return ieventservice.getAllEventNamesJPQL();
	}

	// http://localhost:8081/SpringMVC/servlet/deleteEventById/1
	@DeleteMapping("/deleteEventById/{idevent}")
	@ResponseBody
	public void deleteEventById(@PathVariable("idevent") int EventId) {
		ieventservice.deleteEventById(EventId);

	}

	// http://localhost:8081/SpringMVC/servlet/NbreEvent
	@GetMapping("/NbreEvent")
	@ResponseBody
	public int getNombreEventJPQL() {
		return ieventservice.getNombreEventJPQL();
	}


	@PutMapping("/updateEvent/{idEvent}")
	@ResponseBody
	public ResponseEntity<String> updateEvent(@ModelAttribute Event e, @PathVariable("idEvent") int idEvent,
			@RequestParam("file") MultipartFile file) {
		ieventservice.updateEvent(e, idEvent, file);
		return new ResponseEntity<String>("Event updated successfully", HttpStatus.OK);

	}

	// http://localhost:8081/SpringMVC/servlet/retrievealleventsoftoday

	public List<Event> getAllEventPourToday() {
		return ieventservice.getAllEventPourToday();
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-eventsordonnebydate
	@GetMapping(value = "/retrieve-all-eventsordonnebydate")
	@ResponseBody
	public List<Event> getAllEventOrdonneParDate() {
		return ieventservice.getAllEventOrdonneParDate();
	}

}
