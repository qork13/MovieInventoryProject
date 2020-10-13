package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Director;
import model.Movie;

/**
 * Servlet implementation class editMovieServlet
 */
@WebServlet("/editMovieServlet")
public class editMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieHelper mh = new MovieHelper();
		DirectorHelper dh = new DirectorHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		LocalDate ld;
		ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
		
		String directorToEdit = request.getParameter("directorToEdit");
		int directorId = Integer.parseInt(directorToEdit);
		Director director = dh.searchForDirectorById(directorId);
		
		Movie movieToUpdate = mh.searchForMovieById(tempId);
		movieToUpdate.setTitle(title);
		movieToUpdate.setDateReleased(ld);
		movieToUpdate.setDirector(director);
		mh.updateMovie(movieToUpdate);
		dh.updateDirector(director);
		
		getServletContext().getRequestDispatcher("/viewAllMoviesServlet").forward(request, response);
		
	}

}
