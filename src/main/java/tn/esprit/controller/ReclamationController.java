package tn.esprit.controller;

import java.io.IOException;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.entities.Status;
import tn.esprit.repository.ReclamationRepository;
import tn.esprit.entities.Reclamation;
import tn.esprit.services.ReclamationService;

@Scope(value = "session")
@Component(value = "reclamationController")
@ELBeanName(value = "reclamationController")
@Join(path = "/reclamation", to = "/SpringMVC/reclamationAll.jsf")
public class ReclamationController {

	@Autowired
	ReclamationService recSer;

	  @Autowired
	    private ReclamationRepository ReclamationRepository;
	    
		@RequestMapping("/addReclamation/{idUser}/{idKinder}")
		public void AddReclamation(@PathVariable int idUser, @PathVariable int idKinder,
								   @RequestParam("description") String description, @RequestParam("type") String type,
								   @RequestParam("status") Status status, @RequestParam("photo") MultipartFile file)
				throws IllegalStateException, IOException {
			recSer.addReclamation(idUser, idKinder, description, type, status, file);
		}
	
    private Reclamation reclamation = new Reclamation();

    public Reclamation getProduct() {
        return reclamation;
    }
	 public String save() {
		 ReclamationRepository.save(reclamation);
	        reclamation = new Reclamation();
	        return "/reclamationAll.xhtml?faces-redirect=true";
	    }
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
