<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/thatmoviestyle.css" type="text/css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<title>Movies</title>

</head>

<body id="moviesBody">

         
 	
		<h1 id="moviesTittle">Movies table</h1>
	
	
	<div class="search-container">

		<form action="MovieViewServlet" id="searchForm" name="searchForm" method="post">

         <p id="searchFormContent">
			<input type="text" placeholder="search for your movies here..."
				name="searchtxt" id="searchtxt" /> 
			
			<input type="submit" name="searchBttn" id="searchBttn" value="Search">
				
			
         </p> 
			
			<input type="text" value="search" name="action" id="action" style="display: none" />

		</form>
	</div>


	

	<br>

	<div id="secondTdiv">

		<table id="moviesTable">


			<tr class="tableHeaders">
				<th>Movie ID</th>
				<th>Movie Name</th>
				<th>Movie Year</th>
			</tr>


			<c:forEach items="${moviesList}" var="p">

				<tr class="tableRows">

					<td><c:out value="${p.movieId}" /></td>
					<td><c:out value="${p.movieName}" /></td>
					<td><c:out value="${p.movieYear}" /></td>

					

				</tr>

			</c:forEach>

		</table>
	</div>

	<br>

		<h2 id="addYmovies">Add your movies here</h2>

	
	<div>

		<form method="post" action="MoviesServlet">

            <p id="movieName">
			<label>Movie Name </label> 
			<input type="text" name="txtMovieName" id="txtMovieName">
            </p>
              
            <p id="movieYear">  
			<label>Movie Year</label> 
			<input type="text" name="txtMovieYear" id="txtMovieYear">
            </p>
			
			<p id="userLabel">
			<label>User: </label> 
			<select name="userID" id="selectUserID">
				
				<c:forEach items="${listUser}" var="p">
                   <option value="<c:out value='${p.getUserID()}'/>">
					  <c:out value="${p.getUserName()}" /></option>

				</c:forEach>

				</select> 
			
			<input type="submit" value="Save" id="saveBttn">
           </p> 
		</form>

	</div>

   <hr>
   
   
   <p id="logoutContainer">
		<input type="button" onclick="location.href='/thatmovie.net/LogoutServlet';" value="Logout" id="logoutBttn">
   </p> 




</body>
</html>