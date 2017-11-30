<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.exercise.paractice" bundle="${lang}"/></title>
</head>
<body>
<div class="row">
    <div class="span12">
        <ul class="thumbnails">
            <li class="span12">
                <div class="thumbnail">
                    <br/>
                    <p>
                        TIÊU ĐỀ CÂU HỎI
                    </p>
                    <p>
                        <input type="radio" name="radio" value="A"/>
                        ĐÁP ÁN 1
                    </p>
                    <p>
                        <input type="radio" name="radio" value="B"/>
                        ĐÁP ÁN 2
                    </p>
                    <p>
                        <input type="radio" name="radio" value="C"/>
                        ĐÁP ÁN 3
                    </p>
                    <p>
                        <input type="radio" name="radio" value="D"/>
                        ĐÁP ÁN 4
                    </p>
                </div>
            </li>
        </ul>
    </div>
</div>
<!--Pagination-->
<div class="row">
    <div class="span12">
        <ul id="pagination-demo" class="pagination-sm"></ul>
    </div>
</div>
<script>
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
