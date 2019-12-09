package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Admins database table.
 * 
 */
@Entity
@Table(name="Admins")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AdminId")
	private int adminId;

	@Column(name="Login")
	private int login;

	@Column(name="Password")
	private int password;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="admin")
	private List<Event> events;

	public Admin() {
	}

	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getLogin() {
		return this.login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getPassword() {
		return this.password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setAdmin(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setAdmin(null);

		return event;
	}

}