<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Loan search results</title>
    <link rel="stylesheet" href="/resources/css/operation.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
</head>
<body>
<table border="1">
    <caption>Loan search results</caption>
    <tr>
        <th>loan id</th>
        <th>book id</th>
        <th>reader id</th>
        <th>loan date</th>
        <th>return date</th>
    </tr>
    <c:forEach var="loan" items="${loans}">
        <tr>
            <td><a href="/loan?id=${loan.loanId}">${loan.loanId}</a></td>
            <td><a href="/loan?id=${loan.loanId}">${loan.book.bookId}</a></td>
            <td><a href="/loan?id=${loan.loanId}">${loan.reader.readerId}</a></td>
            <td><a href="/loan?id=${loan.loanId}">${loan.loanDate}</a></td>
            <td><a href="/loan?id=${loan.loanId}">${loan.returnDate}</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/">Back to main menu</a>
</body>
</html>

