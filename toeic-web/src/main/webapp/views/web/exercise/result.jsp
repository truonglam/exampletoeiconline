<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
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
            <input type="radio" name="answerUser" value="A" ${items.answerUser == 'A' ? 'checked':''}/>
                ${item.option1}
            <c:if test="${items.answerUser != null}">
                <c:if test="${(item.correctAnswer == 'A') || (item.correctAnswer == 'A' && items.answerUser == 'A')}">
                    <img src="<c:url value="/template/image/correct.png"/>">
                </c:if>
                <c:if test="${(items.answerUser == 'A') && (items.checkAnswer == true)}">
                    <img src="<c:url value="/template/image/incorrect.png"/>">
                </c:if>
            </c:if>
        </p>
        <p>
            <input type="radio" name="answerUser" value="B" ${items.answerUser == 'B' ? 'checked':''}/>
                ${item.option2}
            <c:if test="${items.answerUser != null}">
                <c:if test="${(item.correctAnswer == 'B') || (item.correctAnswer == 'B' && items.answerUser == 'B')}">
                    <img src="<c:url value="/template/image/correct.png"/>">
                </c:if>
                <c:if test="${(items.answerUser == 'B') && (items.checkAnswer == true)}">
                    <img src="<c:url value="/template/image/incorrect.png"/>">
                </c:if>
            </c:if>
        </p>
        <p>
            <input type="radio" name="answerUser" value="C" ${items.answerUser == 'C' ? 'checked':''}/>
                ${item.option3}
            <c:if test="${items.answerUser != null}">
                <c:if test="${(item.correctAnswer == 'C') || (item.correctAnswer == 'C' && items.answerUser == 'C')}">
                    <img src="<c:url value="/template/image/correct.png"/>">
                </c:if>
                <c:if test="${(items.answerUser == 'C') && (items.checkAnswer == true)}">
                    <img src="<c:url value="/template/image/incorrect.png"/>">
                </c:if>
            </c:if>
        </p>
        <p>
            <input type="radio" name="answerUser" value="D" ${items.answerUser == 'D' ? 'checked':''}/>
                ${item.option4}
            <c:if test="${items.answerUser != null}">
                <c:if test="${(item.correctAnswer == 'D') || (item.correctAnswer == 'D' && items.answerUser == 'D')}">
                    <img src="<c:url value="/template/image/correct.png"/>">
                </c:if>
                <c:if test="${(items.answerUser == 'D') && (items.checkAnswer == true)}">
                    <img src="<c:url value="/template/image/incorrect.png"/>">
                </c:if>
            </c:if>
        </p>
        <input type="hidden" name="exerciseId" value="${item.exercise.exerciseId}" id="exerciseId"/>
    </c:forEach>
</body>
</html>
