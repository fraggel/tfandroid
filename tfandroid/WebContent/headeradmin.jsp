<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,
                 java.net.*,
                 java.util.*,
                 javax.servlet.*,
                 es.tfandroid.utils.RequestHelper,
                 es.tfandroid.beans.*" %>

<html>
<%RequestHelper reqHelper=(RequestHelper)request.getAttribute("requestHelper");
ResourceBundle RB = ResourceBundle.getBundle("texts", new Locale(reqHelper.getLang()));
%>
<link rel="stylesheet" href="http://www.tfandroid.es/images/css/styles.css">
<script src="http://www.tfandroid.es/images/js/scripts.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TF Android Developers</title>
</head>
<body>
<div id="maincontainer">

<div>
   	<p style="padding-right:70px;"><a href='AdminServlet?action=0'><span>Marcas</span></a></p>
   	<p style="padding-right:70px;"><a href='AdminServlet?action=1'><span>Modelos</span></a></p>
   	<p style="padding-right:70px;"><a href='AdminServlet?action=2'><span>Noticias</span></a></p>
   	<p style="padding-right:70px;"><a href='AdminServlet?action=3'><span>Banners</span></a></p>
	<p style="padding-right:70px;"><a href='AdminServlet?action=4'><span>Descargas</span></a></p>
	<p style="padding-right:70px;"><a href='AdminServlet?action=5'><span>Foro</span></a></p>
	<p style="padding-right:70px;"><a href='AdminServlet?action=6'><span>Promociones</span></a></p>

</div>