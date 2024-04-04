package thatmovie.Util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import thatmovie.beans.Movie;
import thatmovie.beans.User;



public class Connection {

	
	
	private Session session;
	private Transaction tx;
	
	public void iniciaOperacion(){
	 session=HibernateUtil.getSessionFactory().openSession();
	 tx=session.beginTransaction();
	
	}
	
	
	
	/*
	public Movie saveMovie(String movieName, Integer movieYear, User userKey){
	
	 
		iniciaOperacion();
		
		  User user=(User)session.get(User.class, Integer.parseInt(userID));
	      Movie movie=new Movie(movieName, movieYear, userKey);
	      movie.setUserKey(user);
	      session.save(movie);  
		  tx.commit(); 
	
		return null;
		
	}
	
	*/
	
	public User checkLogin(String uName, String pWord){
		
	 User user = null;	
	
	 iniciaOperacion();	
	 
	// if(uName !=null && pWord !=null){
	 
	 String queryString = "from User where userName=:uName";
     Query query = session.createQuery(queryString);
     query.setString("uName", uName);
   	 user = (User) query.uniqueResult();
		
   	 if (user!=null&&user.getUserName().equals(uName)&&user.getPassWord().equals(pWord))
   	 
   	 {
   		 
   		System.out.println("La cuenta ha sido autenticada exitosamente"); 
	 
   	 }
	// }
     
	
	else{
		 
		 
		 System.out.println("something is wrong with your credentials");
		 user=null;
		 
	    }
	 
	 
	 
     
		return user;
		
		
	}
	
	
	 public List<User> getUserList(String uName){
		 
		 List<User>usersList=new ArrayList<User>();
		 String queryString = "from User where userName=:uName";
	     Query query = session.createQuery(queryString);
	     query.setString("uName", uName);
	     usersList = (List<User>) query.list();
		 
		 
		 
		 return usersList;
		 
	 }



	public Integer saveMovie(String movieName, Integer movieYear, Integer userID) {
		
		
	  iniciaOperacion();
		
	  User user=(User)session.get(User.class, userID);
      Movie movie=new Movie(movieName, movieYear);
      movie.setUserKey(user);
      session.save(movie);  
	  tx.commit(); 
		
		
	    return userID;
	
	 }



	public List<Movie> getMoviesById(Integer userID) {
		
		
		List<Movie>moviesList=new ArrayList<Movie>();
		
		iniciaOperacion();
    	String queryString = "from Movie where userKey_userID = :userIdDB";
        Query query = session.createQuery(queryString);
        query.setInteger("userIdDB", userID);
        moviesList = query.list();
		 
		 
		 return moviesList;
		
		
	
	}
	
	
public List<Movie> getMoviesByName(String Name) {
		
		
		List<Movie>moviesNameList=new ArrayList<Movie>();
		
		iniciaOperacion();
    	//String queryString = "from Movie movie where lower(movie.movieName) like lower(movieName)";
       // Query query = session.createQuery(queryString);
	  //	Query qry = session.createQuery("From Movie as mv where mv."+movieName+" like :sf");
		Query qry = session.createQuery("From Movie mv where mv.movieName like :sf");
		qry.setString("sf", '%'+Name+'%');		
		List<Movie> resultList= qry.list();
        //moviesNameList =(List<Movie>) query.list();
		
        
		
		
       
        
        
        for(int i = 0;i<resultList.size();i++)
	      {
	          
        	  Movie movie = (Movie) resultList.get(i);
        	  System.out.println("First print "+ movie.getMovieName()+ movie.getMovieYear() );         
        	  System.out.println(resultList.get(i));         
	          System.out.println("im printing right from data base with HQL from connection");
	      }
	      
        
		 return resultList;
	
	
	
}
	
	

public List<Movie> getMoviesByNameCri(String movieName) {
	
	
	//List<Movie>moviesNameList=new ArrayList<Movie>();
	
	iniciaOperacion();
	Criteria crit = session.createCriteria(Movie.class);
	crit.add(Restrictions.like("movieName",movieName+"%"));
	List<Movie> results = (List<Movie>)crit.list();
    
   

    
    for(int i = 0;i<results.size();i++)
      {
          
    	  Movie movie = (Movie) results.get(i);
    	  System.out.println("First print "+ movie);         
    	  System.out.println(results.get(i));         
          System.out.println("im printing right from data base");
      }
      

	return results;


}
	

	
	
	
	
	
	
	
	
}
