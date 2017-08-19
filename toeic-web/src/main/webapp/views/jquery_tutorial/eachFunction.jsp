<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                </li>
                <li class="active"><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">

                </div>
            </div>
        </div>
    </div>
</div>
<script>
    //var arr = [7,9,10,4,17];
    var temp = [];
    <c:if test="${not empty listDemo}">
        <c:forEach var="item" items="${listDemo}">
            temp.push('${item.name}');
        </c:forEach>
    </c:if>
    $(document).ready(function () {
        //using each print value and position of value
        /*$.each(arr, function (index, value) {
            console.log("Value: "+value+" - position: "+index);
        });*/
        $.each(temp, function (index, name) {
            console.log("Name: "+name+" - position: "+index);
        });
    });
</script>
</body>
</html>
