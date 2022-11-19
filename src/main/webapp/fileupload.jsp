<%--
  Created by IntelliJ IDEA.
  User: jeongwon
  Date: 2022/11/19
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import ="java.io.File" %>
<%@ page import ="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<%
    String filename = "";
    int sizeLimit = 15 * 1024 * 1024;

    String realPath = request.getServletContext().getRealPath("upload");
    File dir = new File(realPath);
    if (!dir.exists()) dir.mkdirs();

    MultipartRequest multpartRequest = null;
    multpartRequest = new MultipartRequest(request, realPath,
            sizeLimit, "utf-8",new DefaultFileRenamePolicy());
    filename = multpartRequest.getFilesystemName("photo");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>`
<form method = ‘post’ action = ‘fileupload.jsp’ enctype = “multipart/form-data”>
  <input type = ‘file’ name = ‘photo’>
  <input type = ‘submit’ value = ‘upload’>
</form>
</body>
</html>
