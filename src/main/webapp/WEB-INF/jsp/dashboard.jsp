<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello ${Teacher.name}</h1>
	<span>User name : ${Teacher.userName}</span>
	<br>
	<a href="/">Logout</a>
	<br>
	<br>
	<h1>Create Student</h1>
	<div>
		<font color="red">${studentExist}</font>
        <form action="/addStudent?tid=${Teacher.id}" method="post">
            Name : <input type="text" name="name" required /><br><br>
            Roll number : <input type="number" name="rollNumber" required /><br><br>
            Department : <input type="text" name="department" required /><br><br>
            Standard : <input type="number" name="standerd" required /><br><br>
            Gender : <input type="radio" value="male" name="gender"/> Male   
                     <input type="radio" value="female" name="gender"/> Female   
                     <input type="radio" value="other" name="gender"/> Other  <br><br>
            Age : <input type="number" name="age" required /><br><br>
        	<button value="submit">Submit</button>
        </form>
    </div>
	<br>
	<br>
	<table>
		<tr>
			<th>Roll number</th>
			<th>Name</th>
			<th>Department</th>
			<th>Standard</th>
			<th>Gender</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${list}" var="Student">
		<tr>
			<td>${Student.rollNumber}</td>
			<td>${Student.name}</td>
			<td>${Student.department}</td>
			<td>${Student.standerd}</td>
			<td>${Student.gender}</td>
			<td>${Student.age}</td>
			<td><a href="fillData?sid=${Student.id}">Update</a></td>
			<td><a href="deleteStudent?sid=${Student.id}&tid=${Teacher.id}">Delete</a>
		</tr>
		</c:forEach>
	</table>
</body>
</html>