package tn.esprit.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Status;
import tn.esprit.entities.User;

public interface IReclamationService {
	public void addReclamation(int idUser, int idKinder, String description, String type, Status status,
							   MultipartFile file) throws IllegalStateException, IOException;

	public void updateReclamation(int idUser, int reclamationId, String description, MultipartFile file)
			throws IllegalStateException, IOException;

	public void deleteReclamation(int idUser, int idRec);

	public List<Reclamation> listReclamations();

	public User getUserById(int userId);

	public Reclamation getreclamationById(int reclamationId);

}
