<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="wrap">
    <div class="main">
        <div class="content">
            <div class="col span_2_of_3">
                <div class="contact-form">
                    <div>
                            <span>
                                <input name="userName" type="text" class="textbox"/>
                            </span>
                    </div>
                    <div>
                        <span><input type="submit" value="Submit"  class="myButton"></span>
                    </div>
                </div>
            </div>
            <div class="image group">
                <div class="grid images_3_of_1">
                    <img src="<c:url value="/template/product/images/newsimg1.jpg"/>" alt="" />
                </div>
                <div class="grid news_desc">
                    <h3>Lorem Ipsum is simply dummy text </h3>
                    <c:url value="/noi-dung-bai-huong-dan-nghe.html" var="url">
                        <c:param name="id" value="1"/>
                    </c:url>
                    <h4>Posted on Aug 13th, 2013 by <span><a href="${url}">Chi tiết bài hướng dẫn</a></span></h4>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {

    });
</script>
</body>
</html>