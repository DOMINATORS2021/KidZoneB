package tn.esprit.kidzone.services;

import java.util.List;

import tn.esprit.kidzone.entity.Event;
import tn.esprit.kidzone.entity.User;

public interface IListParticipantsService {

	public void Participer(Long userId, int eventId);

	public List<User> getAllUserByEvent(int eventId);

	public List<Event> getAllEventByUser(Long userId);


}
