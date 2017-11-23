<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>相册管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cms/picture/">相册列表</a></li>
		<li class="active"><a href="${ctx}/cms/picture/form?id=${album.id}">相册<shiro:hasPermission name="album:album:edit">${not empty cmsAlbum.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="album:album:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="album" action="${ctx}/cms/picture/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">栏目编号：</label>
			<div class="controls">
				<form:input path="categoryId" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<%--<div class="control-group">
			<label class="control-label">图片地址  一个数组：</label>
			<div class="controls">
				<form:input path="imageAddress" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>--%>
		<div class="control-group">
			<label class="control-label">图片地址:</label>
			<div class="controls">
				<input type="hidden" id="imageAddress" name="imageAddress"  value="${album.imageAddress}" />
				<%--<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge" />--%>
				<sys:ckfinder input="imageAddress" type="images" uploadPath="/cms" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">相册名称：</label>
			<div class="controls">
				<form:input path="albumName" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">描述信息：</label>
			<div class="controls">
				<form:input path="description" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">点击量：</label>
			<div class="controls">
				<form:input path="hits" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="album:album:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>