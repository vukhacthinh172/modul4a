<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vukha
  Date: 15/01/2024
  Time: 10:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Song Name</th>
        <th scope="col">author</th>
        <th scope="col">Description</th>
        <th scope="col">imageURl</th>
        <th scope="col">videoURL</th>
        <th scope="col">Duration</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="song">
        <tr>
            <td>${song.id}</td>
            <td>${song.songName}</td>
            <td>${song.description}</td>
            <td>${song.imageUrl}</td>
            <td>
                <c:if test="${not empty song.videoUrl}">
                    <iframe width="560" height="315" src="${song.videoUrl}" allowfullscreen></iframe>
                </c:if>
            </td>
            <td>${song.author}</td>
            <td>${song.duration}</td>
            <td>${song.status}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
