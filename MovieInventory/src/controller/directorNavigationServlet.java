package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Director;

/**
 * Servlet implementation class directorNavigationServlet
 */
@WebServlet("/directorNavigationServlet")
public class directorNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public directorNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DirectorHelper dh = new DirectorHelper();
		String act = request.getParameter("doThisToDirector");
		String path = "/viewAllDirectorsServlet";
		
		//This if/else statement will take the action that comes in via the act variable and then search for the director by ID
		//and either delete from the mysql/AWS database, take the user to edit-director.jsp to update the record , or go to the viewAllDirectors.jsp
		//to add a new record
		
		if(act.equals("delete")) {
			
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Director deleteDirector = dh.searchForDirectorById(tempId);
			dh.deleteDirector(deleteDirector);
			} catch (NumberFormatException e) {
				System.out.println("Please select a Director");
			}
			
		}
			
		else if(act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Director directorToEdit = dh.searchForDirectorById(tempId);
			request.setAttribute("directorToEdit", directorToEdit);
			path = "/edit-director.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Please select a director");
			}
		}
		
		else if
		(act.equals("add")) {
		path = "/director-list.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
		}
	}


