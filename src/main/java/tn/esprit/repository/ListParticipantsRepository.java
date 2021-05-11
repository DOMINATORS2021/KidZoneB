package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Event;
import tn.esprit.entities.ListParticipants;
import tn.esprit.entities.User;

@Repository
public interface ListParticipantsRepository extends CrudRepository<ListParticipants, Integer> {

	@Query("select DISTINCT e from User e " + "join e.list_participants l " + "join l.event m " + "where m.id=:eventId")
	public List<User> getAllUserByEvent(@Param("eventId") int eventId);

	@Query("select DISTINCT e from Event e " + "join e.list_participants l " + "join l.user m " + "where m.id=:userId")
	public List<Event> getAllEventByUser(@Param("userId") int userId);

	@Query("SELECT a from ListParticipants a where a.user.id=:id AND a.event.id=:ide ")
	public ListParticipants annuler(@Param("id") int id, @Param("ide") int ide);

}
