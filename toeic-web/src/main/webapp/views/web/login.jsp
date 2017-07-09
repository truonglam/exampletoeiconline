<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:url var="formUrl" value="/login.html"/>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div id="login-box" class="login-box visible widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header blue lighter bigger">
                <i class="ace-icon fa fa-coffee green"></i>
                <fmt:message key="label.test" bundle="${lang}"/>
            </h4>
            <div class="space-6"></div>
            <form action="${formUrl}" method="post">
                <fieldset>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <label class="block clearfix">
							<span class="block input-icon input-icon-right">
									    <input type="text" class="form-control" placeholder="Username" name="pojo.name"/>
							            <i class="ace-icon fa fa-user"></i>
							</span>
                    </label>
                    <label class="block clearfix">
							<span class="block input-icon input-icon-right">
										<input type="password" class="form-control" placeholder="Password" name="pojo.password"/>
										<i class="ace-icon fa fa-lock"></i>
							</span>
                    </label>
                    <div class="space"></div>
                    <div class="clearfix">
                        <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-110">Login</span>
                        </button>
                    </div>
                    <div class="space-4"></div>
                </fieldset>
            </form>
        </div><!-- /.widget-main -->
    </div><!-- /.widget-body -->
</div><!-- /.login-box -->
</body>
</html>
