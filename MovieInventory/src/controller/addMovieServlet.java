package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class addMovieServlet
 */
@WebServlet("/addMovieServlet")
public class addMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieHelper mh = new MovieHelper();
		DirectorHelper dh = new DirectorHelper();
		
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		LocalDate ld;
		ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
		
		String directorToAdd = request.getParameter("directorToAdd");
		int directorId = Integer.parseInt(directorToAdd);
		
		Movie movieToAdd = new Movie(title, ld, dh.searchForDirectorById(directorId));
		mh.insertMovie(movieToAdd);
		getServletContext().getRequestDispatcher("/viewAllMoviesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
