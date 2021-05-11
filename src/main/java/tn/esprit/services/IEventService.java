package tn.esprit.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.entities.Event;

import java.util.List;

public interface IEventService {

	public ResponseEntity<String> ajout(Event event, int kinderId,int userId,MultipartFile file);

	public List<Event> getAllEvents();

	public void deleteEventById(int EventId);

	public int getNombreEventJPQL();

	public List<String> getAllEventNamesJPQL();

	public void updateEvent(Event e, int idEvent, MultipartFile file);

	public List<Event> getAllEventPourToday();

	public List<Event> getAllEventOrdonneParDate();
}
