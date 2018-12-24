<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" href="css/index.css" type="text/css" />
</head>

<body>
<form action="/editMessage" method="post">
    <table border="1" class="t1">
        <tr>
            <td colspan="2"><h1>修改信息</h1></td>
        </tr>

<input type="hidden" name="id" value="${mes.id}">
        <tr>
            <td>title:</td>
            <td><input  type="text" name="title" value="${mes.title}"/></td>
        </tr>
        <tr>
            <td>message:</td>
            <td><input  type="text" name="message" value="${mes.message}"/></td>
        </tr>
        <tr>
            <td>date:</td>
            <td><input type="text" name="date" value="${mes.date}"></td>

        <tr>

            <td colspan="2">
                <input  type="submit" value="提交"/>

            </td>
        </tr>
    </table>
</form>
</body>
</html>