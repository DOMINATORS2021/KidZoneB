package tn.esprit.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.entities.Event;
import tn.esprit.entities.Kindergarten;
import tn.esprit.entities.User;
import tn.esprit.repository.EventRepository;
import tn.esprit.repository.KindergartenRepository;
import tn.esprit.repository.UserRepository;

@Service
public class EventService implements IEventService {

	@Autowired
	EventRepository eventrep;
	@Autowired
	UserRepository userrep;
	@Autowired
	KindergartenRepository kinderrep;

	@Override
	public ResponseEntity<String> ajout(Event event, int kinderId, int userId, MultipartFile file) {

		Kindergarten k = kinderrep.findById(kinderId).orElse(null);
		User u = userrep.findById(userId).orElse(null);
		if (u.getRole().toString() == "Childcare_Manger") {
			event.setKindergarten(k);
			event.setUser(u);

			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if (fileName.contains("..")) {
				System.out.println("not a a valid file");
			}
			try {
				event.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			eventrep.save(event);
			return ResponseEntity.ok("Event added successfully");
		}
		return ResponseEntity.ok("ajout non autorisé");
	}

	@Override
	public List<Event> getAllEvents() {
		return (List<Event>) eventrep.findAll();
	}

	@Override
	public void deleteEventById(int EventId) {
		Event e = eventrep.findById(EventId).orElse(null);
		eventrep.delete(e);

	}

	@Override
	public int getNombreEventJPQL() {
		return eventrep.getNombreEventJPQL();
	}

	@Override
	public List<String> getAllEventNamesJPQL() {
		return eventrep.getAllEventNamesJPQL();
	}

	@Override
	public void updateEvent(Event e, int idEvent, MultipartFile file) {
		Event event = eventrep.findById(idEvent).get();
		event.setDateOfEvent(e.getDateOfEvent());
		event.setDescription(e.getDescription());
		event.setName(e.getName());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			event.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eventrep.save(event);

	}

	@Override
	public List<Event> getAllEventPourToday() {
		return eventrep.getAllEventPourToday();
	}

	@Override
	public List<Event> getAllEventOrdonneParDate() {
		return eventrep.getAllEventOrdonneParDate();
	}

}
