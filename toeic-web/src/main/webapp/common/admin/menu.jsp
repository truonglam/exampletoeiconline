<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/admin-guideline-listen-list.html" var="listenGuidelineListUrl">
    <c:param name="urlType" value="url_list"/>
</c:url>
<c:url var="closestMethodUrl" value="/admin-closest-method.html">
    <c:param name="urlType" value="url_closest_method"/>
</c:url>
<c:url var="findtMethodUrl" value="/admin-find-method.html">
    <c:param name="urlType" value="url_find_method"/>
</c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                <fmt:message key="label.guideline.listen" bundle="${lang}"/>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href="${listenGuidelineListUrl}">
                        <i class="menu-icon fa fa-caret-right"></i>
                        <fmt:message key="label.guideline.listen.list" bundle="${lang}"/>
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-list">
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                <fmt:message key="label.jquery.tutorial" bundle="${lang}"/>
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href="${closestMethodUrl}">
                        <i class="menu-icon fa fa-caret-right"></i>
                        <fmt:message key="label.jquery.closest.method" bundle="${lang}"/>
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            <ul class="submenu">
                <li class="">
                    <a href="${findtMethodUrl}">
                        <i class="menu-icon fa fa-caret-right"></i>
                        <fmt:message key="label.jquery.find.method" bundle="${lang}"/>
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>