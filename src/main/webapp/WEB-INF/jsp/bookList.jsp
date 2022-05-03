<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Finding a book</title>
    <link rel="stylesheet" href="../css/operation.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
  </head>
  <body>
    <table border="1">
      <caption>Book search results</caption>
      <tr>
        <th>book id</th>
        <th>title</th>
        <th>author</th>
        <th>isbn</th>
      </tr>
      <c:forEach var="book" items="${books}">
        <tr>
          <td><a href="/book?id=${book.bookId}">${book.bookId}</a></td>
          <td><a href="/book?id=${book.bookId}">${book.title}</a></td>
          <td><a href="/book?id=${book.bookId}">${book.author}</a></td>
          <td><a href="/book?id=${book.bookId}">${book.isbn}</a></td>
        </tr>
      </c:forEach>
    </table>
    <br>
    <a href="/">Back to main menu</a>
  </body>
</html>
