package thatmovie.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;





@Entity
public class Movie {

	
	@Id	
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	private int movieYear;
	
	
	
	 public Movie(String movieName, int movieYear) {
		super();
		this.movieName = movieName;
		this.movieYear = movieYear;
	
	}
	 
	 
	 
	@OneToOne
	 User userKey=new User();

	 public User getUserKey() {
			return userKey;
		 }

	 
	 public void setUserKey(User userKey) {
     this.userKey = userKey;	 
		 }

	
	
	
	
	



	public Movie() {
		super();
	}
	
	
	public Movie(int movieId, String movieName, int movieYear) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieYear = movieYear;
	}



	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
	
	
	
	
	
}
