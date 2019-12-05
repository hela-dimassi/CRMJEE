package tn.esprit.jsf.Agent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import service.TacheService;
import model.Agent;
import model.Tache;;

@ManagedBean
@SessionScoped
public class tacheBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	private List<Tache> taches;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@EJB
	TacheService tacheService;
	
	public List<Tache> getTaches()
	{
		taches = tacheService.findallTache();
		return taches;
	}
	public void addTache() 
	{
		Tache tache = new Tache(dateDebut, dateFin, nom);
		if(dateFin.after(dateDebut)) {
		tacheService.AddTache(tache);
		}
		System.out.println("Tache Added");
		if(tache!=null) {
			String navigateTo= "/Tache/AfficheTaches?faces-redirect=true";
			
		}
	}
	public void deleteTache(int idTache)
	{
		tacheService.removeTache(idTache);
	}
	
	
}
