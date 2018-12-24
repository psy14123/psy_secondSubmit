<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>消息</title>


    <style type="text/css">
        table {
            border: 1px solid pink;
            margin: 0 auto;
        }

        td{
            width: 150px;
            border: 1px solid pink;
            text-align: center;
        }
    </style>

</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>title</td>
        <td>message</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="temp">
        <tr>
            <td>${temp.id}</td>
            <td>${temp.title }</td>
            <td>${temp.message }</td>
            <td><a href="toEditMessage?id=${temp.id}">编辑</a></td>
            <td><a href="deleteMessage?id=${temp.id}">删除</a></td>
        </tr>
    </c:forEach>

    <tr>
        <input type="button" class="btn btn-primary btn-lg btn-block" value="添加"
               onclick="location.href='toAddMessage'">
    </tr>
</table>
</body>
</html>