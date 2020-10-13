package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Director;
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
	
	//Backend method to query the database to find a movie and delete the pet from the database
			public void deleteMovie(Movie toDelete) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<Movie> typedQuery = em.createQuery("Select m from Movie m where"
						+ " m.id = :selectedId", Movie.class);
				
				
				typedQuery.setParameter("selectedId", toDelete.getId());
				
				
				
				typedQuery.setMaxResults(1);
				
				Movie result = typedQuery.getSingleResult();
				
				em.remove(result);
				em.getTransaction().commit();
				em.close();
			}
	
	public Movie searchForMovieById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Movie found = em.find(Movie.class, id);
		em.close();
		return found;
	}
	
	//Backend method to update the selected item with the values user selected
			public void updateMovie(Movie toEdit) {
					// TODO Auto-generated method stub
					EntityManager em = emfactory.createEntityManager();
					em.getTransaction().begin();
					em.merge(toEdit);
					em.getTransaction().commit();
					em.close();
					
				}
			
}
