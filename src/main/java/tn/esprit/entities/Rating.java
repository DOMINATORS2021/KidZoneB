package tn.esprit.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		int ratId;
		
		float ratingValue;
		
		@ManyToOne(cascade=CascadeType.PERSIST)
		User userRat;
		
		@ManyToOne
		Event eventRat;
		

		public int getRatId() {
			return ratId;
		}

		public void setRatId(int ratId) {
			this.ratId = ratId;
		}

		public float getRatingValue() {
			return ratingValue;
		}

		public void setRatingValue(float ratingValue) {
			this.ratingValue = ratingValue;
		}

		public User getUserRat() {
			return userRat;
		}

		public void setUserRat(User userRat) {
			this.userRat = userRat;
		}

		public Event getEventRat() {
			return eventRat;
		}

		public void setEventRat(Event eventRat) {
			this.eventRat = eventRat;
		}

		

		
		
		
		
}

