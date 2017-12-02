<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.exercise.paractice" bundle="${lang}"/></title>
</head>
<body>
<form action="" method="get" id="formUrl">
    <div class="row">
        <div class="span12">
            <ul class="thumbnails">
                <li class="span12">
                    <div class="thumbnail" id="result">
                        <br/>
                        <c:forEach items="${items.listResult}" var="item">
                            <p>
                                <b>${item.question}</b>
                            </p>
                            <c:if test="${item.image != null}">
                                <p>
                                    <img src="<c:url value="/repository/${item.image}"/>" width="300px" height="150px">
                                </p>
                            </c:if>
                            <c:if test="${item.audio != null}">
                                <p>
                                    <audio controls>
                                        <source src="<c:url value="/repository/${item.audio}"/>" type="audio/mpeg">
                                    </audio>
                                </p>
                            </c:if>
                            <p>
                                <input type="radio" name="answerUser" value="A"/>
                                ${item.option1}
                            </p>
                            <p>
                                <input type="radio" name="answerUser" value="B"/>
                                ${item.option2}
                            </p>
                            <p>
                                <input type="radio" name="answerUser" value="C"/>
                                ${item.option3}
                            </p>
                            <p>
                                <input type="radio" name="answerUser" value="D"/>
                                ${item.option4}
                            </p>
                            <input type="hidden" name="exerciseId" value="${item.exercise.exerciseId}" id="exerciseId"/>
                        </c:forEach>
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
        <input type="hidden" name="page" id="page" value="${items.page}"/>
        <input type="button" class="btn btn-info" value="Xem đáp án" id="btnConfirm"/>
        <input type="button" class="btn btn-info" value="Làm lại" id="btnAgain"/>
    </div>
</form>
<script>
    var totalPages = ${items.totalPages};
    var startPage = ${items.page};
    $(document).ready(function () {
        $('#btnConfirm').click(function () {
            if ($('input[name="answerUser"]:checked').length > 0) {
                $('#formUrl').submit();
            } else {
                alert("Ban chua chon dap an nao ca!");
            }
        });
        $('#btnAgain').click(function () {
            var exerciseId = $('#exerciseId').val();
            window.location = "/bai-tap-thuc-hanh.html?page="+startPage+"&exerciseId="+exerciseId+"";
        });
    });
    $('#pagination-demo').twbsPagination({
        totalPages: totalPages,
        startPage: startPage,
        visiblePages: 0,
        onPageClick: function (event, page) {
            if (page != startPage) {
                $('#page').val(page);
                var exerciseId = $('#exerciseId').val();
                window.location = "/bai-tap-thuc-hanh.html?page="+page+"&exerciseId="+exerciseId+"";
            }
        }
    });
    $('#formUrl').submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: '/ajax-bai-tap-dap-an.html',
            data: $(this).serialize(),
            dataType: 'html',
            success: function(res){
                $('#result').html(res);
            },
            error: function (res) {
                console.log(res);
            }
        });
    });
</script>
</body>
</html>
