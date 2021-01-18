<%--
  Created by IntelliJ IDEA.
  User: ssykh
  Date: 05.01.2021
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%@include file="../../WEB-INF/fragment/header.jsp"%>
    <div class="wrapper my-account">
        <%--<div class="breadcumb-area overlay pos-rltv">
            <div class="bread-main">
                <div class="bred-hading text-center">
                    <h5><fmt:message key="account.hello" bundle="${text}"/> ${sessionScope.currentUserName}</h5>
                </div>
                <label class="breadcrumb">
                    <input type="submit" name="TODO">
                </label>
            </div>
        </div>--%>
        <div class="idea-area  ptb-80">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-4 col-xs-12">
                        <div class="idea-tab-menu">
                            <ul class="nav idea-tab" role="tablist">
                                <li role="presentation" class="active"><a href="#creativity" aria-controls="creativity" role="tab" data-toggle="tab">Personal Info</a></li>
                                <li role="presentation"><a href="#ideas" aria-controls="ideas" role="tab" data-toggle="tab">Shipping Address</a></li>
                                <li role="presentation"><a href="#design" aria-controls="design" role="tab" data-toggle="tab">Billing Details</a></li>
                                <li role="presentation"><a href="#devlopment" aria-controls="devlopment" role="tab" data-toggle="tab">My Order</a></li>
                                <li role="presentation"><a href="#markenting" aria-controls="markenting" role="tab" data-toggle="tab">Payment Method</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-9 col-sm-8 col-xs-12">
                        <div class="idea-tab-content">
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane fade in active" id="creativity">
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>${sessionScope.currentUserName}</label>
                                            <input type="submit" name="namm" class="info" placeholder="First Name">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>${sessionScope.currentUserEmail}</label>
                                            <input type="submit" name="email" class="info" placeholder="Your Email">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>${sessionScope.currentRole}</label>
                                            <input type="submit" name="phone" class="info" placeholder="Phone Number">
                                        </div>
                                    </div>
                                    <div>
                                        <form action="${pageContext.request.contextPath}/controller" method="post">
                                           <input type="hidden" name="command" value="change_password">
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <div class="input-box mb-20">
                                                    <label><fmt:message key="account.old_pass" bundle="${text}"/></label>
                                                        <input type="password" name="old_password" class="info" placeholder="Your Email">
                                                </div>
                                            </div>
                                            <div class="input-box mb-20">
                                                <label><fmt:message key="account.new_pass" bundle="${text}"/></label>
                                                <input type="password" name="new_password" class="info" placeholder="Phone Number">
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <div class="input-box mb-20">
                                                  <label><fmt:message key="account.repeat_new_pass" bundle="${text}"/> </label>
                                                    <input type="password" name="new_password_repeat" class="info" placeholder="Phone Number">
                                                </div>
                                            </div>
                                            <div class="input-box mb-20">
                                                <label>${sessionScope.currentRole}</label>
                                                <input type="submit" class="info"
                                                       name="<fmt:message key="account.change_pass" bundle="${text}"/>"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div role="tabpanel" class="tab-pane fade in" id="ideas">
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>First Name <em>*</em></label>
                                            <input type="text" name="namm" class="info" placeholder="First Name">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Last Name<em>*</em></label>
                                            <input type="text" name="namm" class="info" placeholder="Last Name">
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Email Address<em>*</em></label>
                                            <input type="email" name="email" class="info" placeholder="Your Email">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Phone Number<em>*</em></label>
                                            <input type="text" name="phone" class="info" placeholder="Phone Number">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Country <em>*</em></label>
                                            <select class="selectpicker select-custom" data-live-search="true">
                                                <option data-tokens="Bangladesh">Bangladesh</option>
                                                <option data-tokens="India">India</option>
                                                <option data-tokens="Pakistan">Pakistan</option>
                                                <option data-tokens="Pakistan">Pakistan</option>
                                                <option data-tokens="Srilanka">Srilanka</option>
                                                <option data-tokens="Nepal">Nepal</option>
                                                <option data-tokens="Butan">Butan</option>
                                                <option data-tokens="USA">USA</option>
                                                <option data-tokens="England">England</option>
                                                <option data-tokens="Brazil">Brazil</option>
                                                <option data-tokens="Canada">Canada</option>
                                                <option data-tokens="China">China</option>
                                                <option data-tokens="Koeria">Koeria</option>
                                                <option data-tokens="Soudi">Soudi Arabia</option>
                                                <option data-tokens="Spain">Spain</option>
                                                <option data-tokens="France">France</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Town/City <em>*</em></label>
                                            <input type="text" name="add1" class="info" placeholder="Town/City">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>State/Divison <em>*</em></label>
                                            <select class="selectpicker select-custom" data-live-search="true">
                                                <option data-tokens="Barisal">Barisal</option>
                                                <option data-tokens="Dhaka">Dhaka</option>
                                                <option data-tokens="Kulna">Kulna</option>
                                                <option data-tokens="Rajshahi">Rajshahi</option>
                                                <option data-tokens="Sylet">Sylet</option>
                                                <option data-tokens="Chittagong">Chittagong</option>
                                                <option data-tokens="Rangpur">Rangpur</option>
                                                <option data-tokens="Maymanshing">Maymanshing</option>
                                                <option data-tokens="Cox">Cox's Bazar</option>
                                                <option data-tokens="Saint">Saint Martin</option>
                                                <option data-tokens="Kuakata">Kuakata</option>
                                                <option data-tokens="Sajeq">Sajeq</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Post Code/Zip Code<em>*</em></label>
                                            <input type="text" name="zipcode" class="info" placeholder="Zip Code">
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Address <em>*</em></label>
                                            <input type="text" name="add1" class="info mb-10" placeholder="Street Address">
                                            <input type="text" name="add2" class="info mt10" placeholder="Apartment, suite, unit etc. (optional)">
                                        </div>
                                    </div>
                                    <div class="col-xs-12 text-right">
                                        <a class="btn-def btn2" href="#">Save</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
