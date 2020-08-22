
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <c:if test="${empty USERDETAIL}">
            <h3>Hello ${USERMODEL.fullName}</h3>
        </c:if>

        <c:if test="${not empty USERDETAIL}">
            <img src="/images/${USERDETAIL.photo}" style="height: 100px; width: 100px;">
            <h3>Fullname: ${USERDETAIL.fullName}</h3>
            <h3>Email: ${USERDETAIL.email}</h3>
            <h3>Phone: ${USERDETAIL.phone}</h3>
            
        </c:if>





    </body>
</html>
