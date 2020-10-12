package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	public Director searchForDirectorById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Director found = em.find(Director.class, id);
		em.close();
		return found;
	}
}
