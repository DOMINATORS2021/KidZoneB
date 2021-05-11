package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Event;
import tn.esprit.entities.User;

public interface IListParticipantsService {

	public void Participer(int userId, int eventId);

	public List<User> getAllUserByEvent(int eventId);

	public List<Event> getAllEventByUser(int userId);


}
