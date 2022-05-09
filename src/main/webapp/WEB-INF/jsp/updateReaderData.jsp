<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Updating reader data</title>
    <link rel="stylesheet" href="/resources/css/operation.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
</head>
<body>
    <form action="/readers/update/data" method="post">
        <label>
            <input type="hidden" name="readerId" value=${reader.readerId}>
        </label>
        <label>Insert fixed reader data:
            <p>First name:</p>
            <input type="text" name="firstName" value="${reader.firstName}">
            <p>Last name:</p>
            <input type="text" name="lastName" value="${reader.lastName}">
            <p>Address:</p>
            <input type="text" name="address" value="${reader.address}">
            <p>Telephone number:</p>
            <input type="text" name="telephoneNumber" value="${reader.telephoneNumber}">
            <p>Registration date:</p>
            <td>${reader.registrationDate}</td>
            <p>Resignation date:</p>
            <td>${reader.resignationDate}</td>
        </label>
        <br>
        <br>
        <button type="submit">Update this reader data</button>
    </form>
</body>
</html>
