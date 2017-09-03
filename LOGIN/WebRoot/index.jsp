<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<s:head />
<sx:head />
<script type="text/javascript">
	function changeValidateCode(obj) {
		var timenow = new Date().getTime();
		obj.src = "rand.action?d=" + timenow;
	}
</script>
<!-- 点击验证码图片会调用的方法 -->
</head>

<body>
	<sx:tabbedpanel id="register_login" cssStyle="width: 1000px">
		<sx:div id="two" label="注册">
			<s:form action="register" method="post">
				<s:textfield name="name" label="*用户名" style="width:250;height:25 "></s:textfield>
				<s:password name="pwd" label="*密码" style="width:250;height:25"></s:password>
				<s:password name="confirm_pwd" label="*确认密码"
					style="width:250;height:25"></s:password>
				<s:textfield name="mail" label="*邮箱" style="width:250;height:25"></s:textfield>
				<s:textfield name="AUTH" label="验证码" style="width:250;height:25"></s:textfield>
				<img name="AUTH" src="rand.action"
					onclick="changeValidateCode(this)" title="点击图片刷新验证码" width=70px
					height=30px />

				<s:submit value="注册" style="width:250" align="center"></s:submit>
				<!--style才可以设置按钮长度，直接说width就不行 -->
			</s:form>
		</sx:div>

		<sx:div id="one" label="登陆">
			<s:form action="login" method="post">
				<s:textfield name="name1" label="用户名" style="width:250;height:25"></s:textfield>
				<s:password name="login_psd" label="密码" style="width:250;height:25"></s:password>
				<s:submit value="登陆" style="width:250;height:40"></s:submit>
			</s:form>
		</sx:div>

	</sx:tabbedpanel>
</body>
</html>