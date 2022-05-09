<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Finding a reader</title>
        <link rel="stylesheet" href="/resources/css/operation.css" type="text/css">
        <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
    </head>
    <body>
        <table border="1">
            <caption>Reader</caption>
            <tr>
                <th>Reader Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Telephone Number</th>
                <th>Registration Date</th>
                <th>Resignation Date</th>
            </tr>
            <tr>
                <td>${reader.readerId}</td>
                <td>${reader.firstName}</td>
                <td>${reader.lastName}</td>
                <td>${reader.address}</td>
                <td>${reader.telephoneNumber}</td>
                <td>${reader.registrationDate}</td>
                <td>${reader.resignationDate}</td>
            </tr>
        </table>
        <br>
                <table border="1">
                    <caption>Not returned books:</caption>
                    <tr>
                        <th>loan date</th>
                        <th>book id</th>
                        <th>title</th>
                        <th>author</th>
                        <th>isbn</th>
                    </tr>
                    <c:forEach var="loan" items="${reader.notReturnedBooks}">
                        <tr>
                            <td>${loan.loanDate}</td>
                            <td><a href="/books?id=${loan.book.bookId}">${loan.book.bookId}</a></td>
                            <td><a href="/books?id=${loan.book.bookId}">${loan.book.title}</a></td>
                            <td><a href="/books?id=${loan.book.bookId}">${loan.book.author}</a></td>
                            <td><a href="/books?id=${loan.book.bookId}">${loan.book.isbn}</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <form action="/readers/resign" method="post">
                    <c:choose>
                        <c:when test="${reader.hasReturnedBooks()==true && reader.resignationDate == null}">
                            <label>
                                <br>
                                <input type="hidden" name="readerId" value=${reader.readerId}>
                            </label>
                            <button type="submit">Register resignation</button>
                        </c:when>
                    </c:choose>
                </form>
                <br>
                <form action="/readers/update" method="get">
                    <label>
                        <input type="hidden" name="readerId" value=${reader.readerId}>
                    </label>
                    <button type="submit">Update this reader data</button>
                </form>
                <br>
        <a href="/">Back to main menu</a>
    </body>
</html>