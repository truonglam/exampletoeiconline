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
            <div class="form-group">
                <label for="examination">Lọc theo đề thi:</label>
                <select class="form-control" id="examination" name="examinationCode">
                    <c:if test="${empty selectedCode}">
                        <option value="">Chọn đề thi</option>
                        <c:forEach var="item" items="${items.examinations}">
                            <option value="${item.code}">${item.name}</option>
                        </c:forEach>
                    </c:if>
                    <c:if test="${not empty selectedCode}">
                        <c:forEach var="item" items="${items.examinations}">
                            <option value="${item.code}" <c:if test="${item.code eq selectedCode}">selected="selected"</c:if>>
                                ${item.name}
                            </option>
                            <option value="">Chọn đề thi</option>
                        </c:forEach>
                    </c:if>
                </select>
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
        $("#examination").change(function(){
            $("#formUrl").submit();
        });
    });
</script>
</body>
</html>
