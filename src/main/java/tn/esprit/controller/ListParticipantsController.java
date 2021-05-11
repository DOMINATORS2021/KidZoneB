package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Event;
import tn.esprit.entities.User;
import tn.esprit.services.IListParticipantsService;;

@RestController
public class ListParticipantsController {

	@Autowired
	IListParticipantsService ilistservice;

	// http://localhost:8081/SpringMVC/servlet/Participer
	// {"missionId":1,"employeId":2,"dateDebut":"2020-03-01","dateFin":"2021-03-01"}

	@PostMapping("/Participer/{iduser}/{idevent}")
	@ResponseBody
	public void Participer(@PathVariable("iduser") int userId, @PathVariable("idevent") int eventId) {
		ilistservice.Participer(userId, eventId);

	}

	// URL : http://localhost:8081/SpringMVC/servlet/getAllUserByEvent/12
	@GetMapping("/getAllUserByEvent/{idevent}")
	@ResponseBody
	public List<User> getAllUserByEvent(@PathVariable("idevent") int eventId) {

		return ilistservice.getAllUserByEvent(eventId);
	}

	// URL : http://localhost:8081/SpringMVC/servlet/getAllEventByUser/12
	@GetMapping("/getAllEventByUser/{iduser}")
	@ResponseBody
	public List<Event> getAllEventByUser(@PathVariable("iduser") int userId) {

		return ilistservice.getAllEventByUser(userId);
	}

}
