package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Director;

public class DirectorHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieInventory");

	public void insertDirector(Director d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Director> showAllDirectors(){
		EntityManager em = emfactory.createEntityManager();
		List<Director> allDirectors = em.createQuery("SELECT d FROM Director d").getResultList();
		return allDirectors;
	}
	
	//Backend method to query the database to find a director and delete the pet from the database
		public void deleteDirector(Director toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Director> typedQuery = em.createQuery("Select d from Director d where"
					+ " d.name = :selectedName", Director.class);
			
			
			typedQuery.setParameter("selectedName", toDelete.getName());
			
			
			typedQuery.setMaxResults(1);
			
			Director result = typedQuery.getSingleResult();
			
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}


	
	public Director searchForDirectorById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Director found = em.find(Director.class, id);
		em.close();
		return found;
	}
	
	//Backend method to update the selected item with the values user selected
		public void updateDirector(Director toEdit) {
				// TODO Auto-generated method stub
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				em.merge(toEdit);
				em.getTransaction().commit();
				em.close();
				
			}
}
