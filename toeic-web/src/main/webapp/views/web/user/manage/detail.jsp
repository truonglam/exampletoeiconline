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
        	<c:if test="${items.urlType == 'ket-qua-thi'}">
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
	                        </c:forEach>
							<option value="">Chọn đề thi</option>
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
        	</c:if>
        	<c:if test="${items.urlType == 'ket-qua-bai-tap'}">
        		<div class="form-group">
	                <label for="exercise">Lọc theo bài tập:</label>
	                <select class="form-control" id="exercise" name="exerciseId">
	                    <c:if test="${empty selectedExerciseId}">
	                        <option value="">Chọn bài tập</option>
	                        <c:forEach var="item" items="${items.exercises}">
	                            <option value="${item.exerciseId}">${item.name}</option>
	                        </c:forEach>
	                    </c:if>
	                    <c:if test="${not empty selectedExerciseId}">
	                        <c:forEach var="item" items="${items.exercises}">
	                            <option value="${item.exerciseId}" <c:if test="${item.exerciseId eq selectedExerciseId}">selected="selected"</c:if>>
	                                ${item.name}
	                            </option>
	                        </c:forEach>
	                        <option value="-1">Chọn bài tập</option>
	                    </c:if>
	                </select>
            	</div>
	            <table class="table table-bordered">
	                <thead>
	                <tr>
	                    <th>Đề bài tập</th>
	                    <th>Số câu đúng / Tổng số câu</th>                  
	                    <th>Ngày làm bài tập</th>
	                </tr>
	                </thead>
	                <tbody>
	                <c:forEach var="item" items="${items.listResult}">
	                    <tr>
	                        <td>${item.exercise.name}</td>
	                        <td>${item.numberOfCorrect}/${item.total}</td>
	                        <td>${item.createdDate}</td>
	                    </tr>
	                </c:forEach>
	                </tbody>
	            </table>
        	</c:if>
            <input type="hidden" value="${items.urlType}" name="urlType"/>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#exercise").change(function(){
            $("#formUrl").submit();
        });
        $("#examination").change(function(){
            $("#formUrl").submit();
        });
    });
</script>
</body>
</html>
