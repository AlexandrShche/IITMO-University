<%--
  Created by IntelliJ IDEA.
  User: alexander
  Date: 28.10.2021
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" isErrorPage="true"%>

<html>
    <head>

    </head>
    <body>
        ERROR
    </body>
</html>


<% if(response.getStatus() == 500){ %>
Error: <%=exception.getMessage() %>

<%-- include login page --%>
<%@ include file="index.jsp"%>
<%}else {%>
Hi There, error code is <%=response.getStatus() %>
Please go to home page
<%} %>
