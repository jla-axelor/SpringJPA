<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update student</title>
</head>
<body>
	<h1>Update Student ${s.name}</h1>
	<div>
        <form action="/updateStudentData" method="post">
            Name : <input type="text" name="name" value="${s.name}" required /><br><br>
            Roll number : <input type="number" name="rollNumber" value="${s.rollNumber}" readonly="readonly" /><br><br>
            Department : <input type="text" name="department" value="${s.department}" required /><br><br>
            Standard : <input type="number" name="standerd" value="${s.standerd}" required /><br><br>
            Gender : <input type="radio" value="male" name="gender"/> Male   
                     <input type="radio" value="female" name="gender"/> Female   
                     <input type="radio" value="other" name="gender"/> Other  <br><br>
            Age : <input type="number" name="age" value="${s.age}" required /><br><br>
        	<button value="submit">Submit</button>
        </form>
    </div>
    <a href="getAllData?tid=${s.teacher.id}">Back..!</a>
</body>
</html>