<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="confirmPoint" value="/ajax-xac-nhan-cham-diem-bai-tap.html"/>
<c:url var="submitAgain" value="/bai-tap-thuc-hanh.html"/>
<c:url var="ajaxViewResult" value="/ajax-bai-tap-dap-an.html"/>
<c:url var="checkPoint" value="/ajax-cham-diem-bai-tap.html"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.exercise.paractice" bundle="${lang}"/></title>
</head>
<body>
<form action="${confirmPoint}" method="get" id="formUrl">
	<div class="row">
		 <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
         </c:if>
	</div>
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
                            <input type="hidden" name="pojo.exerciseQuestionId" value="${item.exerciseQuestionId}" id="exerciseQuestionId"/>
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
        <c:if test="${items.page == items.totalPages}">
        	<input type="button" class="btn btn-info" value="Chấm điểm bài tập" id="btnCheckPoint"/>
        </c:if>
        <c:if test="${items.page != items.totalPages}">
        	<input type="button" class="btn btn-info" value="Xác nhận chấm điểm" id="btnConfirmCheckPoint"/>
        </c:if>
    </div>
</form>
<script>
    var totalPages = ${items.totalPages};
    var startPage = ${items.page};
    $(document).ready(function () {
        $('#btnConfirm').click(function () {
            if ($('input[name="answerUser"]:checked').length > 0) {
                $('#formUrl').attr('action', '${ajaxViewResult}');
                $('#formUrl').submit();
            } else {
                alert("Ban chua chon dap an nao ca!");
            }
        });
        $('#btnAgain').click(function () {
            var exerciseId = $('#exerciseId').val();
            window.location = "${submitAgain}?page="+startPage+"&exerciseId="+exerciseId+"";
        });
        $('#btnConfirmCheckPoint').click(function () {
            if ($('input[name="answerUser"]:checked').length > 0) {
                $('#formUrl').attr('action', '${confirmPoint}');
                $('#formUrl').submit();
            } else {
                alert("Ban chua chon dap an nao ca!");
            }
        });
        $('#btnCheckPoint').click(function () {
            if ($('input[name="answerUser"]:checked').length > 0) {
                $('#formUrl').attr('action', '${checkPoint}?urlType=check-point');
                $('#formUrl').submit();
            } else {
                alert("Ban chua chon dap an nao ca!");
            }
        });
    });
    $('#formUrl').submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: $(this).attr('action'),
            data: $(this).serialize(),
            dataType: 'html',
            success: function(res){
            	if (res == 'ajax-xac-nhan-cham-diem-bai-tap') {
            		var exerciseId = $('#exerciseId').val();
            		window.location = "${submitAgain}?page="+startPage+"&exerciseId="+exerciseId+"&message=confirm-point-success";
            	} else if (res == 'ajax-cham-diem-bai-tap') {
            		var exerciseId = $('#exerciseId').val();
            		window.location = "${submitAgain}?page="+startPage+"&exerciseId="+exerciseId+"&message=check-point-success";
            	}
                $('#result').html(res);
            },
            error: function (res) {           	
                console.log(res);
            }
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
                window.location = "${submitAgain}?page="+page+"&exerciseId="+exerciseId+"";
            }
        }
    });
</script>
</body>
</html>
