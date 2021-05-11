package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

	@Query("SELECT count (*) from Event")
	public int getNombreEventJPQL();
	@Query("SELECT Name	 from Event")
	public List<String> getAllEventNamesJPQL() ;

	@Query("SELECT DISTINCT event from Event event where event.Name=:name ")
	public Event getEvent(@Param("name") String name);

	@Query("SELECT e from Event e where e.DateOfEvent = CURRENT_DATE()")
	public List<Event> getAllEventPourToday();

	@Query("SELECT e from Event e  order by e.DateOfEvent")
	public List<Event> getAllEventOrdonneParDate();

}
