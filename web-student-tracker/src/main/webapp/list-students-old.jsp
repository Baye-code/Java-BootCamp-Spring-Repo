<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Student Tracker App</title>
</head>

<%
	// get the students from the request object (sent by the servlet)
	List<Student> theStudents = 
					(List<Student>) request.getAttribute("STUDENT_LIST");

%>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			<table>
				
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
				</tr>
				
				<%  for (Student tempStudent : theStudents)  { %>
				
					<tr>
						<td> <%=  tempStudent.getFirstName()  %> </td>
						<td> <%=  tempStudent.getLastName()  %> </td>
						<td> <%=  tempStudent.getEmail()  %> </td>
					</tr>
				
				<%  }  %>
			</table>
		</div>
	
	</div>

</body>
</html>