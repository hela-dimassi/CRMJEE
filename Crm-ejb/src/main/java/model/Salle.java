package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Salles database table.
 * 
 */
@Entity
@Table(name="Salles")
@NamedQuery(name="Salle.findAll", query="SELECT s FROM Salle s")
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SalleId")
	private int salleId;

	@Column(name="ImageUrl")
	private String imageUrl;

	@Column(name="Localisation")
	private String localisation;

	@Column(name="Name")
	private String name;

	@Column(name="Quapacite")
	private int quapacite;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="salle")
	private List<Event> events;

	public Salle() {
	}

	public int getSalleId() {
		return this.salleId;
	}

	public void setSalleId(int salleId) {
		this.salleId = salleId;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocalisation() {
		return this.localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuapacite() {
		return this.quapacite;
	}

	public void setQuapacite(int quapacite) {
		this.quapacite = quapacite;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setSalle(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setSalle(null);

		return event;
	}

}