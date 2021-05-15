package tn.esprit.kidzone.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.kidzone.entity.Reclamation;
import tn.esprit.kidzone.entity.Status;
import tn.esprit.kidzone.entity.User;

public interface IReclamationService {
	public void addReclamation(Long idUser, int idKinder, String description, String type, Status status,
							   MultipartFile file) throws IllegalStateException, IOException;

	public void updateReclamation(Long idUser, int reclamationId, String description, MultipartFile file)
			throws IllegalStateException, IOException;

	public void deleteReclamation(Long idUser, int idRec);

	public List<Reclamation> listReclamations();

	public User getUserById(Long userId);

	public Reclamation getreclamationById(int reclamationId);

}
