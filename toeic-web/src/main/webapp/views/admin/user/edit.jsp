<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <c:if test="${not empty item.pojo.userId}">
                <h4 class="modal-title"><fmt:message key="label.user.edit" bundle="${lang}"/></h4>
            </c:if>
            <c:if test="${empty item.pojo.userId}">
                <h4 class="modal-title"><fmt:message key="label.user.add" bundle="${lang}"/></h4>
            </c:if>
        </div>
        <div class="modal-body">

        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
</body>
</html>
