package tn.esprit.kidzone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kidzone.entity.Appointment;
import tn.esprit.kidzone.entity.User;
import tn.esprit.kidzone.repository.AppointmentRepository;
import tn.esprit.kidzone.repository.UserRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	@Autowired
	AppointmentRepository appointments;
	@Autowired
	UserRepository users;

	@Override
	public List<Appointment> getAllAppointment() {
		return (List<Appointment>) appointments.findAll();
	}

	public String ajouter_Doctor_rendezVous(Long id_user, Long id_doctor, Appointment appointment) {
		User DoctorId = users.findById(id_doctor).orElse(null);
		User UserId = users.findById(id_user).orElse(null);
		if (DoctorId.getRole().toString() != "Doctor") {
			return ("id_doctor n'est pas valide");
		}
		if (UserId.getRole().toString() == "Parent") {

			List<String> compteur = new ArrayList<String>();
			for (Appointment appointment1 : appointments.FindDateAppointmentDoctor(appointment.getDate(),
					DoctorId.getId())) {
				compteur.add(appointment1.getBeginhour());
			}
			if (compteur.contains(appointment.getBeginhour())) {
				return ("hour existe");

			} else {

				appointment.setDoctor(DoctorId);
				appointment.setUser(UserId);
				appointment.setStatus(0);
				appointment.setEndhour(Integer.toString(Integer.parseInt(appointment.getBeginhour()) + 1));
				Appointment appointment2 = appointments.save(appointment);
				return ("   " + appointment2);

			}
		}

		else {
			return ("user n'est pas parent");
		}
	}

	public String delete_appointment(Long user_id, int id_appointment) {
		User UserId = users.findById(user_id).orElse(null);
		Appointment appointment = appointments.findById(id_appointment).orElse(null);
		if (appointment == null) {
			return ("appointment n'existe pas");
		}
		if (UserId.getRole().toString() == "Parent") {
			if (UserId.getId() == appointment.getUser().getId()) {

				appointments.deleteById(appointment.getId());
				return ("appointment est supprimé");
			}

			else {
				return ("Supprision non autorisée");
			}
		}

		else {
			return ("user n'est pas parent");
		}

	}

	@SuppressWarnings("unused")
	public String update_appointment_By_User(Long user_id, int appointment_id, Appointment appointment) {
		User UserId = users.findById(user_id).orElse(null);

		Appointment Update = appointments.findById(appointment_id).orElse(null);
		if (Update == null) {
			return ("appointment n'existe pas");

		}

		if (UserId.getId() == Update.getUser().getId()) {
			if (Update != null) {

				Update.setBeginhour(appointment.getBeginhour());
				Update.setDate(appointment.getDate());
				Update.setDescription(appointment.getDescription());
				Update.setEndhour(Integer.toString(Integer.parseInt(appointment.getBeginhour()) + 1));
				Update.setStatus(0);

				appointments.save(Update);
				return ("appointment est bien modifiée ");
			}

		}

		else {
			return ("Modification non autorisée");
		}
		return null;

	}

	@SuppressWarnings("unused")
	public String update_appointment_By_Doctor(Long doctor_id, int appointment_id, Appointment appointment) {
		User Doctor = users.findById(doctor_id).orElse(null);

		Appointment Update = appointments.findById(appointment_id).orElse(null);

		if (Update == null) {
			return ("appointment n'existe pas");

		}

		if (Doctor.getId() == Update.getDoctor().getId()) {
			if (Update != null) {
				Update.setBeginhour(appointment.getBeginhour());
				Update.setDate(appointment.getDate());
				Update.setDescription(appointment.getDescription());
				Update.setEndhour(Integer.toString(Integer.parseInt(appointment.getBeginhour()) + 1));
				Update.setStatus(1);

				appointments.save(Update);

				return ("appointment est bien modifiée ");
			}
		}

		else {
			return ("Modification non autorisée");
		}
		return null;

	}

	public List<Appointment> getallappointment_status_1(Long id_medecin) {
		User Doctor = users.findById(id_medecin).orElse(null);

		List<Appointment> appointment = new ArrayList<>();
		List<Appointment> appointments2 = (List<Appointment>) appointments.findAll();

		for (Appointment app : appointments2) {
			if (app.getStatus() == 1 && Doctor.getId() == app.getDoctor().getId()) {
				appointment.add(app);
			}
		}
		return appointment;
	}

	public String accepte_appointment(Long Doctor_id, int id_appointment) {

		User Doctor = users.findById(Doctor_id).orElse(null);
		Appointment appointment = appointments.findById(id_appointment).orElse(null);
		if (appointment == null) {
			return ("appointment n'existe pas");

		}
		if (Doctor.getId() == appointment.getDoctor().getId()) {
			if (appointment.getStatus() == 0) {
				appointment.setStatus(1);

				appointments.save(appointment);
				return ("appointment est  accépté");

			} else {
				return ("appointment est  déja vaildé");

			}
		} else {
			return (" tu n' as pas le droit  d'Accepter des rendez-vous pour d'autres personnes  ");
		}
	}

	public String refut_appointment(Long Doctor_id, int id_appointment) {
		User Doctor = users.findById(Doctor_id).orElse(null);

		Appointment appointment = appointments.findById(id_appointment).orElse(null);
		if (appointment == null) {
			return ("appointment n'existe pas");

		}
		if (Doctor.getId() == appointment.getDoctor().getId()) {
			if (appointment.getStatus() == 0) {

				appointments.deleteById(appointment.getId());
				return ("appointment est réfusé");

			} else {
				return ("appointment est accepté deja");

			}
		}

		else {
			return (" tu n' as pas le droit  de refuser des rendez-vous pour d'autres personnes  ");
		}
	}

	@Override
	public List<Appointment> findParentAppointment(Long parent_id) {
		return appointments.FindAppointmentsByparent(parent_id);

	}

	@Override
	public List<Appointment> FindDateAppointmentDoctor(java.sql.Date date, Long doctor_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> FindAppointmentsByparent(Long parent_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//JSF
	
	@Override
	public Appointment saveAppointment(Appointment event) {

		return appointments.save(event);
	}

	@Override
	@javax.transaction.Transactional
	public Appointment getAppointmentbyId(int appointmentId) {
		return  appointments.findById(appointmentId).get();
	}

	@Override
	public void ajouterAppointment(Appointment appointment) {
		appointments.save(appointment);

	}
	@Override
	public int addorupdateAppointment(Appointment appointment) {
		appointments.save(appointment);
		return appointment.getId();
	}
	
	@Override
	public void deleteAppointmentbyId(int appointmentId) {
		Appointment a =appointments.findById(appointmentId).orElse(null);
		appointments.delete(a);

	}
	
	@Override
	public List<Appointment> getAllAppointmentsPourToday() {
		return appointments.getAllAppointmentsPourToday();
	}
	
	@Override
	public int getNombreAppointmentJPQL() {
		return appointments.getNombreAppointmentJPQL();
	}
}
