
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
        <div>
            <div class="breadcumb-area overlay pos-rltv">
                <div class="bread-main">
                    <div class="bred-hading text-center">
                        <h5>Product List View</h5> </div>
                    <ol class="breadcrumb">
                        <li class="home"><a title="Go to Home Page" href="index.html">Home</a></li>
                        <li class="active">Shop Full List</li>
                    </ol>
                </div>
            </div>
            <!--breadcumb area end -->

            <!--shop main area are start-->
            <div class="shop-main-area ptb-70">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="shop-area-top">
                                <div class="row">
                                    <div class="col-lg-4 col-md-5 col-sm-6 col-xs-12">
                                        <div class="sort product-show">
                                            <label>View</label>
                                            <select id="input-amount">
                                                <option value="volvo">10</option>
                                                <option value="saab">15</option>
                                                <option value="vw">20</option>
                                                <option value="audi" selected>25</option>
                                            </select>
                                        </div>
                                        <div class="sort product-type">
                                            <label>Sort By</label>
                                            <select id="input-sort">
                                                <option value="#" selected>Default</option>
                                                <option value="#">Name (A - Z)</option>
                                                <option value="#">Name (Z - A)</option>
                                                <option value="#">Price (Low &gt; High)</option>
                                                <option value="#">Price (High &gt; Low)</option>
                                                <option value="#">Rating (Highest)</option>
                                                <option value="#">Rating (Lowest)</option>
                                                <option value="#">Model (A - Z)</option>
                                                <option value="#">Model (Z - A)</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-3 col-sm-2 col-xs-12">
                                        <div class="list-grid-view text-center">
                                            <ul class="nav" role="tablist">
                                                <li role="presentation"><a href="#grid" aria-controls="grid" role="tab" data-toggle="tab"><i class="zmdi zmdi-widgets"></i></a></li>
                                                <li role="presentation" class="active"><a href="#list" aria-controls="list" role="tab" data-toggle="tab"><i class="zmdi zmdi-view-list-alt"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 hidden-xs">
                                        <div class="total-showing text-right">
                                            Showing - <span>10</span> to <span>18</span>  Of  Total <span>36</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="shop-total-product-area clearfix mt-35">
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <!--tab grid are start-->
                                <div role="tabpanel" class="tab-pane fade in" id="grid">
                                    <div class="total-shop-product-grid">
                                        <div class="col-md-3 col-sm-4 col-xs-12 item">
                                            <!-- single product start-->
                                            <div class="single-product">
                                                <div class="product-img">
                                                    <div class="product-label red">
                                                        <div class="new">New</div>
                                                    </div>
                                                    <div class="single-prodcut-img  product-overlay pos-rltv">
                                                        <a href="single-product.html"> <img alt="" src="images/product/01.jpg" class="primary-image"> <img alt="" src="images/product/02.jpg" class="secondary-image"> </a>
                                                    </div>
                                                    <div class="product-icon socile-icon-tooltip text-center">
                                                        <ul>
                                                            <li><a href="#" data-tooltip="Add To Cart" class="add-cart" data-placement="left"><i class="fa fa-cart-plus"></i></a></li>
                                                            <li><a href="#" data-tooltip="Wishlist" class="w-list"><i class="fa fa-heart-o"></i></a></li>
                                                            <li><a href="#" data-tooltip="Compare" class="cpare"><i class="fa fa-refresh"></i></a></li>
                                                            <li><a href="#" data-tooltip="Quick View" class="q-view" data-toggle="modal" data-target=".modal"><i class="fa fa-eye"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="product-text">
                                                    <div class="prodcut-name"> <a href="single-product.html">Quisque fringilla</a> </div>
                                                    <div class="prodcut-ratting-price">
                                                        <div class="prodcut-price">
                                                            <div class="new-price"> $220 </div>
                                                        </div>
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
