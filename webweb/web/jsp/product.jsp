<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="${sessionScope.currentLocale}" scope="session"/>
<fmt:setBundle basename="text" var="text"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="submit" name="command" value="add_product"/>
    <label>
        <input type="text" name="name_product" />
    </label>
    <label>
        <input type="text" name="price_product" />
    </label>
    <label>
        <input type="text" name="info_product"/>
    </label>
        <input type="hidden" name="image_product" value="${requestScope.image_name}" >
</form>
<form action="${pageContext.request.contextPath}/downloadimg" method="post" enctype="multipart/form-data">
    <input type="file" name="image_product"/>
    <input type="submit" name="add img">
</form>
</body>
</html>