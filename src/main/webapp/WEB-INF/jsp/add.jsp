<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加</title>
    <link rel="stylesheet" href="css/index.css" type="text/css" />
</head>

<body>
<form action="/addMessage" method="post">
    <table border="1" class="t1">
        <tr>
            <td colspan="2"><h1>添加信息</h1></td>
        </tr>
        <tr>
            <td>title:</td>
            <td><input  type="text" name="title"/></td>
        </tr>
        <tr>
            <td>message:</td>
            <td><input  type="text" name="message"/></td>
        </tr>
        <tr>
            <td>date:</td>
            <td><input type="text" name="date"></td>
        <tr>
            <td colspan="2">
                <input  type="submit" value="提交"/>
                <input  type="reset" value="清空"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>