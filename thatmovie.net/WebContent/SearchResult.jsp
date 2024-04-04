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
<title>Search Results</title>
</head>
<body id="searchResultbody">




	<div id="tablediv"  >

		<table id="searchTable">


			<tr class="tableHeaders">
				<th>Movie ID</th>
				<th>Movie Name</th>
				<th>Movie Year</th>
			</tr>


			<c:forEach items="${moviesListsearch}" var="n">

				<tr class="tableRows">

					<td><c:out value="${n.movieId}" /></td>
					<td><c:out value="${n.movieName}" /></td>
					<td><c:out value="${n.movieYear}" /></td>

				

				</tr>

			</c:forEach>

		</table>



	</div>




</body>
</html>