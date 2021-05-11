package tn.esprit.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.entities.Status;
import tn.esprit.entities.Reclamation;
import tn.esprit.services.ReclamationService;

@RestController
public class ReclamationController {

	@Autowired
	ReclamationService recSer;

	@RequestMapping("/addReclamation/{idUser}/{idKinder}")
	public void AddReclamation(@PathVariable int idUser, @PathVariable int idKinder,
							   @RequestParam("description") String description, @RequestParam("type") String type,
							   @RequestParam("status") Status status, @RequestParam("photo") MultipartFile file)
			throws IllegalStateException, IOException {
		recSer.addReclamation(idUser, idKinder, description, type, status, file);
	}

	@GetMapping("/getAllReclamations")
	public List<Reclamation> listReclamations() {
		return recSer.listReclamations();
	}

	@DeleteMapping("/deleteReclamation/{idUser}/{idRec}")
	public void DeleteReclamation(@PathVariable int idUser, @PathVariable int idRec) {
		recSer.deleteReclamation(idUser, idRec);
	}

	@PutMapping("/updateReclamation/{idUser}/{reclamationId}")
	public void UpdateReclamation(@PathVariable int idUser, @PathVariable int reclamationId,
								  @RequestParam("description") String description, @RequestParam("photo") MultipartFile photo)
			throws IllegalStateException, IOException {
		recSer.updateReclamation(idUser, reclamationId, description, photo);
	}

	@GetMapping("/getReclamationById/{reclamationId}")
	public Reclamation getReclamationById(@PathVariable int reclamationId) {
		return recSer.getreclamationById(reclamationId);
	}
}
