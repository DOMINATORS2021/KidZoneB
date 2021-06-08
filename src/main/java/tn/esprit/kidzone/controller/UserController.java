package tn.esprit.kidzone.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import tn.esprit.kidzone.entity.RoleName;
import tn.esprit.kidzone.entity.User;
import tn.esprit.kidzone.repository.UserRepository;
import tn.esprit.kidzone.services.EmailSenderService;
import tn.esprit.kidzone.services.IUserService;
import tn.esprit.kidzone.services.UserServiceImpl;


@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/HomePage.jsf")

public class UserController {
	private Long userIdToBeUpdated;
	
	private User currentUser ;

	@Autowired
	 EmailSenderService email;




	 @Autowired
	UserRepository repo;
	 
	 
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public RoleName[] getRoles() {
		return RoleName.values();
		}
	public EmailSenderService getEmail() {
		return email;
	}

	public void setEmail(EmailSenderService email) {
		this.email = email;
	}


	private String name ;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String login; private String password; private User user; private String firstName;
	private String lastName; private boolean actif; private Long id; private RoleName role;
    private Boolean loggedIn;
    @Autowired
    IUserService userService;
	private List<User> users;
	 public UserController() {
	}

	
			public String doLogin() {
				
	        	String navigateTo = "null";
        	User userAtt= userService.findEmail(login);
	        	currentUser=userService.authenticate(login, password);
	        	if(currentUser != null &&  currentUser.isActif() ){
	        	userService.resetFailedAttempts(login);	
	        	if ( currentUser.getRole() == RoleName.ADMINISTRATEUR &&  currentUser.isActif()) {
	        		
	        	navigateTo = "/pages/admin/HomePage.xhtml?faces-redirect=true";
	        	this.name =currentUser.getFirstName();
	        	loggedIn = true;
	        											
	        	}
	        	if(! currentUser.isActif() ){
	        		loggedIn=false;
	        		FacesMessage facesMessage =
	    		        	new FacesMessage("Your account is locked right now ");

	    		        	FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);		
	        	}
	        	else if ( currentUser.getRole() == RoleName.USER &&  currentUser.isActif()) {
	        			navigateTo = "/pages/admin/HomePage.xhtml?faces-redirect=true";
	        	loggedIn = true;
	        	
    		        
	        	}
	        	}
	        	else {
	        		try{
	        		if(repo.getfailedAttempt(login) < UserServiceImpl.MAX_FAILED_ATTEMPTS -1 ){
		        		userService.increaseFailedAttempts(userAtt);
		        		FacesMessage facesMessage =
	        		        	new FacesMessage("Login failed ! Bad credentials");

	        		        	FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
	        		        	repo.setActiftoFalse(login);
	        		        	
	        		
	        			
	          	
	        		}
	        		
	        		
	        		else{
	        			userService.lock(userAtt);
	        			FacesMessage facesMessage =

	        		        	new FacesMessage("Your account has been locked due to 3 failed attempts."
                                    + " It will be unlocked after 24 hours");
	        			            

	        		        	FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
	        		}
	        		}catch(Throwable e){
	        			
	        		}
	        	}
	        	return navigateTo;
	        	}
			

	        	public String doLogout() {
	        	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        	return "/SpringMVC/LoginTemplate.jsf?faces-redirect=true";
	        	}

				public String getLogin() {
					return login;
				}

				public void setLogin(String login) {
					this.login = login;
				}

				public String getPassword() {
					return password;
				}

				public void setPassword(String password) {
					this.password = password;
				}

				
				public Long getId() {
					return id;
				}

				public void setId(Long id) {
					this.id = id;
				}

				public User getUser() {
					return user;
				}

				public void setUser(User user) {
					this.user = user;
				}

				public Boolean getLoggedIn() {
					return loggedIn;
				}

				public void setLoggedIn(Boolean loggedIn) {
					this.loggedIn = loggedIn;
				}
				
				
			    public String getFirstName() {
					return firstName;
				}

				public void setFirstName(String firstName) {
					this.firstName = firstName;
				}

				public String getLastName() {
					return lastName;
				}

				public void setLastName(String lastName) {
					this.lastName = lastName;
				}


				public boolean isActif() {
					return actif;
				}

				public void setActif(boolean actif) {
					this.actif = actif;
				}

				public IUserService getUserService() {
					return userService;
				}

				public void setUserService(IUserService userService) {
					this.userService = userService;
				}


				public UserController(String login, String password, String firstName,
						String lastName, boolean actif) {
		
					this.login = login;
					this.password = password;
					this.firstName = firstName;
					this.lastName = lastName;
					this.actif = actif;
				}
				

				public RoleName getRole() {
					return role;
				}

				public void setRole(RoleName role) {
					this.role = role;
				}

				public UserController(String login, String password, String firstName, String lastName) {
					this.login = login;
					this.password = password;
					this.firstName = firstName;
					this.lastName = lastName;
				}

				public String deleteUser(Long id){
					userService.deleteUser(id);
					return "/pages/admin/ListAllUsers.xhtml?faces-redirect=true";
				}
				
			   
			    public List<User> getAllUsers() {
			    	return userService.getAllUsers();
			    	
			    	
				}

				public void setUsers(List<User> users) {
					this.users = users;
				}

				public String AjouterUser(){
			    userService.addUser(new User(login,firstName,password,lastName,actif));
			    SimpleMailMessage mailMessage = new SimpleMailMessage();
		        mailMessage.setTo(login);
		        mailMessage.setSubject("Complete Registration!");
		        mailMessage.setFrom("mouradjomaa9@gmail.com");
		        mailMessage.setText("Welcome to our plateform , Your account has been activated now ! You can login to your account via this link :"
		        		+ ""
		        		+ ""
		        		+ ""
		        		+ "http://localhost:8081/SpringMVC/HomePage.jsf  "
		                );
		        
		        email.sendEmail(mailMessage);
					return "/SpringMVC/LoginTemplate.xhtml?faces-redirect=true";
			    	
			    }
				
				public String DisplayUser(User u)
				{
					String navigateTo = "/pages/admin/userUpdate.xhtml?faces-redirect=true";
				this.setFirstName(u.getFirstName());
				this.setLastName(u.getLastName());
				this.setActif(u.isActif());
				this.setLogin(u.getLogin());
				this.setRole(u.getRole());
				this.setPassword(u.getPassword());
				this.setUserIdToBeUpdated(u.getId());
				return navigateTo;
				}
