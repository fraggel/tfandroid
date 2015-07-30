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
<%RequestHelper reqHelper=(RequestHelper)session.getAttribute("requestHelper");
ResourceBundle RB = ResourceBundle.getBundle("texts", new Locale(reqHelper.getLang()));

if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>
		<link rel="stylesheet" href="http://www.tfandroid.es/images/css/stylesM.css">
		<script src="http://www.tfandroid.es/images/js/scriptsM.js" type="text/javascript"></script>

		<%		
	
	}else{	
%>
<link rel="stylesheet" href="http://www.tfandroid.es/images/css/styles.css">
<script src="http://www.tfandroid.es/images/js/scripts.js" type="text/javascript"></script>

<%}
} %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TF Android Developers</title>
</head>
<body>
<div id="maincontainer">

<div id="leftsection"><div id="topsection"><div id="logo"><div class="innertube">
	<a href=""><img id="logoweb" /></a>
	<div id="banner">
		<a href="" target="_blank"><img id="bannerweb" />
	</div>
	<div id="languagesearchsocial">
		<form method="post" action="AdminServlet">
		<a href="AdminServlet?language=es" ><img src="http://www.tfandroid.es/images/EspanaBanderaIcono.png" width="40px"/></a><a href="AdminServlet?language=en"><img src="http://www.tfandroid.es/images/ReinoUnidoBanderaIcono.png" width="40px"/></a>          
		<input type="hidden" name="action" value="20"/>
			<%=RB.getString("home.search") %> <input type="text" name="textSearch" size="30"/>  
			<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.jpg" width="40px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.jpg" width="40px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.jpg" width="40px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.jpg" width="40px"/></a>
		</form> 
	</div>

<br/><br/>
</div>
</div>
</div>
</div>
<div id='cssmenu'>
<ul>
   <li class='<%=reqHelper.getAction()==0 ? "active " : ""%>'><a href='AdminServlet?action=0'><span>Marcas</span></a></li>
   <li class='<%=reqHelper.getAction()==1 ? "active " : ""%>'><a href='AdminServlet?action=1'><span>Modelos</span></a></li>
   <li class='<%=reqHelper.getAction()==2 ? "active " : ""%>'><a href='AdminServlet?action=2'><span>Noticias</span></a></li>
   <li class='<%=reqHelper.getAction()==3 ? "active " : ""%>'><a href='AdminServlet?action=3'><span>Banners</span></a></li>
   <li class='<%=reqHelper.getAction()==4 ? "active " : ""%>'><a href='AdminServlet?action=4'><span>Descargas</span></a></li>
   <li class='<%=reqHelper.getAction()==5 ? "active " : ""%>'><a href='AdminServlet?action=5'><span>Foro</span></a></li>
   <li class='<%=reqHelper.getAction()==6 ? "active " : ""%>'><a href='AdminServlet?action=6'><span>Promociones</span></a></li>
</ul>
</div>