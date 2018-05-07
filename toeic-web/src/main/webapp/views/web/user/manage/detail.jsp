<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="search" value="/quan-ly-tai-khoan.html"/>
<html>
<head>
    <title></title>
</head>
<body>
<div class="main">
    <div class="content">
        <form action="${search}" method="get" id="formUrl">
            <div class="contact-form">
                <div>
                        <span>
                            <input name="searchValue" type="text" class="textbox" value="${items.searchValue}"/>
                        </span>
                    <button class="btn btn-sm btn-success" id="btnSearch">
                        Tìm kiếm
                    </button>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Đề thi</th>
                    <th>Số câu nghe đúng</th>
                    <th>Số câu đọc đúng</th>
                    <th>Ngày làm bài thi</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${items.listResult}">
                    <tr>
                        <td>${item.examination.name}</td>
                        <td>${item.listenScore}</td>
                        <td>${item.readingScore}</td>
                        <td>${item.createdDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <input type="hidden" value="${items.urlType}" name="urlType"/>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#btnSearch").click(function () {
            $("#formUrl").submit();
        })
    });
</script>
</body>
</html>
