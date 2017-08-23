<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title><fmt:message key="label.user.management" bundle="${lang}"/></title>
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
                <li class="active"><fmt:message key="label.user.list" bundle="${lang}"/></li>
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
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold">
                                                <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                        </a>
                                        <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="deleteAll"
                                            data-toggle="tooltip" title="<fmt:message key='label.delete.all' bundle='${lang}'/>">
                                                 <span>
                                                    <i class="fa fa-trash-o bigger-110 pink"></i>
                                                </span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <fmt:bundle basename="ApplicationResources">
                            <display:table id="tableList" name="items.listResult" partialList="true" size="${items.totalItems}"
                                           pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">
                                <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell" headerClass="center select-cell">
                                    <fieldset>
                                        <input type="checkbox" name="checkList" id="checkbox_${tableList.userId}" value="${tableList.userId}" class="check-box-element"/>
                                    </fieldset>
                                </display:column>
                                <display:column property="name" titleKey="label.user.name" sortable="true" sortName="name"/>
                                <display:column property="fullName" titleKey="label.user.fullname" sortable="true" sortName="fullName"/>
                            </display:table>
                        </fmt:bundle>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
