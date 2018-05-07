<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Quản lý tài khoản</title>
</head>
<body>
<div class="main">
    <div class="content">
        <div class="section group">
            <div class="grid_1_of_3 images_1_of_3">
                <img src="<c:url value="/template/product/images/delivery-img1.jpg"/>" alt="" />
                <c:set var="examinationResult" value="/quan-ly-tai-khoan.html?urlType=ket-qua-thi"/>
                <a href="${examinationResult}"><h3>Kết quả thi</h3></a>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
            </div>
            <div class="grid_1_of_3 images_1_of_3">
                <img src="<c:url value="/template/product/images/delivery-img1.jpg"/>" alt="" />
                <h3>Lorem Ipsum is simply dummy text </h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
            </div>
            <div class="grid_1_of_3 images_1_of_3">
                <img src="<c:url value="/template/product/images/delivery-img1.jpg"/>" alt="" />
                <h3>Lorem Ipsum is simply dummy text </h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
