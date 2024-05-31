<%--
  Created by IntelliJ IDEA.
  User: Estudiante
  Date: 30/5/2024
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingreso Sistema</title>
</head>
<body>
<h2>iniciar Sesion</h2>
<form action="Login" method="post">
    <div>
        <label for="username">Ingrese el nombre de Usuario</label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">Ingrese su contraseña</label>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
</body>
</html>
