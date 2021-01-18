
<header class="header-area header-wrapper">
    <div class="header-top-bar black-bg clearfix">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-3 col-xs-6">
                    <div class="login-register-area">
                            <ul>
                                <c:if test="${sessionScope.currentUserAccess!=null}">
                                <li>
                                    <form action="${pageContext.request.contextPath}/controller" method="get">
                                        <input type="hidden" name="command" value="redirect_to_account">
                                        <input type="submit" name="account" value="account">
                                    </form>
                                </li>
                                <li>
                                    <form action="${pageContext.request.contextPath}/controller" method="get">
                                        <input type="hidden" name="command" value="logout">
                                        <input type="submit" name="logout" value="logout">
                                    </form>
                                </li>
                                </c:if>
                                <c:if test="${sessionScope.currentUserAccess==null}">
                                <li>
                                    <form action="${pageContext.request.contextPath}/controller" method="get">
                                        <input type="hidden" name="command" value="redirect_to_registration">
                                        <input type="submit" name="login" value="registration">
                                    </form>
                                </li>
                                <li>
                                    <form action="${pageContext.request.contextPath}/controller" method="get">
                                        <input type="hidden" name="command" value="redirect_to_login">
                                        <input type="submit" name="login" value="login">
                                    </form>
                                </li>
                                </c:if>
                            </ul>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6 hidden-xs">
                    <div class="social-search-area text-center">
                        <div class="social-icon socile-icon-style-2">
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/jsp/main.jsp">
                                        <img src="${pageContext.request.contextPath}/WEB-INF/image/page/logo.png" alt="logo"/>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>


                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="cart-currency-area login-register-area text-right">
                                <div class="header-currency">
                                <ul>
                                    <li>
                                        <form action="${pageContext.request.contextPath}/controller" >
                                            <input type="hidden" name="command" value="change_locale">
                                            <input type="hidden" name="newLocale" value="<fmt:message bundle="${text}" key="language.value"/>">
                                            <input type="submit" name="languageButton" value="<fmt:message bundle="${text}" key="language.submit"/>">
                                        </form>
                                    </li>
                                    <li>
                                        <div class="header-cart">
                                            <div class="cart-icon"> <a href="#">Cart<i class="zmdi zmdi-shopping-cart"></i></a> <span>${sessionScope.currentProductValue}</span> </div>
                                            <div class="cart-content-wraper">
                                                <div class="cart-subtotal"> Subtotal: <span>${sessionScope.currentProductPrice}</span> </div>
                                                <div class="cart-check-btn">
                                                    <div class="view-cart"> <a class="btn-def" href="<%--TODO--%>">View Cart</a> </div>
                                                    <div class="check-btn"> <a class="btn-def" href="<%--TODO--%>">Checkout</a> </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                </div>
                            </div>
                        </div>

                </div>
            </div>
            <div id="sticky-header"  class="header-middle-area">
                <div class="container">
                    <div class="full-width-mega-dropdown">
                        <div class="row">
                            <div class="col-md-2 col-sm-2">
                                <div class="logo ptb-20">
                                    <a href="${pageContext.request.contextPath}/index.jsp">
                                        <img src="${pageContext.request.contextPath}/WEB-INF/image/page/logo.png" alt="main logo">
                                    </a>
                                </div>
                            </div>
                            <div class="col-md-7 col-sm-10 hidden-xs">
                                <nav id="primary-menu">
                                    <ul class="main-menu">
                                        <li class="mega-parent pos-rltv"><a href="${pageContext.request.contextPath}/jsp/main.jsp">
                                            <fmt:message key="header.home" bundle="${text}"/>
                                        </a>
                                        </li>
                                        <li class="mega-parent pos-rltv">
                                            <form action="${pageContext.request.contextPath}/controller" method="get">
                                                <input type="hidden" name="command" value="get_list_product">
                                                <input type="hidden" name="gender" value="men">
                                                <input type="submit" value="<fmt:message key="header.men" bundle="${text}"/> ">
                                            </form>
                                            <div class="mega-menu-area mma-800">
                                                <ul class="single-mega-item">
                                                    <li class="menu-title uppercase"><fmt:message key="header.winter" bundle="${text}"/> </li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="men">
                                                            <input type="hidden" name="type" value="accessories">
                                                            <input type="submit" value="<fmt:message key="header.jacket" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="men">
                                                            <input type="hidden" name="type" value="accessories">
                                                            <input type="submit" value="<fmt:message key="header.sweaters" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                </ul>
                                                <ul class="single-mega-item">
                                                    <li class="menu-title uppercase"><fmt:message key="header.summer" bundle="${text}"/></li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="men">
                                                            <input type="hidden" name="type" value="shirt">
                                                            <input type="submit" value="<fmt:message key="header.shirt" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="men">
                                                            <input type="hidden" name="type" value="accessories">
                                                            <input type="submit" value="<fmt:message key="header.shorts" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="mega-parent pos-rltv">
                                            <form action="${pageContext.request.contextPath}/controller" method="get">
                                                <input type="hidden" name="command" value="get_list_product">
                                                <input type="hidden" name="gender" value="women">
                                                <input type="submit" value="<fmt:message key="header.women" bundle="${text}"/>"/>
                                            </form>
                                            <div class="mega-menu-area mma-700">
                                                <ul class="single-mega-item">
                                                    <li class="menu-title uppercase"><fmt:message key="header.winter" bundle="${text}"/></li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="women">
                                                            <input type="hidden" name="type" value="coat">
                                                            <input type="submit" value="<fmt:message key="header.coat" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="women">
                                                            <input type="hidden" name="type" value="jacket">
                                                            <input type="submit" value="<fmt:message key="header.jacket" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                </ul>
                                                <ul class="single-mega-item">
                                                    <li class="menu-title uppercase"><fmt:message key="header.summer" bundle="${text}"/></li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="women">
                                                            <input type="hidden" name="type" value="shirt">
                                                            <input type="submit" value="<fmt:message key="header.shirt" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                    <li>
                                                        <form action="${pageContext.request.contextPath}/controller" method="get">
                                                            <input type="hidden" name="command" value="get_list_product">
                                                            <input type="hidden" name="gender" value="women">
                                                            <input type="hidden" name="type" value="dress">
                                                            <input type="submit" value="<fmt:message key="header.dress" bundle="${text}"/>"/>
                                                        </form>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="mega-parent">
                                            <a href="${pageContext.request.contextPath}/controller?command=redirect_to_account">
                                                <fmt:message key="header.account" bundle="${text}"/>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="/jsp/about.jsp">
                                                <fmt:message key="header.about" bundle="${text}"/>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="col-md-3 hidden-sm hidden-xs">
                                <div class="search-box global-table">
                                    <div class="global-row">
                                        <div class="global-cell">
                                            <form action="${pageContext.request.contextPath}/controller" method="get">
                                                <div class="input-box">
                                                    <input class="single-input"
                                                           placeholder="<fmt:message key="header.search" bundle="${text}"/> "
                                                           type="text" name="name_product">
                                                    <input type="hidden" name="command" value="search_product_by_name">
                                                    <button class="src-btn"><i class="fa fa-search"></i></button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

