import java.time.LocalDate;
import java.util.List;

import controller.DirectorHelper;
import controller.MovieHelper;
import model.Director;
import model.Movie;

public class Tester {

	public static void main(String[] args) {
		Director director = new Director("Steven Spielberg");
		DirectorHelper dh = new DirectorHelper();
		//dh.insertDirector(director);
		
		List<Director> allDirectors = dh.showAllDirectors();
		for(Director d : allDirectors) {
			System.out.println(d.toString());
		}
		
		MovieHelper mh = new MovieHelper();
		Movie movie = new Movie("Avatar",LocalDate.of(2009, 12, 18) ,director );
		mh.insertMovie(movie);
		List<Movie> allMovies = mh.showAllMovies();
		for(Movie m: allMovies) {
			System.out.println(m.toString());
		}
	}

}
