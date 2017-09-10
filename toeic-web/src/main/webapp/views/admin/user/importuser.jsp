<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="importExcel" value="/admin-user-import.html"/>
<html>
<head>
    <title><fmt:message key="label.user.import.excel" bundle="${lang}"/></title>
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
                <li><fmt:message key="label.user.list" bundle="${lang}"/></li>
                <li class="active"><fmt:message key="label.user.import.excel" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${messageResponse!=null}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form action="${importExcel}" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="col-sm-12">
                                    <input type="file" name="file"/>
                                    <br/>
                                    <%--<button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="validateData">
                                        <fmt:message key="label.file.validate.import" bundle="${lang}"/>
                                    </button>--%>
                                    <button type="submit" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold">
                                       Read file excel
                                    </button>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="urlType" value="read_excel"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
