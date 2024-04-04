package thatmovie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thatmovie.Util.Connection;
import thatmovie.beans.User;

/**
 * Servlet implementation class MoviesServlet
 */
@WebServlet("/MoviesServlet")
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	
	    
	     String movieName=request.getParameter("txtMovieName");
	     Integer movieYear=Integer.parseInt(request.getParameter("txtMovieYear"));
	     Integer userID= Integer.parseInt(request.getParameter("userID"));
	     
	     
	     Connection conn=new Connection();
	     int movieID=conn.saveMovie(movieName, movieYear,userID); 
	      
	     // System.out.println("the movie with ID: " +conn.saveMovie(movieName, movieYear,userID)+" has been successfully stored.");
	
          

		 HttpSession userSession= (HttpSession) request.getSession();
		 
		 User user= (User) userSession.getAttribute("user");
	
		 System.out.println(user.getUserName()+" " + user.getUserID()+ "This the information coming from the session ");
	     
	     
		 PrintWriter out;
		 out = response.getWriter();
		 
		 response.setContentType("text/html");
		 
		 out.println("<html>");
		
		 out.println("<body style= 'background: url('/thatmovieContent/sparta.jpg') no-repeat center fixed;>'");
		 
		 out.println("<p> the movie with ID: " +movieID+ " has been successfully stored. </p>");

		 out.println("<br/> <br/>");
 
		 out.println("<a href='MovieViewServlet'> Click here to go back to the homescreen </a> "  );
		 
		 out.println("</html>");
		 
		 out.println("</body>");
     	 	
	}

}
