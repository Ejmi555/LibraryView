<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Homepage</title>
    <base href="${pageContext.request.contextPath}">
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
</head>
<body>
    <header><h1>Library Homepage</h1></header>

    <article>
        <h3>What would you like to do?</h3>
                <div>
                    <p>Regarding a book:</p>
                    <a href="/books">Browse the books</a><br>
                    <a href="/books/find">Find a book</a><br>
                    <a href="/books/add">Add a book</a><br>
                </div>
                <div>
                    <p>Regarding a reader:</p>
                    <a href="/profile">Check profile</a><br>
                    <a href="/readers">Browse readers</a><br>
                    <a href="/readers/find">Find a reader</a><br>
                    <a href="/readers/add">Add a reader</a><br>
                    <a href="ścieżka">Register reader's resignation</a><br>
                </div>
                <div>
                    <p>Regarding loans:</p>
                    <a href="ścieżka">Register lending a book</a><br>
                    <a href="ścieżka">Register returning a book</a>
                </div>
    </article>
</body>
</html>