
<%--
  Created by IntelliJ IDEA.
  User: ssykh
  Date: 29.12.2020
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="${sessionScope.currentLocale}" scope="session"/>
<fmt:setBundle basename="text" var="text"/>
<html>
<head>
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
<div class="wrapper shop-full-list">
<%@ include file="../WEB-INF/fragment/header.jsp"%>
<div>
    <div class="account-area ptb-80">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-xs-12">
                    <fmt:message key="login.title" bundle="${text}"/>
                    <p>${requestScope.message}</p>

                    <form class="login-side" method="post" action="${pageContext.request.contextPath}/controller">
                        <div class="login-reg">
                            <input type="hidden" name="command" value="login">
                            <br><h3><fmt:message bundle="${text}" key="login.post"/></h3>
                            <div class="input-box mb-20">
                                <label class="control-label">
                                <input type="text"  name="email" required pattern="^([A-Za-z0-9_-]+\.)*[A-Za-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
                                placeholder=<fmt:message bundle="${text}" key="login.post"/>/>
                                </label>
                            </div>
                            <br><h3><fmt:message bundle="${text}" key="login.password"/></h3>
                            <div class="input-box">
                                <label class="control-label">
                                <input type="password"  name="password" placeholder="<fmt:message bundle="${text}" key="login.password"/>"/>
                                </label>
                            </div>
                        </div>
                        <div class="frm-action">
                            <br><input type="submit" value=<fmt:message bundle="${text}" key="login.submit"/>/>
                        </div>
                    </form>
                    <form method="post" action="${pageContext.request.contextPath}/jsp/registration.jsp">
                        <input class="frm-action" type="submit" value="<fmt:message bundle="${text}" key="login.toregistration"/>">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
