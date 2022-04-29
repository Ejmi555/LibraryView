<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your profile</title>
        <base href="${pageContext.request.contextPath}">
        <link rel="stylesheet" href="css/profile.css" type="text/css">
        <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
    </head>
<body>

    <div><h1>Profile</h1></div>

    <figure>
        <img class="image" src="../images/default-user-image.png" alt="user image">
    </figure>

<div class="role"><b>${username}:</b> ${authorities}</div>

<div>
<form action="/logout" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div><input class="btn" type="submit" value="Logout"/></div>
</form>
</div>
<div>
    <a href="/"><button class="btn">Back</button></a>
</div>

</body>
</html>