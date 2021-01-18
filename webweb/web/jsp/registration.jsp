<%--
  Created by IntelliJ IDEA.
  User: ssykh
  Date: 30.12.2020
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${sessionScope.currentLocale}" scope="session"/>
<fmt:setBundle basename="text" var="text"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/core.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortcode/shortcodes.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/color/skin-default.css">
    <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title></title>
</head>
<body>
<%@ include file="../WEB-INF/fragment/header.jsp"%>
<div>
<form method="post" action="${pageContext.request.contextPath}/jsp/login.jsp">
    <input type="submit" value="<fmt:message bundle="${text}" key="registration.login" />">
</form>
<form method="post" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="registration">
    <label>
        <br><fmt:message bundle="${text}" key="registration.name" />
        <input type="text"  name="name" placeholder="<fmt:message bundle="${text}" key="registration.name" />"/>
    </label>
    <label>
        <br><fmt:message bundle="${text}" key="registration.email" />
        ${requestScope.massage}
        <input type="text"  name="email" placeholder="<fmt:message bundle="${text}" key="registration.email" />"
               required pattern="^([A-Za-z0-9_-]+\.)*[A-Za-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"/>
    </label>
    <label>
        <br><fmt:message bundle="${text}" key="registration.password" />
        <input type="password"  name="password" placeholder="<fmt:message bundle="${text}" key="registration.password" />"
               required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,40}$"/>
    </label>
    <label>
        <br><fmt:message bundle="${text}" key="registration.repeat" />
        <input type="password"  name="repeat_password" placeholder="<fmt:message bundle="${text}" key="registration.repeat" />"
               required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,40}$"/>
    </label>
    <input type="submit" value="<fmt:message bundle="${text}" key="registration.submitregistration" />"/>
</form>
</div>
</body>
</html>
