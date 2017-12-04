<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.home" bundle="${lang}"/></title>
</head>
<body>
<!--Carousel
==================================================-->
<div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">

        <div class="active item">
            <div class="container">
                <div class="row">

                    <div class="span6">

                        <div class="carousel-caption">
                            <h1>tùng lâm</h1>
                            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <a class="btn btn-large btn-primary" href="#">Sign up today</a>
                        </div>

                    </div>

                    <div class="span6"> <img src="img/slide/slide1.jpg"></div>

                </div>
            </div>
        </div>
        <div class="item">
            <div class="container">
                <div class="row">

                    <div class="span6">

                        <div class="carousel-caption">
                            <h1>Example headline</h1>
                            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <a class="btn btn-large btn-primary" href="#">Sign up today</a>
                        </div>

                    </div>
                    <div class="span6"> <img src="img/slide/slide2.jpg"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- Carousel nav -->
    <a class="carousel-control left " href="#myCarousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next"><i class="icon-chevron-right"></i></a>
    <!-- /.Carousel nav -->
</div>
<!-- /Carousel -->



<!-- Feature
==============================================-->

<div class="row feature-box">
    <div class="span12 cnt-title">
        <h1>At vero eos et accusamus et iusto odio dignissimos</h1>
        <span>Contrary to popular belief, Lorem Ipsum is not simply random text.</span>
    </div>
    <div class="span4">
        <img src="img/icon3.png">
        <h2><fmt:message key="label.guideline.listen" bundle="${lang}"/></h2>
        <p>
            Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
        </p>
        <a href="<c:url value="/danh-sach-huong-dan-nghe.html"/>">Read More &rarr;</a>
    </div>

    <div class="span4">
        <img src="img/icon2.png">
        <h2><fmt:message key="label.exercise" bundle="${lang}"/></h2>
        <p>
            Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
            aliqua.
        </p>
        <c:url var="listExercise" value="/danh-sach-bai-tap.html">
            <c:param name="pojo.type" value="listening"/>
        </c:url>
        <a href="${listExercise}">Read More &rarr;</a>
    </div>

    <div class="span4">
        <img src="img/icon1.png">
        <h2><fmt:message key="label.examination" bundle="${lang}"/></h2>
        <p>
            Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
        </p>
        <a href="<c:url value="/danh-sach-bai-thi.html"/>">Read More &rarr;</a>
    </div>
</div>


<!-- /.Feature -->

<div class="hr-divider"></div>

<!-- Row View -->


<div class="row">
    <div class="span6"><img src="img/responsive.png"></div>

    <div class="span6">
        <img class="hidden-phone" src="img/icon4.png" alt="">
        <h1>Fully Responsive</h1>
        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>
        <a href="#">Read More &rarr;</a>
    </div>
</div>
</body>
</html>