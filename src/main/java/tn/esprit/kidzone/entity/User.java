package tn.esprit.kidzone.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true, length = 45)
	private String login;
	@Column (nullable = false, length = 20)
	private String firstName;
	@Column (nullable = false, length = 64)
	private String password;
	@Column (nullable = false, length = 20)
	private String lastName;
	@Column (nullable = false)
	private boolean actif;
	@Column (nullable = false)
	@Enumerated (EnumType.STRING) 
	private RoleName role;
	@Column(name = "failed_attempt")
	private int failedAttempt;

	@Column(name = "lock_time")
	private Date lockTime;
	@Column(name = "account_non_locked")
	private boolean accountNonLocked;
	
	
	
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public int getFailedAttempt() {
		return failedAttempt;
	}
	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RoleName getRole() {
		return role;
	}
	public void setRole(RoleName role) {
		this.role = role;
	}

	
	
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public User(Long id, String login, String firstName, String password, String lastName, boolean actif, RoleName role,
			int failedAttempt, Date lockTime, boolean accountNonLocked) {
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.password = password;
		this.lastName = lastName;
		this.actif = actif;
		this.role = role;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.accountNonLocked = accountNonLocked;
	}
	public User() {
	}
	public User (String name){
		this.firstName=name;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + login + ", firstName=" + firstName + ", password=" + password
				+ ", lastName=" + lastName + ", enabled=" + actif + ", role=" + role +  "]";
	}
	public User(String login, String firstName, String password, String lastName, boolean actif) {
		super();
		this.login = login;
		this.firstName = firstName;
		this.password = password;
		this.lastName = lastName;
		this.actif=true;
	}

	public User(Long id, String login, String firstName, String password, String lastName, boolean actif) {
		super();
		this.id=id;
		this.login = login;
		this.firstName = firstName;
		this.password = password;
		this.lastName = lastName;
		this.actif=true;
		
	}
	@OneToMany(mappedBy="user")
	private List<Child> list_child;

	public List<Child> getList_child() {
		return list_child;
	}
	
	@OneToMany(mappedBy="user")
	private List<Reclamation> list_reclams;

	public List<Reclamation> getList_reclams() {
		return list_reclams;
	}
	
	@OneToMany(mappedBy="user")
	private List<ListParticipants> list_participants;
	
	public List<ListParticipants> getList_participants() {
		return list_participants;
	}



	public void setList_participants(List<ListParticipants> list_participants) {
		this.list_participants = list_participants;
	}
}