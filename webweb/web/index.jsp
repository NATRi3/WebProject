<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ssykh
  Date: 29.12.2020
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale scope="session" value="ru-RU"/>
<fmt:setBundle basename="text" var="text"/>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <jsp:forward page="/jsp/main.jsp"/>
  </body>
</html>
