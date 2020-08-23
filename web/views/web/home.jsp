
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
            <h3>Full name: ${USERDETAIL.fullName}</h3>
            <h3>Email: ${USERDETAIL.email}</h3>
            <h3>Phone: ${USERDETAIL.phone}</h3>
            <c:if test="${not empty RANK}">
                <h3>Rank: ${RANK.name}</h3>    
            </c:if>
                <c:if test="${empty RANK}">
                <h3>Rank: Not assign</h3>    
            </c:if>
            <hr>
        </c:if>
            
            <c:if test="${not empty HISTORY.listResult}">
                <h3>History</h3>
                <table class="table table-hover mt-5" style="text-align: center;">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Date</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <!-- not empty cart-->
                    <c:forEach var="item" items="${HISTORY.listResult}" varStatus="index">
                        <tr>

                            <td>${index.count}</td>
                            <td>${item.date}</td>
                            <td>${item.action}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>





    </body>
</html>
