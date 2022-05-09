<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Log in to your account</title>
        <base href="${pageContext.request.contextPath}">
        <link rel="stylesheet" href="/resources/css/login.css" type="text/css">
        <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="margin">
            <br><br>
            <br><br>
            <br><br>
        </div>
        <div class="content">
        <header>
          <h1>Login</h1>
        </header>

        <c:url value="/user_pass_login" var="loginUrl"/>
        <form action="/login" method="POST">
            <div><label> Username: <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="stage">
                <input type="submit" class="btn" value="Login"/>
            </div>
        </form>
        </div>
    </body>
</html>