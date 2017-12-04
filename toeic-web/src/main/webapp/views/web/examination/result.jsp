<%@ page import="vn.myclass.core.web.common.WebConstant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="PHOTO" value="<%=WebConstant.EXAMINATION_TYPE_PHOTO%>"/>
<c:set var="QUESTION_RESPONSE" value="<%=WebConstant.EXAMINATION_TYPE_QUESTION_RESPONSE%>"/>
<c:set var="SINGLE_PASSAGE" value="<%=WebConstant.EXAMINATION_TYPE_SINGLE_PASSAGE%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.home" bundle="${lang}"/></title>
</head>
<body>
    <div class="image group">
        <div class="grid news_desc">
            <div style="overflow: auto; height: 500px" >
                <c:forEach items="${items.listResult}" var="item">
                    <c:if test="${item.number != null}">
                        <b>${item.number}.${item.question}</b>
                    </c:if>
                    <c:if test="${item.number == null}">
                        <b>${item.question}</b>
                    </c:if>
                    <c:choose>
                        <c:when test="${item.type == PHOTO}">
                            <p>
                                <img src="<c:url value="/repository/${item.image}"/>" width="300px" height="150px">
                            </p>
                            <p>
                                <audio controls>
                                    <source src="<c:url value="/repository/${item.audio}"/>" type="audio/mpeg">
                                </audio>
                            </p>
                        </c:when>
                        <c:when test="${item.type == QUESTION_RESPONSE}">
                            <p>
                                <audio controls>
                                    <source src="<c:url value="/repository/${item.audio}"/>" type="audio/mpeg">
                                </audio>
                            </p>
                        </c:when>
                        <c:when test="${item.type == SINGLE_PASSAGE}">
                            <p>
                                    ${item.paragraph}
                            </p>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${empty item.paragraph}">
                        <p>
                            <c:if test="${item.correctAnswer == 'A'}">
                                <img src="<c:url value="/template/image/correct.png"/>">
                            </c:if>
                            ${item.option1}
                        </p>
                        <p>
                            <c:if test="${item.correctAnswer == 'B'}">
                                <img src="<c:url value="/template/image/correct.png"/>">
                            </c:if>
                            ${item.option2}
                        </p>
                        <p>
                            <c:if test="${item.correctAnswer == 'C'}">
                                <img src="<c:url value="/template/image/correct.png"/>">
                            </c:if>
                            ${item.option3}
                        </p>
                        <p>
                            <c:if test="${item.correctAnswer == 'D'}">
                                <img src="<c:url value="/template/image/correct.png"/>">
                            </c:if>
                            ${item.option4}
                        </p>
                    </c:if>
                </c:forEach>
            </div>
            <br/>
            <a href="/danh-sach-bai-thi.html" class="btn btn-primary" type="button">Trở lại danh sách</a>
        </div>
        <div class="grid images_3_of_1">
            <div style="overflow: auto; height: 500px" >
                <c:forEach var="item" items="${items.listResult}">
                    <c:if test="${not empty item.correctAnswer}">
                        ${item.number}.&nbsp;&nbsp;&nbsp;
                        A <input type="radio" name="answerUser[${item.examinationQuestionId}]" value="A" ${item.answerUser == 'A' ? 'checked':''}>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        B <input type="radio" name="answerUser[${item.examinationQuestionId}]" value="B" ${item.answerUser == 'B' ? 'checked':''}>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        C <input type="radio" name="answerUser[${item.examinationQuestionId}]" value="C" ${item.answerUser == 'C' ? 'checked':''}>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        D <input type="radio" name="answerUser[${item.examinationQuestionId}]" value="D" ${item.answerUser == 'D' ? 'checked':''}>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <br/>
                        <br/>
                    </c:if>
                </c:forEach>
            </div>
            <br/>
            <a href="/bai-thi-thuc-hanh.html?examinationId=${items.examinationId}" class="btn btn-primary" type="button">Làm lại bài thi</a>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Xem kết quả</button>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Xem kết quả thi</h4>
                </div>
                <div class="modal-body">
                    <p>Phần nghe: ${items.listenScore}</p>
                    <p>Phần đọc: ${items.readingScore}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript">
    $(document).ready(function () {

    });
</script>
</body>
</html>
