<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//    out.println(basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>login</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>

<h1 style="text-align:center">login system</h1>
<hr><br>

        <form action="/tologin">
                <h1 align="center">
                手机号：<input type="text" class="form-control" id="tel" name="tel" placeholder="手机号码">
                </h1>

                <h1 align="center">
                密码：<input type="password" class="form-control" id="password" name="password" placeholder="密码">
                </h1>
                <p class="help-block" align="center"><a href="toregister">注册</a></p>
            <h1 align="center">
            <input type="button"   id="submit001" value="登陆"/>
            </h1>
        </form>
    </div>

</div>


<script>


    function func() {
        //验证用户是否已经注册过
        var tel = $("#tel").val();//获取表单元素值
        var password = $("#password").val();

        var tel = document.getElementById('tel').value;
        if(tel==""){
            alert("手机号不能为空！");
            //window.location.href="register.jsp";
            return false;
        }

        if (!(/^1[34578]\d{9}$/.test(tel))) {
            alert("手机号输入错误");
            return false;
        }
        if(password=="")
        {
            alert("密码不能为空！");
            return false;
        }
        if(password.length<4){
            alert("密码不能少于4位！");
            return false;
        }
        return true;
    }

    $("#submit001").on("click", function() {
        if (!func()) {
            console.log("!!!!!!");
            return false;
        }
        var tel = $("#tel").val();//获取表单元素值
        var password = $("#password").val();
        var data = {
            tel : tel,
            password : password
        };
        $.ajax({
            type : "POST",
            url : "login",
            data : data,
            dataType : 'json',
            success : function(msg) {
                if ("00"==msg.errorCode) {
                    console.log("success");
                    location.href = "/toMessage";
                } else if("11"==msg.errorCode) {
                    alert("该手机号码不存在！");
                    console.log("该手机号码不存在！");
                    return false;
                }else if("22"==msg.errorCode){
                    alert("密码输入错误，错误输入三次后您的账户将会被锁定！");
                    return false;
                }
                else if("33"==msg.errorCode){
                    alert("您由于错误登陆次数太多，系统已将您的账户锁定，请在三分钟后重新登录！");
                    return false;
                }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
            }

        });

    });

</script>
</body>
</html>