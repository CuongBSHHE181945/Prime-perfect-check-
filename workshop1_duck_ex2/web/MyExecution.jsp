<%-- 
    Document   : MyExecution
    Created on : Jul 13, 2024, 11:23:45 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="count" method="post">
            <table>
                <tr>
                    <td>
                        Enter an integer array: 
                    </td>
                    <td>
                        <input type="text" name="integer">
                    </td>
                </tr>
                <tr>
                    <td>
                        Choose an option
                    </td>
                    <td>
                        <input type ="radio" name="type" value="perfect"/>Perfects
                        <input type="radio" name="type" value="prime">Primes
                    </td>
                </tr>
                <tr>
                    <td>Result: </td>
                    <td><input type="text" value="${result}" readonly></td>
                </tr>
            </table>
        <input type="submit" value="COUNT"> 
        <c:if test="${existed}">
            Execution existed!
        </c:if>
        <c:if test="${invalid}">
            You must input an integer array!
        </c:if>
        </form>
        List of Execution:<br>
        <table border="1">
            <tr>
                <td>Array</td>
                <td>Option</td>
                <td>Result</td>
            </tr>
            <c:forEach var="test" items="${testcase}">
                <tr>
                    <td>${test.printInput()}</td>
                    <td>${test.getType()}</td>
                    <td>${test.printResult()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
