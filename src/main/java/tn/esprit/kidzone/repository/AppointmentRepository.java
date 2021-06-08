package tn.esprit.kidzone.repository;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.kidzone.entity.Appointment;



@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	@Query("select a  from Appointment a  join a.doctor g WHERE  a.date =:date and g.id =:doctor_id and status='1'")
	List<Appointment> FindDateAppointmentDoctor(@Param("date") java.util.Date date,@Param("doctor_id") Long doctor_id);

	
	@Query("select a  from Appointment a  join a.user  u WHERE  u.id =:parent_id and status='1'")
	List<Appointment> FindAppointmentsByparent(@Param("parent_id") Long parent_id);

	@Query("SELECT e from Appointment e where e.date = CURRENT_DATE()")
	public List<Appointment> getAllAppointmentsPourToday();
	
	@Query("SELECT count (*) from Appointment")
	public int getNombreAppointmentJPQL();

}

