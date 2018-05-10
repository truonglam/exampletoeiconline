<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/admin-examination-edit.html"/>
<html>
<head>
    <title><fmt:message key="label.examination.edit" bundle="${lang}"/></title>
    <style>
        .error{
            color: red;
        }
    </style>
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
                <li class="active"><fmt:message key="label.examination.edit" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form action="${formUrl}" method="post" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên đề thi</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.name" id="name" value="${item.pojo.name}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mã đề thi</label>
                            <div class="col-sm-9">
                                <%--<c:if test="${not empty item.pojo.code}">
                                    <c:set var="content" value="${item.pojo.code}"/>
                                </c:if>--%>
                                <input type="text" name="pojo.code" id="code" value="${item.pojo.code}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="submit" class="btn btn-white btn-warning btn-bold" value="<fmt:message key="label.done" bundle="${lang}"/>"/>
                            </div>
                        </div>
                        <c:if test="${not empty item.pojo.examinationId}">
                            <input type="hidden" name="pojo.examinationId" value="${item.pojo.examinationId}"/>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var examinationId = '';
    <c:if test="${not empty item.pojo.examinationId}">
    examinationId = ${item.pojo.examinationId};
    </c:if>
    function validateData() {
        $('#formEdit').validate({
            ignore: [],
            rules: [],
            messages: []
        });
        $("#title").rules( "add", {
            required: true,
            messages: {
                required: '<fmt:message key="label.empty" bundle="${lang}"/>'
            }
        });
        if (examinationId == '') {
            $("#uploadImage").rules( "add", {
                required: true,
                messages: {
                    required: '<fmt:message key="label.empty" bundle="${lang}"/>'
                }
            });
        }

    }
    function readURL(input, imageId) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageId).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</body>
</html>
