<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Register</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<body>
<br/><br/><br/><br/><br/><br/><br/>
<div class="row">



        <form id="myform" action="#">

            <h1 style="text-align:center">register system</h1>
                <br>
            <h1 align="center">
                手机号：<input type="text"  id="tel" name="tel" placeholder="手机号码">
            </h1>

            <!-- 手机验证码模块 -->

            <h1 align="center">
            <div id="telDiv" class="form-group">
                短信验证码： <input type="text" id="code" name="code" placeholder="短信验证码">
                <input type="button" id="sendCode"   value="获取验证码"> <br/><br/>
                <%--<img alt="验证码" id="telcode" src="validateTel" style="display:none" />--%>
            </div>
            </h1>

            <!-- 图形验证码模块 -->
           <h1 align="center">
            <div id="imageDiv" style="display:none" >
                <input type="text" id="validateCode" class="form-control" name="validateCode">
                        <img alt="验证码" id="imagecode" src="validateImage"/>
                    <input type="button" id="yanzheng"  value="验证">
            </div>
           </h1>
            <!-- 密码及登陆 -->
            <h1 align="center">
               密码： <input type="password"  id="password" name="password" placeholder="密码">
            </h1>
            <h1 align="center">
                <input type="button" id="submit01" value="注册">
            </h1>
        </form>
    <h1 align="center">
        <a  href="tologin">点我登陆</a></h1>
    </div>
<script type="text/javascript" src="js/register.js"></script>

<script type="text/javascript">




</script>
</body>
</html>