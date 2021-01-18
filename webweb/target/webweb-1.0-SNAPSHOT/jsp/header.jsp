
    <header class="header-area header-wrapper">
        <div class="header-top-bar black-bg clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-3 col-xs-6">
                        <form action="${pageContext.request.contextPath}/controller" >
                            <input type="hidden" name="command" value="change_locale">
                            <input type="hidden" name="newLocale" value="<fmt:message bundle="${text}" key="language.value"/>">
                            <input type="submit" name="languageButton" value="<fmt:message bundle="${text}" key="language.submit"/>">
                        </form>
                        <c:if test="${sessionScope.currentUserAccess!=null}">
                        <form action="${pageContext.request.contextPath}/controller" method="get">
                            <input type="hidden" name="command" value="redirect_to_account">
                            <input type="submit" name="account" value="account">
                        </form>
                        <form action="${pageContext.request.contextPath}/controller" method="get">
                            <input type="hidden" name="command" value="logout">
                            <input type="submit" name="logout" value="logout">
                        </form>
                        </c:if>
                        <c:if test="${sessionScope.currentUserAccess==null}">
                            <form action="${pageContext.request.contextPath}/controller" method="get">
                                <input type="hidden" name="command" value="redirect_to_registration">
                                <input type="submit" name="login" value="registration">
                            </form>
                            <form action="${pageContext.request.contextPath}/controller" method="get">
                                <input type="hidden" name="command" value="redirect_to_login">
                                <input type="submit" name="login" value="login">
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </header>

