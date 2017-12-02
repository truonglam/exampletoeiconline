<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="urlList" value="/danh-sach-bai-tap.html"/>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="${urlList}" method="get" id="formUrl">
    <div class="wrap">
        <div class="main">
            <div class="content">
                <div class="col span_2_of_3">
                    <div class="contact-form">
                        <div>
                                <span>
                                    <input name="pojo.name" type="text" class="textbox" value="${items.pojo.name}"/>
                                </span>
                        </div>
                        <div>
                            <button class="btn btn-sm btn-success">
                                <fmt:message key="label.search" bundle="${lang}"/>
                            </button>
                        </div>
                    </div>
                </div>
                <c:forEach var="item" items="${items.listResult}">
                    <div class="image group">
                        <div class="grid news_desc">
                            <h3>${item.name}</h3>
                            <c:url value="/bai-tap-thuc-hanh.html" var="detailUrl">
                                <c:param name="exerciseId" value="${item.exerciseId}"/>
                                <c:param name="page" value="1"/>
                            </c:url>
                            <h4><span><a href="${detailUrl}">Làm bài tập nghe</a></span></h4>
                        </div>
                    </div>
                </c:forEach>
                <ul id="pagination-demo" class="pagination-sm"></ul>
            </div>
        </div>
    </div>
    <input type="hidden" id="page" name="page"/>
    <input type="hidden" name="pojo.type" value="${items.pojo.type}"/>
</form>
<script type="text/javascript">
    var totalPages = ${items.totalPages};
    var startPage = ${items.page};
    var visiblePages = ${items.maxPageItems};
    $(document).ready(function () {
    });
    $(function () {
        var obj = $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            startPage: startPage,
            visiblePages: visiblePages,
            onPageClick: function (event, page) {
                if (page != startPage) {
                    $('#page').val(page);
                    $('#formUrl').submit();
                }
            }
        });
    });
</script>
</body>
</html>