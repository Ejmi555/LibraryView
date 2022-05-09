<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Form - getting a reader by bookId</title>
        <link rel="stylesheet" href="/resources/css/operation.css" type="text/css">
        <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
    </head>
    <body>
    <form action="/readers" method="get">
        <p>Search by reader's id:</p>
        <label>
            <input type="number" name ="id">
        </label>
        <button class="btn" type="submit">Submit</button>
    </form>
    <form action="/readers/find/name" method="get">
        <p>Search by reader's full name:</p>
        <label>
            <input type="text" name="firstName">
            <input type="text" name="lastName">
        </label>
        <button class="btn" type="submit">Submit</button>
    </form>
    <br>
    <a href="/"><button class="btn">Back</button></a>
    </body>
</html>
