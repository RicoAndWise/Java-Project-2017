package thatmovie.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User  {


	 
	 @Id	
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int userID;
     private String userName;
     private String passWord;
	
  
     
     public User() {
 		super();
 	}
     
     
     
     
     public User(int userID, String userName, String passWord) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.passWord = passWord;
	}




	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
     













}
