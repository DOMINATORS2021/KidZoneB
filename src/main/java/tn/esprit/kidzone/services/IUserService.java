package tn.esprit.kidzone.services;
import java.util.List;

import tn.esprit.kidzone.entity.*;


public interface IUserService {
	public List<User> getAllUsers();
	void addUser(User u);
	void deleteUser(Long id);
	User updateUser(User u);
	void resetFailedAttempts(String login);
	void increaseFailedAttempts(User userAtt);
	void lock(User userAtt);
	public boolean unlockWhenTimeExpired(User userToUnlock);
	User findEmail(String login);
	public User authenticate(String login, String password);
	public User getUserById(Long id);
	public String addOrUpdateUser(User user);


}
