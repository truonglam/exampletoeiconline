<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.home" bundle="${lang}"/></title>
</head>
<body>
<div class="image group">
    <div class="grid news_desc">
        <h3>Lorem Ipsum is simply dummy text </h3>
        <h4>Posted on Aug 13th, 2013 by <span><a href="#">Finibus Bonorum</a></span></h4>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur <a href="#" title="more">[....]</a></p>
        <ul id="pagination-demo" class="pagination-sm"></ul>
    </div>
    <div class="grid images_3_of_1">
            <div style="overflow: auto; height: 400px" >
                <div class="span1">
                    CÂU HỎI
                </div>
                A. <input type="radio" name="ans" value="A">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                B. <input type="radio" name="ans" value="B">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                C. <input type="radio" name="ans" value="C">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                D. <input type="radio" name="ans" value="D">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <br/>
                <br/>
            </div>
            <input type="submit" class="btn btn-primary" value="Nộp bài"/>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {

    });
    $('#pagination-demo').twbsPagination({
        totalPages: 35,
        visiblePages: 0,
        onPageClick: function (event, page) {
            console.log(page);
        }
    });
</script>
</body>
</html>
