<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Adding new book</title>
  <link rel="stylesheet" href="/resources/css/operation.css" type="text/css">
  <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
</head>
<body>
<form action="/books/add" method="post">
  <p>Insert book data:</p>
  <label>
    <p>Title:</p>
    <input type="text" name="title">
    <p>Author:</p>
    <input type="text" name="author">
    <p>Isbn:</p>
    <input type="number" name="isbn">
  </label>
  <br>
  <button class="btn" type="submit">Add this book</button>
</form>
<br>
<a href="/"><button class="btn">Back</button></a>
</body>
</html>
