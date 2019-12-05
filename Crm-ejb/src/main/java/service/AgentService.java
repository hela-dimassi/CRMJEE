package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Agent;
import model.PointOfProspection;
import model.PointOfSale;
import model.Tache;
@Stateless
@LocalBean
public class AgentService implements AgentServiceRemote {

	@PersistenceContext
	EntityManager em;
	@Override
	public int addAgent(Agent agent) {
		// TODO Auto-generated method stub
		em.persist(agent);
		return agent.getId();
	}

	@Override
	public void removeAgent(int id) {
		em.remove(em.find(Agent.class, id));
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAgent(Agent agent) {
		// TODO Auto-generated method stub
		Agent agen = em.find(Agent.class, agent.getId());
		agen.setNom(agent.getNom());
		agen.setPrenom(agen.getPrenom());
		agen.setEmail(agen.getEmail());
		agen.setStatus(agen.getStatus());
		agen.setNumTel(agen.getNumTel());
		
	}

	@Override
	public Agent findAgentById(int id) {
		// TODO Auto-generated method stub
		return em.find(Agent.class, id);
	}

	@Override
	public List<Agent> findallAgents() {
		// TODO Auto-generated method stub
		List<Agent> agents = em.createQuery("select a from Agent a", Agent.class).getResultList();
		return agents;
	}
	
	@Override
	public void AffecterTacheAAgent(Object object, int idAgent) {
		Agent agent = em.find(Agent.class, idAgent);
		
		if(object instanceof Tache) {
	
			agent.setStatus(1);
			agent.setTache((Tache)object);
		}	
		 else if(object instanceof PointOfProspection) {
			
			agent.setStatus(2);
			agent.setPointOfProspection((PointOfProspection)object);
			
		} else if (object instanceof PointOfSale){		
			
			agent.setStatus(3);
			agent.setPointOfSale((PointOfSale)object);
		}
		
	}

	@Override
	public List<Agent> findAgentsByStatus() {
		// TODO Auto-generated method stub
		TypedQuery<Agent> query = em.createQuery("SELECT a from Agent a where a.status=1", Agent.class);
		List<Agent> results = query.getResultList();
		return results; 
	}

}
