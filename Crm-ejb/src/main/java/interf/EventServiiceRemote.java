package interfaces;

import java.text.ParseException;
import java.util.List;

import javax.ejb.Remote;

import model.Admin;
import model.Event;
import model.Salle;
import model.User;

@Remote
public interface EventServiiceRemote {
	public int ajouterEvent(Event event,int selectedSalleId);
	public List<Event> getAllEvents();
	public void deleteEvent(int eventId);
	public void updateEvent(Event e);
	public Event getEventById(int id);
	public Admin getAdminByLoginAndPassword(int login, int password);
	public boolean addPar(int eventId , int userId) throws ParseException ;
	public List<Salle> displaySalles();
	public List<User> getListUSers(int eventId);
}
