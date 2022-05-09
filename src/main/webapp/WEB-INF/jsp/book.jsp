<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Finding a book</title>
    <link rel="stylesheet" href="/resources/css/operation.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
</head>
    <body>
        <table border="1">
            <caption>Book</caption>
            <tr>
                <th>Book Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Isbn</th>
                <th>Is Available</th>
            </tr>
            <tr>
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>${book.isAvailable}</td>
            </tr>
        </table>
        <br>
        <form action="/book/delete" method="post">
            <label>
                <br>
                <input type="hidden" name="id" value=${book.bookId}>
            </label>
            <button type="submit">Delete this book</button>
        </form>
        <br>
                <form action="/book/return" method="post">
                    <br>
                    <c:choose>
                        <c:when test="${book.isBorrowed()==true}">
                            <label>
                                <input type="hidden" name="id" value=${book.bookId}>
                                <button type="submit">Return this book</button>
                            </label>
                        </c:when>
                    </c:choose>
                </form>
                <form action="/loan/add" method="post">
                    <br>
                    <c:choose>
                        <c:when test="${!book.isBorrowed()==true}">
                        <label>
                            <input type="hidden" name="bookId" value=${book.bookId}>
                            <a>Input borrower's id:</a>
                            <input type="number" name="readerId">
                            <button type="submit">Loan this book</button>
                        </label>
                        </c:when>
                    </c:choose>
                </form>
                <form action="/book/update" method="get">
                    <label>
                        <input type="hidden" name="bookId" value=${book.bookId}>
                    </label>
                    <button type="submit">Update this book data</button>
                </form>
                <br>
                <a href="/">Back to main menu</a>
    </body>
</html>
