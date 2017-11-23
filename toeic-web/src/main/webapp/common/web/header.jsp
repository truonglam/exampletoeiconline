<%@include file="/common/taglib.jsp"%>
<!--HEADER ROW-->
<div id="header-row">
    <div class="container">
        <div class="row">
            <!--LOGO-->
            <div class="span3"><a class="brand" href="#"><img src="img/logo.png"/></a></div>
            <!-- /LOGO -->

            <!-- MAIN NAVIGATION -->
            <div class="span9">
                <div class="navbar  pull-right">
                    <div class="navbar-inner">
                        <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                        <div class="nav-collapse collapse navbar-responsive-collapse">
                            <ul class="nav">
                                <li class="active"><a href="index.html">Home</a></li>

                                <li class="dropdown">
                                    <a href="about.html" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="about.html">Company</a></li>
                                        <li><a href="about.html">History</a></li>
                                        <li><a href="about.html">Team</a></li>
                                    </ul>
                                </li>
                                <li><a href="service.html">Services</a></li>
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

                    </div>
                </div>
            </div>
            <!-- MAIN NAVIGATION -->
        </div>
    </div>
</div>
<!-- /HEADER ROW -->