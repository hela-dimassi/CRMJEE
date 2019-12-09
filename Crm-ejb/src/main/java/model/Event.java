package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EventId")
	private int eventId;

	@Column(name="DateBegin")
	private String dateBegin;

	@Column(name="DateEnd")
	private String dateEnd;

	@Column(name="ImageUrl")
	private String imageUrl;

	@Column(name="Name")
	private String name;

	private int nbrPlaces;

	private int nbrPlaceVendu;
	

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="AdminId")
	private Admin admin;

	//bi-directional many-to-one association to Salle
	@ManyToOne
	@JoinColumn(name="SalleId")
	private Salle salle;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="events")
	
	private List<User> users;

	public Event() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbrPlaces() {
		return this.nbrPlaces;
	}

	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}

	public int getNbrPlaceVendu() {
		return this.nbrPlaceVendu;
	}

	public void setNbrPlaceVendu(int nbrPlaceVendu) {
		this.nbrPlaceVendu = nbrPlaceVendu;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Salle getSalle() {
		return this.salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	

	

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Event(String dateBegin, String dateEnd, String imageUrl, String name, int nbrPlaces , int adminId) {
		super();
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.imageUrl = imageUrl;
		this.name = name;
		this.nbrPlaces = nbrPlaces;
		this.admin = admin;
	}
	
	public Event(String dateBegin, String dateEnd, String imageUrl, String name, int nbrPlaces , int nbrPlaceVendu , int eventId ) {
		super();
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.imageUrl = imageUrl;
		this.name = name;
		this.nbrPlaces = nbrPlaces;
		this.eventId = eventId;
	}

	public Event(int eventId, String dateBegin, String dateEnd, String imageUrl, String name, int nbrPlaces) {
		super();
		this.eventId = eventId;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.imageUrl = imageUrl;
		this.name = name;
		this.nbrPlaces = nbrPlaces;
	}
	public Event(String dateBegin, String dateEnd, String imageUrl, String name, int nbrPlaces) {
		super();
		
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.imageUrl = imageUrl;
		this.name = name;
		this.nbrPlaces = nbrPlaces;
		
	}
	
	
	public Event(String dateBegin, String dateEnd, String imageUrl, String name, int nbrPlaces , Salle salle) {
		super();
		
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.imageUrl = imageUrl;
		this.name = name;
		this.nbrPlaces = nbrPlaces;
		this.salle = salle;
		
	}
	

	public Event(int eventId) {
		super();
	
		this.eventId = eventId;
	}



	
	
	

}