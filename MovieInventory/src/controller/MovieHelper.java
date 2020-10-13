package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Movie;

public class MovieHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieInventory");
	
	public void insertMovie(Movie m) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Movie> showAllMovies(){
		EntityManager em = emfactory.createEntityManager();
		List<Movie> allMovies = em.createQuery("SELECT m FROM Movie m").getResultList();
		return allMovies;
	}
}
