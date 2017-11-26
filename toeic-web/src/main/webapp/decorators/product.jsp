<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title><fmt:message key="label.home" bundle="${lang}"/> </title>
    <link href="<c:url value="/template/product/css/style.css"/>" rel="stylesheet" type="text/css" media="all"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/template/product/js/move-top.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/template/product/js/easing.js"/>"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js"></script>
    <script src="<c:url value="/template/product/jquery.twbsPagination.js"/>" type="text/javascript"></script>
    <%--<script src="<c:url value='/template/product/js/jquery.validate.min.js' />"></script>--%>
    <dec:head />
</head>
<body>
<div class="wrap">
    <%@ include file="/common/product/header.jsp" %>
    <dec:body/>
</div>
<%@ include file="/common/product/footer.jsp" %>
<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>
