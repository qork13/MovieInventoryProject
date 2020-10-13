package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Director;
import model.Movie;

/**
 * Servlet implementation class movieNavigationServlet
 */
@WebServlet("/movieNavigationServlet")
public class movieNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movieNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieHelper mh = new MovieHelper();
		String act = request.getParameter("doThisToMovie");
		String path = "/viewAllMoviesServlet";
		
		//This if/else statement will take the action that comes in via the act variable and then search for the director by ID
		//and either delete from the mysql/AWS database, take the user to edit-director.jsp to update the record , or go to the viewAllDirectors.jsp
		//to add a new record
		
		if(act.equals("delete")) {
			
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Movie deleteMovie = mh.searchForMovieById(tempId);
			mh.deleteMovie(deleteMovie);
			} catch (NumberFormatException e) {
				System.out.println("Please select a movie");
			}
			
		}
			
		else if(act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Movie movieToEdit = mh.searchForMovieById(tempId);
			request.setAttribute("movieToEdit", movieToEdit);
			request.setAttribute("month", movieToEdit.getDateReleased().getMonthValue());
			request.setAttribute("date", movieToEdit.getDateReleased().getDayOfMonth());
			request.setAttribute("year", movieToEdit.getDateReleased().getYear());
			DirectorHelper dh = new DirectorHelper();
			request.setAttribute("directorsToEdit", dh.showAllDirectors());
			path = "/edit-movie.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Please select a movie");
			}
		}
		
		else if
		(act.equals("add")) {
		path = "/movie-list.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
		}
	}


