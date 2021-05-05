package tn.esprit.service;

import java.sql.Date;
import java.util.List;

import tn.esprit.entities.Appointment;

public interface IAppointmentService {

	public List<Appointment> getAllAppointment();

	public String ajouter_Doctor_rendezVous(int id_doctor, int id_user, Appointment appointment);

	public String update_appointment_By_User(int user_id, int appointment_id, Appointment appointment);

	public String update_appointment_By_Doctor(int doctor_id, int appointment_id, Appointment appointment);

	public String delete_appointment(int user_id, int id_appointment);

	public List<Appointment> getallappointment_status_1(int id_medecin);

	public String accepte_appointment(int Doctor_id, int id_appointment);

	public String refut_appointment(int Doctor_id, int id_appointment);

	public List<Appointment> findParentAppointment(int parent_id);

	List<Appointment> FindDateAppointmentDoctor(Date date, int doctor_id);

	List<Appointment> FindAppointmentsByparent(int parent_id);

}
