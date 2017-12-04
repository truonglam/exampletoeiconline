<div class="header">
    <div class="headertop_desc">
        <div class="call">
            <p><span>Need help?</span> call us <span class="number">1-22-3456789</span></p>
        </div>
        <div class="account_desc">
            <ul>
                <c:if test="${not empty login_name}">
                    <li>Xin chao: ${login_name}</li>
                    <c:url var="logoutUrl" value="/logout.html">
                        <c:param name="action" value="logout"/>
                    </c:url>
                    <li><a href="${logoutUrl}"><fmt:message key="label.logout" bundle="${lang}"/></a></li>
                </c:if>
                <c:if test="${empty login_name}">
                    <c:url var="loginUrl" value="/login.html">
                        <c:param name="action" value="login"/>
                    </c:url>
                    <li><a href="${loginUrl}"><fmt:message key="label.login" bundle="${lang}"/></a></li>
                </c:if>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
</div>