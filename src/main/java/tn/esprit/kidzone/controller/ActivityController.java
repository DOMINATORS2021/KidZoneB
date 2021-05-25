package tn.esprit.kidzone.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.kidzone.entity.Activity;
import tn.esprit.kidzone.entity.Category;
import tn.esprit.kidzone.services.IActivityService;

import java.util.List;

@Scope(value = "session")
@Component(value = "activityController")
@ELBeanName(value = "activityController")
@Join(path = "/activity", to = "/SpringMVC/activityAll.jsf")
public class ActivityController {

	@Autowired
	IActivityService iactivityservice;
String keyword;

	// http://localhost:8081/SpringMVC/servlet/ajoutactivity/1/1
	// attributes ,values,file
	@PostMapping(value = "/ajoutactivity/{idkinder}/{iduser}")

	public ResponseEntity<String> ajoutActivity(@ModelAttribute Activity activity,
			@PathVariable("idkinder") int kinderId, @PathVariable("iduser") Long userId,
			@RequestParam("file") MultipartFile file) {

		return iactivityservice.ajoutActivity(activity, kinderId, userId, file);

	}

	// http://localhost:8081/SpringMVC/servlet/getAllActivity
	@GetMapping(value = "/getAllActivity")
	@ResponseBody
	public List<Activity> getAllActivity() {
		return iactivityservice.getAllActivity();
	}

	// http://localhost:8081/SpringMVC/servlet/deleteActivityById/1
	@DeleteMapping("/deleteActivityById/{idactivity}")
	@ResponseBody
	public ResponseEntity<String> deleteActivityById(@PathVariable("idactivity") int ActivityId) {
		iactivityservice.deleteActivityById(ActivityId);
		return new ResponseEntity<String>("deleted succesfuly", HttpStatus.OK);
	}

	// http://localhost:8081/SpringMVC/servlet/NbreActivity
	@GetMapping("/NbreActivity")
	@ResponseBody
	public int getNombreActivityJPQL() {
		return iactivityservice.getNombreActivityJPQL();
	}

	// http://localhost:8081/SpringMVC/servlet/Activityname
	@GetMapping("/Activityname")
	@ResponseBody
	public List<String> getAllActivityNamesJPQL() {
		return iactivityservice.getAllActivityNamesJPQL();
	}

	@PutMapping("/updateActivity/{idActivity}")
	@ResponseBody
	public ResponseEntity<String> updateActivity(@ModelAttribute Activity a, @PathVariable("idActivity") int idActivity,
			@RequestParam("file") MultipartFile file) {
		iactivityservice.updateActivity(a, idActivity, file);
		return new ResponseEntity<String>("Activity updated successfully", HttpStatus.OK);

	}

	// http://localhost:8081/SpringMVC/servlet/getActivity/{name}
	@GetMapping("/getActivity/{name}")
	@ResponseBody
	public Activity getActivity(@PathVariable("name") String name) {
		return iactivityservice.getActivity(name);
	}

	// http://localhost:8081/SpringMVC/servlet/retrieveallActivitybycategorie
	@GetMapping(value = "/retrieveallActivitybycategorie/{categorie}")
	@ResponseBody
	public List<Activity> getAllActivityByCategorie(@PathVariable("categorie") Category category) {
		return iactivityservice.getAllActivityByCategorie(category);
	}


	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Activity> search(String keyword) {
		return iactivityservice.search(keyword);
	}

	// http://localhost:8081/SpringMVC/servlet/retrieveallActivitysoftoday
	@GetMapping(value = "/retrieveallActivitysoftoday")
	@ResponseBody
	public List<Activity> getAllActivityPourToday() {
		return iactivityservice.getAllActivityPourToday();
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Activitysordonnebydate
	@GetMapping(value = "/retrieve-all-Activitysordonnebydate")
	@ResponseBody
	public List<Activity> getAllActivityOrdonneParDate() {
		return iactivityservice.getAllActivityOrdonneParDate();
	}
}