<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Users</title>
</head>
<body>
<h1>From JSP Users</h1>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>NICKNAME</th>
            <th>EMAIL</th>
        </tr>
        <c:forEach items="${personsForJSP}" var="pers">
            <tr>
                <td>${pers.id}</td>
                <td>${pers.nickname}</td>
                <td>${pers.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
