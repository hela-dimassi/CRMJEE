package tn.esprit.jsf.Agent;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Agent;
import model.Tache;
import service.AgentService;

@ManagedBean
@SessionScoped
public class agentBean implements Serializable {
	
	private String nom;
	private String prenom;
	private String email;
	private int numTel;
	private int status;
	private List<Agent> agents;
	private List<Agent> agentStatus;
	private int agentIdToBeUpdate;
	private int idMission;
	@EJB
	AgentService agentService;
	
	public void addAgent() 
	{
		Agent agent = new Agent();
		agent.setNom(nom);
		agent.setPrenom(prenom);
		agent.setEmail(email);
		agent.setNumTel(numTel);
		agentService.addAgent(agent);
		System.out.println("Agent Added");
		if(agent!=null) {
			String navigateTo= "/Agent/afficheAgents?faces-redirect=true";
			}
	}
	public void deleteAgent(int idAgent)
	{
		agentService.removeAgent(idAgent);
	}
	public void modifier(Agent agent) {		
		this.setNom(agent.getNom());
		this.setPrenom(agent.getPrenom());
		this.setEmail(agent.getEmail());
		this.setNumTel(agent.getNumTel());
		this.setAgentIdToBeUpdate(agent.getId());
	
	}	
	public void mettreAjourAgent() 
	{
		agentService.updateAgent(new Agent(agentIdToBeUpdate,email, nom, numTel, prenom));
	}
	public void AffecterTacheAAgent(Tache tache, int idAgent) {
		agentService.AffecterTacheAAgent(tache, idAgent);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public int getAgentIdToBeUpdate() {
		return agentIdToBeUpdate;
	}
	public void setAgentIdToBeUpdate(int agentIdToBeUpdate) {
		this.agentIdToBeUpdate = agentIdToBeUpdate;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	public List<Agent> getAgents(){
		agents = agentService.findallAgents();
		return agents;
	}
	

	public List<Agent> getAgentsByStatus(){
		agentStatus = agentService.findAgentsByStatus();
		return agentStatus;
	}
	public int getIdMission() {
		return idMission;
	}
	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}
	


}
