package thatmovie.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thatmovie.Util.Connection;
import thatmovie.beans.Movie;
import thatmovie.beans.User;

/**
 * Servlet implementation class MovieViewServlet
 */
@WebServlet("/MovieViewServlet")
public class MovieViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		System.out.println("we are going through the GET Method");

		Connection conn = new Connection();

		// Session Method

		HttpSession userSession = (HttpSession) request.getSession();

		User user = (User) userSession.getAttribute("user");

		System.out.println(user.getUserName() + " " + user.getUserID() + "This the information coming from the session ");

		// Form method
        
		if(user==null||user.equals("")){
			
		 
		request.getRequestDispatcher("/LogoutServlet").forward(request, response);
			
		}
		
		else{
		String uName = request.getParameter("uName");
		String pWord = request.getParameter("pWord");

		User userForm = conn.checkLogin(uName, pWord);

		request.setAttribute("listUser", conn.getUserList(user.getUserName()));

		request.setAttribute("moviesList", conn.getMoviesById(user.getUserID()));

		request.getRequestDispatcher("/Movies.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		System.out.println("we are going through the POST Method");

		// String movieName=request.getParameter("searchtxt");
		String movieReference = request.getParameter("searchtxt");
		String action = request.getParameter("action");
		System.out.println(action);

		if (action.equalsIgnoreCase("search")) {

			// System.out.println(movieName);
			System.out.println(movieReference + " and this is what we get from the form request");

			Connection conn = new Connection();
			List<Movie> movielistByName = conn.getMoviesByName(movieReference);

			// response.setContentType("text/html");
			// PrintWriter out = response.getWriter();
			// response.getWriter().write("successful");

			HttpSession userSession = (HttpSession) request.getSession();

			User user = (User) userSession.getAttribute("user");

			System.out.println(user.getUserName() + " " + user.getUserID()
					+ "This the information coming from the session in post method ");

			// Form method

			String uName = request.getParameter("uName");
			String pWord = request.getParameter("pWord");

			User userForm = conn.checkLogin(uName, pWord);

			request.setAttribute("listUser", conn.getUserList(user.getUserName()));

			request.setAttribute("moviesList", conn.getMoviesById(user.getUserID()));

			request.setAttribute("moviesListsearch", movielistByName);

			for (int indice = 0; indice < movielistByName.size(); indice++) {
				System.out.println(movielistByName.get(indice));
				System.out.println("Aqui debio de estar el contenido");
				// out.print(movielistByName.get(indice));
				// out.print("Aqui debio de estar el contenido");

			}

			// request.setAttribute("moviesListsearch", movielistByName);

			/*
			 * response.setContentType("text/html;charset=UTF-8");
			 * response.getWriter().write("True");
			 * 
			 */

			// request.getRequestDispatcher("/Movies.jsp").forward(request,
			// response);

		} else {

			System.out.println("Something stupid happened");

		}

		request.getRequestDispatcher("/SearchResult.jsp").forward(request, response);

	}

}
