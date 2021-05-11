package tn.esprit.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.entities.Activity;
import tn.esprit.entities.Category;

public interface IActivityService {

	public ResponseEntity<String>  ajoutActivity(Activity activity, int kinderId,int userId,MultipartFile file);

	public List<Activity> getAllActivity();

	public void deleteActivityById(int ActivityId);

	public int getNombreActivityJPQL();

	public List<String> getAllActivityNamesJPQL();

	public void updateActivity(Activity a, int idActivity,MultipartFile file);

	public Activity getActivity(String name);


	public List<Activity>getAllActivityByCategorie(Category category);

	public List<Activity> search(String keyword);

	public List<Activity> activities(); //JPQL :ORDERBY category

	public List<Activity> getAllActivityPourToday();

	public List<Activity> getAllActivityOrdonneParDate();

}
