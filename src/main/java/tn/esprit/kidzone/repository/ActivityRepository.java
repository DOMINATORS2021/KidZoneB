package tn.esprit.kidzone.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.kidzone.entity.Activity;
import tn.esprit.kidzone.entity.Category;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

	public Iterable<Activity> findAll(Sort sort);
	public Page<Activity> findAll(Pageable pageable);

	@Query("SELECT count (*) from Activity")
	public int getNombreActivityJPQL();

	@Query("SELECT Name	 from Activity")
	public List<String> getAllActivityNamesJPQL();

	@Query("SELECT DISTINCT activity from Activity activity where activity.Name=:name ")
	public Activity getActivity(@Param("name")String name);

	@Query("select e from Activity e where e.category=:category")
	public List<Activity> getAllActivityByCategorie(@Param("category")Category category);


	@Query("SELECT p FROM Activity p WHERE p.Name LIKE %?1%"
			+ " OR p.category LIKE %?1%")
	public List<Activity> search(String keyword);

	@Query("SELECT p from Activity p ORDER BY category")
	public List<Activity> activitiesall();

	@Query("SELECT e from Activity e where e.DateOfActivity = CURRENT_DATE()")
	public List<Activity> getAllActivityPourToday();

	@Query("SELECT e from Activity e  order by e.DateOfActivity")
	public List<Activity> getAllActivityOrdonneParDate();


}
