package tn.esprit.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.entities.Child;
import tn.esprit.entities.Kindergarten;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Status;
import tn.esprit.entities.User;
import tn.esprit.repository.ReclamationRepository;
import tn.esprit.repository.UserRepository;

@Service
public class ReclamationService implements IReclamationService {

	@Autowired
	ReclamationRepository recRep;

	@Autowired
	UserRepository userRep;

	@Override
	public void addReclamation(int idUser, int idKinder, String description, String type, Status status,
							   MultipartFile file) throws IllegalStateException, IOException {
		Reclamation reclamation = new Reclamation();
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		LocalDate d = LocalDate.now();
		Date dateDuJour = java.sql.Date.valueOf(d);
		reclamation.setDateOfReclam(dateDuJour);
		User user = userRep.findById(idUser).get();
		List<Child> liste = user.getList_child();
		for (Child child : liste) {
			if (child.getKindergarten().getId() == idKinder) {
				Kindergarten K = child.getKindergarten();
				reclamation.setDateOfReclam(dateDuJour);
				reclamation.setDescription(description);
				reclamation.setType(type);
				reclamation.setStatus(status);
				reclamation.setPhoto(filename);
				reclamation.setKindergarten(K);
				reclamation.setUser(user);
				recRep.save(reclamation);
			} else {
				System.out.println("ERROR");
			}
		}
	}

	@Override
	public void updateReclamation(int idUser, int reclamationId, String description, MultipartFile file)
			throws IllegalStateException, IOException {
		User user = userRep.findById(idUser).get();
		List<Reclamation> list = user.getList_reclams();
		for (Reclamation rec : list) {
			if (rec.getId() == reclamationId) {
				if (rec.getStatus().equals(Status.New)) {
					rec.setDescription(description);
					String filename = file.getOriginalFilename();
					rec.setPhoto(filename);
					recRep.save(rec);
				} else
					System.out.println("This Reclamation Was Treated");
			} else
				System.out.println("Sorry, This Reclamation Does Not Belong To You...");
		}
	}

	@Override
	public void deleteReclamation(int idUser, int idRec) {
		User user = userRep.findById(idUser).get();
		List<Reclamation> list = user.getList_reclams();
		for (Reclamation rec : list) {
			if (rec.getId() == idRec)
				recRep.delete(rec);
			else
				System.out.println("Sorry, This Reclamation Does Not Belong To You...");
		}
	}

	@Override
	public Reclamation getreclamationById(int reclamationId) {
		Reclamation rec = recRep.findById(reclamationId).orElse(null);
		return rec;
	}

	@Override
	public List<Reclamation> listReclamations() {
		return (List<Reclamation>) recRep.findAll();
	}

	@Override
	public User getUserById(int userId) {
		User u = userRep.findById(userId).orElse(null);
		return u;
	}

}
