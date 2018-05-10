<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="requestUrl" value="/admin-examination-list.html"/>
<c:url value="/admin-examination-edit.html" var="listenGuidelineEditUrl">
    <c:param name="urlType" value="url_edit"/>
</c:url>
<c:url var="formUrl" value="/admin-examination-list.html"/>
<c:url var="importUrl" value="/admin-exam-import.html">
    <c:param name="urlType" value="show_import_exam"/>
</c:url>
<html>
<head>
    <title><fmt:message key="label.examination.list" bundle="${lang}"/></title>
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
                <li class="active"><fmt:message key="label.examination.list" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--<a href="${listenGuidelineEditUrl}" type="button">Thêm bài hd</a>--%>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form action="${formUrl}" method="get" id="formUrl">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="widget-box table-filter">
                                    <div class="widget-header">
                                        <h4 class="widget-title"><fmt:message key="label.search" bundle="${lang}"/></h4>
                                        <div class="widget-toolbar">
                                            <a href="#" data-action="collapse">
                                                <i class="ace-icon fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"><fmt:message key="label.examination.name" bundle="${lang}"/></label>
                                                    <div class="col-sm-8">
                                                        <div class="fg-line">
                                                            <input type="text" value="${items.pojo.name}" class="form-control input-sm" name="pojo.name"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"></label>
                                                    <div class="col-sm-8">
                                                        <button id="btnSearch" class="btn btn-sm btn-success">
                                                            <fmt:message key="label.search" bundle="${lang}"/>
                                                            <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <c:url var="addUrl" value="/admin-examination-edit.html">
                                                <c:param name="urlType" value="url_edit"/>
                                            </c:url>
                                            <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" href="${addUrl}" data-toggle="tooltip" title="Thêm đề thi">
                                                    <span>
                                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                    </span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <fmt:bundle basename="ResourcesBundle">
                                <display:table id="tableList" name="items.listResult" partialList="true" size="${items.totalItems}"
                                               pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}"
                                               class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                               style="margin: 3em 0 1.5em;">
                                    <display:column property="name" titleKey="label.examination.name" sortable="true" sortName="name"/>
                                    <display:column property="code" titleKey="label.examination.code" sortable="true" sortName="code"/>

                                    <display:column headerClass="col-actions" titleKey="label.action">
                                        <c:url var="editUrl" value="/admin-examination-edit.html">
                                            <c:param name="urlType" value="url_edit"/>
                                            <c:param name="pojo.examinationId" value="${tableList.examinationId}"/>
                                        </c:url>                                        
                                        <a class="btn btn-sm btn-primary btn-edit" href="${editUrl}" data-toggle="tooltip" title="Cập nhật đề thi"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                        <c:url var="examinationQuestionList" value="/admin-examination-question-list.html?id=${tableList.examinationId}"/>
                                        <%-- <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" href="${examinationQuestionList}" data-toggle="tooltip" title="Câu hỏi đề thi">
                                                <span>
                                                    <i class="fa fa-file" aria-hidden="true"></i>
                                                </span>
                                        </a> --%>
                                        <a class="btn btn-sm btn-primary btn-edit" href="${examinationQuestionList}" data-toggle="tooltip" title="Câu hỏi đề thi"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>                                    
                                    </display:column>
                                </display:table>
                            </fmt:bundle>
                        </div>
                        <input type="hidden" name="urlType" id="urlType" value="url_list"/>
                        <input type="hidden" name="crudaction" id="crudaction"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
         $('#btnSearch').click(function () {
             $('#formUrl').submit();
         });
    });
    function warningBeforeDelete() {
        showAlertBeforeDelete(function () {
            $('#crudaction').val('redirect_delete');
            $('#formUrl').submit();
        });
    }
</script>
</body>
</html>
