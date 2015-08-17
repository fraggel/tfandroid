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
<head>
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<%RequestHelper reqHelper=(RequestHelper)request.getAttribute("requestHelper");
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
<%if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>
		<body onclick="ocultaMenuClick();">
		<%		
	
	}else{	
%>
<body >
<%}
} %>


<div id="aa">
<%if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>
				<div id="superior">
				<div id="language">
						<a href="ControlServlet?language=es" ><img src="http://www.tfandroid.es/images/EspanaBanderaIcono.png" width="25px"/></a><a href="ControlServlet?language=en"><img src="http://www.tfandroid.es/images/ReinoUnidoBanderaIcono.png" width="25px"/></a><a href="ControlServlet?action=20"><img src="http://www.tfandroid.es/images/lupa.png" width="25px"/></a>
				</div>
				<div id="social">
						<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.png" width="25px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.png" width="25px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.png" width="25px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.png" width="25px"/></a>
				</div>
				</div>
	<%}else{	
%>
<div id="superior">
<div id="language">
		<a href="ControlServlet?language=es" ><img src="http://www.tfandroid.es/images/EspanaBanderaIcono.png" width="25px"/></a><a href="ControlServlet?language=en"><img src="http://www.tfandroid.es/images/ReinoUnidoBanderaIcono.png" width="25px"/></a><a href="ControlServlet?action=20"><img src="http://www.tfandroid.es/images/lupa.png" width="25px"/></a>
</div>
<div id="social">
		<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.png" width="25px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.png" width="25px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.png" width="25px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.png" width="25px"/></a>
</div>
</div>

<%}
} %>

<div id="hr2"><hr/></div>
<div id="superior">
<%if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>
		<div id="logo"><a href="ControlServlet?action=0"><img src="http://www.tfandroid.es/images/logonuevo.png"/></a></div>
		
				<div id="menuBtn"><img src="http://www.tfandroid.es/images/menu.png" width="100px" onclick="menuClick();"/></div>
				
	<%}else{	
%>
<div id="logo"><a href="ControlServlet?action=0"><img src="http://www.tfandroid.es/images/logonuevo.png"/></a></div>

<div id="menu">
<div id='cssmenu'>
<ul>
   <li class='<%=reqHelper.getAction()==0 ? "active " : ""%> last'><a href='ControlServlet?action=0'><span><%=RB.getString("menu.home") %></span></a></li>
   <li class='<%=reqHelper.getAction()==1 ? "active " : ""%>'><a href='ControlServlet?action=1'><span><%=RB.getString("menu.about") %></span></a></li>
   <li class='<%=reqHelper.getAction()==3 ? "active " : ""%>'><a href='ControlServlet?action=3'><span><%=RB.getString("menu.news") %></span></a></li>
   <li class='<%=reqHelper.getAction()==4 ? "active " : ""%>'><a href='ControlServlet?action=4'><span><%=RB.getString("menu.downloads") %></span></a></li>
   
   <li class='<%=reqHelper.getAction()==5 ? "active " : ""%>'><a href='http://foro.tfandroid.es' target="_blank" ><span><%=RB.getString("menu.forum") %></span></a></li>
   <li class='<%=reqHelper.getAction()==6 ? "active " : ""%>'><a href='ControlServlet?action=6'><span><%=RB.getString("menu.staff") %></span></a></li>
   <li class='<%=reqHelper.getAction()==7 ? "active " : ""%> last'><a href='ControlServlet?action=7'><span><%=RB.getString("menu.contact") %></span></a></li>
</ul>
</div>
</div>

<%}
} %>

</div>
<%if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>
<div id="hrMenu"><hr/></div>
<div id="myMenu">
				<ul>
				   <li class='<%=reqHelper.getAction()==0 ? "active " : ""%> last'><a href='ControlServlet?action=0'><span><%=RB.getString("menu.home") %></span></a></li>
				   <li class='<%=reqHelper.getAction()==1 ? "active " : ""%>'><a href='ControlServlet?action=1'><span><%=RB.getString("menu.about") %></span></a></li>
				   <li class='<%=reqHelper.getAction()==3 ? "active " : ""%>'><a href='ControlServlet?action=3'><span><%=RB.getString("menu.news") %></span></a></li>
				   <li class='<%=reqHelper.getAction()==4 ? "active " : ""%>'><a href='ControlServlet?action=4'><span><%=RB.getString("menu.downloads") %></span></a></li>
				   
				   <li class='<%=reqHelper.getAction()==5 ? "active " : ""%>'><a href='http://foro.tfandroid.es' target="_blank" ><span><%=RB.getString("menu.forum") %></span></a></li>
				   <li class='<%=reqHelper.getAction()==6 ? "active " : ""%>'><a href='ControlServlet?action=6'><span><%=RB.getString("menu.staff") %></span></a></li>
				   <li class='<%=reqHelper.getAction()==7 ? "active " : ""%> last'><a href='ControlServlet?action=7'><span><%=RB.getString("menu.contact") %></span></a></li>
				</ul>
				</div>
				<br/>
				<div id="hr"><hr/></div>
				<div id="banner">
				<center><img src="http://www.tfandroid.es/images/banners/d83a_jiayu-aplica9.gif"/><img src="http://www.tfandroid.es/images/banners/d83a_jiayu-aplica9.gif"/><img src="http://www.tfandroid.es/images/banners/d83a_jiayu-aplica9.gif"/><br/></center>
				</div>
				<div id="hr"><hr/></div>
<%}else{%>
	<div id="hr"><hr/></div>
	<div id="banner">
	<img src="http://www.tfandroid.es/images/banners/d83a_jiayu-aplica9.gif"/><img src="http://www.tfandroid.es/images/banners/d83a_jiayu-aplica9.gif"/><img src="http://www.tfandroid.es/images/banners/d83a_jiayu-aplica9.gif"/>
	</div>
	<div id="hr"><hr/></div>
	
<%}}%>


<div id="main">
<div id="maincontainer">