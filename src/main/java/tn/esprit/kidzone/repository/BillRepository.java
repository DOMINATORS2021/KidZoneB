package tn.esprit.kidzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.kidzone.entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
	@Query("select DISTINCT e from Bill e " + "join e.user m " + "where m.id=:userId")
	public List<Bill> getAllBillByUser(@Param("userId") Long userId);

	@Query("SELECT count (*)  from Child c where c.user.id=:user AND c.kindergarten.id=:kindergarten")
	public long getNumberOfChildForUserInKinderJPQL(@Param("user") Long user, @Param("kindergarten") int kindergarten);

	@Query("select DISTINCT e from Bill e " + "join e.kindergarten m " + "where m.id=:kinderId")
	public List<Bill> getAllBillBykinder(@Param("kinderId") int kinderId);

	@Query("select DISTINCT e from Bill e " + "join e.kindergarten k  " + "join e.user u "
			+ "where    k.id=:kinderId     AND u.id =:userId ")
	public List<Bill> getAllBillForUserInKinder(@Param("kinderId") int kinderId, @Param("userId") Long userId);

}
