package tn.esprit.kidzone.controller;

import java.io.IOException;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.kidzone.entity.Status;
import tn.esprit.kidzone.repository.ReclamationRepository;
import tn.esprit.kidzone.entity.Reclamation;
import tn.esprit.kidzone.services.ReclamationService;

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
		public void AddReclamation(@PathVariable Long idUser, @PathVariable int idKinder,
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
	public void DeleteReclamation(@PathVariable Long idUser, @PathVariable int idRec) {
		recSer.deleteReclamation(idUser, idRec);
	}

	@PutMapping("/updateReclamation/{idUser}/{reclamationId}")
	public void UpdateReclamation(@PathVariable Long idUser, @PathVariable int reclamationId,
								  @RequestParam("description") String description, @RequestParam("photo") MultipartFile photo)
			throws IllegalStateException, IOException {
		recSer.updateReclamation(idUser, reclamationId, description, photo);
	}

	@GetMapping("/getReclamationById/{reclamationId}")
	public Reclamation getReclamationById(@PathVariable int reclamationId) {
		return recSer.getreclamationById(reclamationId);
	}
}
