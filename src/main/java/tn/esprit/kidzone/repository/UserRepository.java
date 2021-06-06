package tn.esprit.kidzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.kidzone.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User getUserByLoginAndPassword(String login, String password);
	public User save(User u);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.failedAttempt=:failedAttempt WHERE u.login=:login")
    void updateFailedAttempts( @Param("failedAttempt") int failAttempts, @Param("login") String login);

	@Query(value ="SELECT u.failedAttempt FROM User u where u.login =:login")
	public int getfailedAttempt(@Param("login") String login);
	
	@Query("select u from User u where u.login=:login")
	User findEmail(@Param("login") String login);
	
	@Modifying
	@Transactional
	@Query("Update User u set u.actif= false where u.login=:login")
	void setActiftoFalse(@Param("login") String login);
	
//	@Query(value="SELECT * FROM users WHERE "+"MATCH (first_name,last_name,login)"+"AGAINST(?1)",nativeQuery=true)
//	public List<User> search(String keyword);
}
