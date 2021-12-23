<%--
  Created by IntelliJ IDEA.
  User: King.LF
  Date: 2019/2/14
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String base = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+base+"/";%>
<html>
<head>
    <title>登录</title>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="keywords" content="scclui框架">
    <meta name="description" content="scclui为轻量级的网站后台管理系统模版。">

    <link rel="stylesheet" href="common/core/layui/css/layui.css">
    <link rel="stylesheet" href="common/core/layui/css/layui-icon.css">
    <link rel="stylesheet" href="common/core/css/sccl.css">
</head>
<body class="login-bg">
<div class="login-box">
    <header>
        <h1>框架后台管理系统</h1>
    </header>
    <div class="login-main">
        <form action="login" class="layui-form" method="post">
            <input name="__RequestVerificationToken" type="hidden" value="">
            <div class="layui-form-item">
                <label class="login-icon">
                    <i class="layui-icon layui-icon-username"></i>
                </label>
                <input type="text" name="loginAccount" lay-verify="loginAccount" autocomplete="off" placeholder="这里输入登录名"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="login-icon">
                    <i class="layui-icon layui-icon-password"></i>
                </label>
                <input type="password" name="loginPass" lay-verify="loginPass" autocomplete="off" placeholder="这里输入密码"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="pull-left login-remember">
                    <label>记住帐号？</label>

                    <input type="checkbox" name="rememberMe" value="true" lay-skin="switch" title="记住帐号">
                    <div class="layui-unselect layui-form-switch"><i></i></div>
                </div>
                <div class="pull-right">
                    <button class="layui-btn layui-btn-primary" lay-submit="" lay-filter="login">
                        <i class="layui-icon"></i> 登录
                    </button>
                </div>
                <div class="clear"></div>
            </div>
        </form>
    </div>
    <footer>
        <p>limbo © www.limbo.top</p>
    </footer>
</div>
<script type="text/html" id="code-temp">
    <div class="login-code-box">
        <input type="text" class="layui-input" id="code"/>
        <img id="valiCode" src="/manage/validatecode?v=636150612041789540" alt="验证码"/>
    </div>
</script>
<script src="common/core/layui/layui.js"></script>
<script>
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form;

        form.verify({
            loginAccount: function (value) {
                if (value == '')
                    return '请输入用户名';
            },
            loginPass: function (value) {
                if (value == '')
                    return '请输入密码';
            }
        });

        var errorCount = 0;

        form.on('submit(login)', function (data) {
            form.submit();

        });
    });

</script>
</body>
</html>
