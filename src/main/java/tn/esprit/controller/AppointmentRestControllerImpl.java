package tn.esprit.controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;

import tn.esprit.entities.Appointment;
import tn.esprit.service.IAppointmentService;

@Scope(value = "session")
@Component(value = "appointmentRest")
@ELBeanName(value = "appointmentRest")
@Join(path = "/", to = "/SpringMVC/appointmentAll.jsf")
public class AppointmentRestControllerImpl {
	@Autowired
	IAppointmentService appointmentss;
 
	@PostMapping("/ajouter_Doctor_rendezVous/{id_user}/{id_doctor}")
	public String ajouter_Doctor_rendezVous(@PathVariable("id_user") int id_user,
			@PathVariable("id_doctor") int id_doctor, @RequestBody Appointment appointment) throws ParseException {

		return appointmentss.ajouter_Doctor_rendezVous(id_user, id_doctor, appointment);
	}

	@DeleteMapping("/delete_appointment/{user_id}/{appointment_id}")
	public String delete_appointment(@PathVariable("user_id") int user_id,
			@PathVariable("appointment_id") int appointment_id) throws ParseException {

		return appointmentss.delete_appointment(user_id, appointment_id);

	}

	@PutMapping("/update_appointment_By_User/{user_id}/{appointment_id}")
	public String update_appointment_By_User(@PathVariable("user_id") int user_id,
			@PathVariable("appointment_id") int appointment_id, @RequestBody Appointment appointment) {

		return appointmentss.update_appointment_By_User(user_id, appointment_id, appointment);
	}


	public List<Appointment> getAllAppointment() {
		return appointmentss.getAllAppointment();
	}

	@PutMapping("/update_appointment_By_Doctor/{doctor_id}/{appointment_id}")
	public String update_appointment_By_Doctor(@PathVariable("doctor_id") int doctor_id,
			@PathVariable int appointment_id, @RequestBody Appointment appointment) {

		return appointmentss.update_appointment_By_Doctor(doctor_id, appointment_id, appointment);
	}

	@PostMapping("/accepte_appointment/{id_doctor}/{appointment_id}")
	public String accepte_appointment(@PathVariable("id_doctor") int id_doctor,
			@PathVariable("appointment_id") int appointment_id) throws ParseException {

		return appointmentss.accepte_appointment(id_doctor, appointment_id);
	}

	@PostMapping("/refut_appointment/{id_doctor}/{appointment_id}")
	public String refut_appointment(@PathVariable("id_doctor") int id_doctor,
			@PathVariable("appointment_id") int appointment_id) throws ParseException {

		return appointmentss.refut_appointment(id_doctor, appointment_id);

	}

	@GetMapping("/getallappointment_status_1/{id_doctor}")
	public List<Appointment> getallappointment_status_1(@PathVariable("id_doctor") int id_doctor)
			throws ParseException {

		return appointmentss.getallappointment_status_1(id_doctor);
	}

	@GetMapping("/findParentAppointment/{user_id}")
	public List<Appointment> findParentAppointment(@PathVariable("user_id") int user_id) {

		return appointmentss.findParentAppointment(user_id);
	}

}
