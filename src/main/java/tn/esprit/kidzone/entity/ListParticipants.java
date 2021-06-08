package tn.esprit.kidzone.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class ListParticipants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    @EmbeddedId
	    private ListParticipantsPK listparticipantsPK;
	    @JsonIgnore
		@ManyToOne
	    @JoinColumn(name = "idEvent", referencedColumnName = "id", insertable=false, updatable=false)
		private Event event;
		@JsonIgnore
		@ManyToOne
	    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
		private User user;
		

		private String Etat;
		
	
		public String getEtat() {
			return Etat;
		}


		public void setEtat(String etat) {
			Etat = etat;
		}


		


		public ListParticipants() {
			super();
		}

		
	



	

		public ListParticipantsPK getListparticipantsPK() {
			return listparticipantsPK;
		}

		public void setListparticipantsPK(ListParticipantsPK listparticipantsPK) {
			this.listparticipantsPK = listparticipantsPK;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	


		public ListParticipants(ListParticipantsPK listparticipantsPK, Event event, User user) {
			super();
			this.listparticipantsPK = listparticipantsPK;
			this.event = event;
			this.user = user;
		}


		public ListParticipants(Event event, User user) {
			super();
			this.event = event;
			this.user = user;
		}


		


		}


		

		

	


