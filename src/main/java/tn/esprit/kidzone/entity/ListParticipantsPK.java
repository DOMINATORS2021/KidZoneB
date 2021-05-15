package tn.esprit.kidzone.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Embeddable
public class ListParticipantsPK   implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long idUser;
	
	private int idEvent;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateParticipation;

	

	public Date getDateParticipation() {
		return DateParticipation;
	}

	public void setDateParticipation(Date dateParticipation) {
		DateParticipation = dateParticipation;
	}

	public ListParticipantsPK() {
		super();
	}

	public ListParticipantsPK(Long idUser, int idEvent) {
		super();
		this.idUser = idUser;
		this.idEvent = idEvent;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListParticipantsPK other = (ListParticipantsPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}



	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	@Override
	public String toString() {
		return "ListParticipantsPK [idUser=" + idUser + ", idEvent=" + idEvent + "]";
	}

	

	


	

	
	

	
}
