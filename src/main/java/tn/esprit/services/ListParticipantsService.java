package tn.esprit.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Event;
import tn.esprit.entities.ListParticipants;
import tn.esprit.entities.ListParticipantsPK;
import tn.esprit.entities.User;
import tn.esprit.repository.EventRepository;
import tn.esprit.repository.ListParticipantsRepository;
import tn.esprit.repository.UserRepository;

@Service
public class ListParticipantsService implements IListParticipantsService {

	@Autowired
	ListParticipantsRepository ListParticipantsrep;
	@Autowired
	UserRepository userrep;
	@Autowired
	EventRepository eventrep;

	@Override
	public void Participer(int userId, int eventId) {
		ListParticipants l = ListParticipantsrep.annuler(userId, eventId);
		System.out.println(l);

		if(l!=null){
			l.setEtat("annulé");
			ListParticipantsrep.save(l);	
		} else{
		ListParticipantsPK LPPK = new ListParticipantsPK();
		LPPK.setIdUser(userId);
		LPPK.setIdEvent(eventId);
		Date date = new Date(System.currentTimeMillis());
		LPPK.setDateParticipation(date);
		ListParticipants LP = new ListParticipants();
		LP.setListparticipantsPK(LPPK);
		LP.setEtat("participé");
	
		ListParticipantsrep.save(LP);
		}}

	@Override
	public List<User> getAllUserByEvent(int eventId) {
		return ListParticipantsrep.getAllUserByEvent(eventId);
	}

	@Override
	public List<Event> getAllEventByUser(int userId) {
		return ListParticipantsrep.getAllEventByUser(userId);
	}



}
