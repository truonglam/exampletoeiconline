<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title><dec:title default="Login page"/></title>
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css'/>"/>
    <!-- page specific plugin styles -->
    <!-- text fonts -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css'/>"/>
    <!-- ace styles -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css'/>" class="ace-main-stylesheet" id="main-ace-style" />
    <!-- ace settings handler -->
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js'/>"></script>
    <dec:head/>
</head>
<body class="login-layout">
    <%--<%@ include file="/common/admin/menu.jsp"%>--%>
    <div class="main-container">
        <div class="main-content">
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="login-container">
                        <%@ include file="/common/login/header.jsp"%>
                        <div class="position-relative">
                            <dec:body/>
                        </div>
                        <div class="navbar-fixed-top align-right">
                            <br />
                            &nbsp;
                            <a id="btn-login-dark" href="#">Dark</a>
                            &nbsp;
                            <span class="blue">/</span>
                            &nbsp;
                            <a id="btn-login-blur" href="#">Blur</a>
                            &nbsp;
                            <span class="blue">/</span>
                            &nbsp;
                            <a id="btn-login-light" href="#">Light</a>
                            &nbsp; &nbsp; &nbsp;
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--<%@ include file="/common/admin/footer.jsp"%>--%>

    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
    <!--[if lte IE 8]>
    <script src="<c:url value='/template/admin/assets/js/excanvas.min.js'/>"></script>
    <![endif]-->
    <script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js'/>"></script>
    <!-- ace scripts -->
    <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js'/>"></script>
    <script src="<c:url value='/template/admin/assets/js/ace.min.js'/>"></script>
</body>
</html>
