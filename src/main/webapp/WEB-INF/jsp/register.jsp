<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Teacher</title>
</head>
<body>
    <h1>Create Teacher</h1>
    <div>
        <form action="/addTeacher" method="post">
            Name : <input type="text" name="name" required /><br><br>
            Email : <input type="text" name="email" required /><br><br>
            User name : <input type="text" name="userName" required /><br><br>
            Gender : <input type="radio" value="male" name="gender"/> Male   
                     <input type="radio" value="female" name="gender"/> Female   
                     <input type="radio" value="other" name="gender"/> Other  <br><br>
            Age : <input type="number" name="age" required /><br><br>
            Password : <input type="password" name="password" required /><br><br>
            <br>
            <button value="submit">Submit</button>
        </form>
    </div>
</body>

</html>