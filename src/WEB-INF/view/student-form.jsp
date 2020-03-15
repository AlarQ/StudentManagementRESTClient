<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-student-style.css" />
	<title>Student form</title>
</head>

<body>
	 <div id="wrapper">
 		<div id="header">
 			<h2>Add student</h2>
 		</div>
	</div>
	
	<form:form action="saveStudent" modelAttribute="student" method="POST">
		<!-- associate populated data with id -->
		<form:hidden path="id" />
		
		First name: <form:input path="firstName"/>
		<br/> <br/>
		Last name: <form:input path="lastName"/>
		<br/> <br/>
		Email: <form:input path="email"/>
		<br/> <br/>
		Year
		<form:select path="year">
			<form:option value="1" label="1"/>
			<form:option value="2" label="2"/>
			<form:option value="3" label="3"/>
			<form:option value="4" label="4"/>
			<form:option value="5" label="5"/>
		</form:select> 
		<br/> <br/>
		<input type="submit" value="Save" />
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath}/student/list">back to list</a>
	</p>
</body>
 