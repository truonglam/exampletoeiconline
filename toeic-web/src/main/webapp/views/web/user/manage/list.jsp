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
                <c:url var="examinationResult" value="/quan-ly-tai-khoan.html?urlType=ket-qua-thi"/>
                <a href="${examinationResult}"><h3>Kết quả thi</h3></a>
            </div>
            <div class="grid_1_of_3 images_1_of_3">
                <img src="<c:url value="/template/product/images/delivery-img1.jpg"/>" alt="" />
                <c:url var="exerciseResult" value="/quan-ly-tai-khoan.html?urlType=ket-qua-bai-tap"/>
                <a href="${exerciseResult}"><h3>Kết quả học tập</h3></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