//				public String updateUser(Long id){
//					String navigateTo = "/pages/admin/ListAllUsers.xhtml?faces-redirect=true";
//					User u=userService.getUserById(id);
//					u.setId(u.getId());
//					u.setFirstName(u.getFirstName());
//					System.out.println("****************"+firstName);
//					u.setLastName(u.getLastName());
//					System.out.println("****************"+lastName);
//					u.setLogin(u.getLogin());
//					System.out.println("****************"+login);
//					u.setPassword(u.getPassword());
//					userService.addUser(u);
//					return navigateTo;
//				}

				public Long getUserIdToBeUpdated() {
					return userIdToBeUpdated;
				}

				public void setUserIdToBeUpdated(Long userIdToBeUpdated) {
					this.userIdToBeUpdated = userIdToBeUpdated;
				}
				public String updateUser()
				{ 
				String navigateTo = "/pages/admin/ListAllUsers.xhtml?faces-redirect=true";
					userService.addOrUpdateUser(new User(userIdToBeUpdated,login,firstName,password,lastName,actif)); 
				
				
				return navigateTo;
				
				}
				
				public CartesianChartModel createRigTestModel() {
					CartesianChartModel  cartChart = new CartesianChartModel();
			        ChartSeries rigs = new ChartSeries();
			        List<User> rList = userService.getAllUsers();
			        Map<Object, Number> rigMap = new HashMap<>();        
			        for(User o: rList) {
			          
			            rigMap.put(o.getFirstName(), o.getFailedAttempt());
			            
			            rigs.setData(rigMap) ;
			           cartChart.addSeries(rigs);
				       
			        }
			        return cartChart;

				}
    	   
       }				




