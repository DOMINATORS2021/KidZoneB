package tn.esprit.kidzone.services;

import java.sql.Date;
import java.util.List;

import tn.esprit.kidzone.entity.Appointment;

public interface IAppointmentService {

	public List<Appointment> getAllAppointment();

	public String ajouter_Doctor_rendezVous(Long id_doctor, Long id_user, Appointment appointment);

	public String update_appointment_By_User(Long user_id, int appointment_id, Appointment appointment);

	public String update_appointment_By_Doctor(Long doctor_id, int appointment_id, Appointment appointment);

	public String delete_appointment(Long user_id, int id_appointment);

	public List<Appointment> getallappointment_status_1(Long id_medecin);

	public String accepte_appointment(Long Doctor_id, int id_appointment);

	public String refut_appointment(Long Doctor_id, int id_appointment);

	public List<Appointment> findParentAppointment(Long parent_id);

	List<Appointment> FindDateAppointmentDoctor(Date date, Long doctor_id);

	List<Appointment> FindAppointmentsByparent(Long parent_id);

	//JSF
	
	public List<Appointment> getAllAppointmentsPourToday();

	public void ajouterAppointment(Appointment appointment);

    public Appointment getAppointmentbyId(int appointmentId);
    
    Appointment saveAppointment(Appointment appointment);
    public int addorupdateAppointment(Appointment appointment);

	public void deleteAppointmentbyId(int appointmentId);

	public int getNombreAppointmentJPQL();

}
