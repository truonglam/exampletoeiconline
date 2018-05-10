<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="randomExaminationQuestionUrl" value="/admin-random-examination-question.html"/>
<c:url var="requestUrl" value="/admin-examination-question-list.html"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.home" bundle="${lang}"/></title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Tạo câu hỏi tự động</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row" >
                <div class="col-xs-12">
                	<div class="table-btn-controls">
	                                    <div class="pull-right tableTools-container">
	                                        <div class="dt-buttons btn-overlap btn-group">	    
	                                        	<c:url var="importUrl" value="/admin-examination-question-import.html">
	                                        		<c:param name="id" value="${examinationId}"/>
	                                        		<c:param name="type" value="import-question-page"/>
	                                        	</c:url>                                        
	                                            <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" href="${importUrl}" data-toggle="tooltip" title="Import câu hỏi từ excel">
	                                                    <span>
	                                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
	                                                    </span>
	                                            </a>
	                                            <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" href="${randomExaminationQuestionUrl}?id=${examinationId}" data-toggle="tooltip" title="Tạo câu hỏi tự động">
	                                                    <span>
	                                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
	                                                    </span>
	                                            </a>
	                                            <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="deleteAll"
                                                    data-toggle="tooltip" title="Xóa tất cả các câu hỏi">
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
                 <display:table id="tableList" name="items.listResult" partialList="true" size="${items.totalItems}"
                                           pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}?id=${examinationId}"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">                                
                                <display:column property="audio" titleKey="audio"/>
                                <display:column property="image" titleKey="Hình ảnh"/>
                                <display:column property="question" titleKey="Câu hỏi"/>
                                <display:column property="paragraph" titleKey="Đoạn văn"/>
                                <display:column property="option1" titleKey="Câu hỏi 1"/>
                                <display:column property="option2" titleKey="Câu hỏi 2"/>
                                <display:column property="option3" titleKey="Câu hỏi 3"/>
                                <display:column property="option4" titleKey="Câu hỏi 4"/>
                                <display:column property="correctAnswer" titleKey="Đáp án đúng"/>           
                 </display:table>
             </div>
        </div>
    </div>
</div><!-- /.main-content -->
</body>
</html>