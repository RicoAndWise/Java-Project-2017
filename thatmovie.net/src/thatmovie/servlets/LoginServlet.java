package thatmovie.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import thatmovie.Util.Connection;
import thatmovie.beans.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String uName = request.getParameter("us");
		String pWord = request.getParameter("pw");

		Connection conn = new Connection();
		User user = conn.checkLogin(uName, pWord);

		if (user != null) {

			HttpSession userSession = request.getSession(true);
			userSession.setAttribute("user", user);

			// List userList=new ArrayList();
			request.setAttribute("listUser", conn.getUserList(user.getUserName()));

			request.setAttribute("moviesList", conn.getMoviesById(user.getUserID()));

			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("True");

		}

		else {

			response.getWriter().write("ERROR");

		}

		 //request.getRequestDispatcher("/Movies.jsp").forward(request,
		// response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String uName = request.getParameter("us");
		String pWord = request.getParameter("pw");

		Connection conn = new Connection();
		User user = conn.checkLogin(uName, pWord);

		if (user != null) {

			HttpSession userSession = request.getSession(true);
			userSession.setAttribute("user", user);

			// List userList=new ArrayList();
			request.setAttribute("listUser", conn.getUserList(user.getUserName()));

			request.setAttribute("moviesList", conn.getMoviesById(user.getUserID()));

			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("True");

			
			
			
			PropertyConfigurator.configure("log4j.properties");
			//logger.debug("WTF?");
			//logger.warn("un warning");
			logger.info("Logueando la clase");
		
		}

		else {

			response.getWriter().write("ERROR");

		}

		// request.getRequestDispatcher("/Movies.jsp").forward(request,
		// response);

	}

}
