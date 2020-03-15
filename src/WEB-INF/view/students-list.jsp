<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	
 	<div id="wrapper">
 		<div id="header">
 			<h2>Students list</h2>
 		</div>
	</div>
	 <div id="container">
	 	<br/>

			<input type="submit" value="add student" onclick="window.location.href='showAddForm'; return false;"
			class="add-button"/>	
			<div id="content">
 			<table>
 				<tr>
 					<th>First name</th>
 					<th>Last name</th>
 					<th>Email</th>
 					<th>Year</th>
 					<th>Action</th>	
 				</tr>
				<c:forEach var="tempStudent" items="${students}">
				
				<!-- construct 'update' link with student id -->
				<c:url var="updateLink" value="/student/showFormForUpdate">
					<c:param name="studentId" value="${tempStudent.id}"/>
				</c:url>
				
				<!-- construct 'update' link with student id -->
				<c:url var="deleteLink" value="/student/delete">
					<c:param name="studentId" value="${tempStudent.id}"/>
				</c:url>
				<tr> 
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.email}</td>
					<td>${tempStudent.year}</td> 
					<td> 
						<a href="${updateLink}">Update</a> 
						|
					 	<a href="${deleteLink}"
					 	onclick="if(!(confirm('Are you sure, you want to delete the student?'))) return false">Delete</a>
					 </td>				
				</tr>
				</c:forEach>
 			</table>
 		</div>
	</div>
</body>

</html>