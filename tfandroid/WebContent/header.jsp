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


	<%if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>
		<div id="leftsection"><div id="topsection"><div id="logo"><div class="innertube">
	<a href=""><img id="logoweb" /></a>
	<div id="banner">
		<a href="" target="_blank"><img id="bannerweb" /></a>
	</div>
		
</div>
</div>
</div>
</div>
<div id="languagesearchsocialMobile">
<form method="post" action="ControlServlet">
		<a href="ControlServlet?language=es" ><img src="http://www.tfandroid.es/images/EspanaBanderaIcono.png" width="140px"/></a><a href="ControlServlet?language=en"><img src="http://www.tfandroid.es/images/ReinoUnidoBanderaIcono.png" width="140px"/></a><br/> <br/>  
		<input type="hidden" name="action" value="20"/>
			<input type="text" name="textSearch" size="25" style="font-size:32pt;"/><input type="submit" name="Buscar" value="<%=RB.getString("home.search") %>" style="font-size:32pt"/><br/><br/> 
			<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.jpg" width="140px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.jpg" width="140px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.jpg" width="140px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.jpg" width="140px"/></a><br/><br/> 
		</form> 
</div>
<%		
	
	}else{	
%>
<div id="leftsection"><div id="topsection"><div id="logo"><div class="innertube">
	<a href=""><img id="logoweb" /></a>
	<div id="banner">
		<a href="" target="_blank"><img id="bannerweb" /></a>
	</div>
	<div id="languagesearchsocial">
		<form method="post" action="ControlServlet">
		<a href="ControlServlet?language=es" ><img src="http://www.tfandroid.es/images/EspanaBanderaIcono.png" width="40px"/></a><a href="ControlServlet?language=en"><img src="http://www.tfandroid.es/images/ReinoUnidoBanderaIcono.png" width="40px"/></a>          
		<input type="hidden" name="action" value="20"/>
			<input type="text" name="textSearch" size="30"/><input type="submit" name="Buscar" value="<%=RB.getString("home.search") %>"/>  
			<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.jpg" width="40px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.jpg" width="40px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.jpg" width="40px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.jpg" width="40px"/></a>
		</form> 
	</div>
	</div>
</div>
</div>
</div>
	<%}
} %>

<%if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>
<div id='cssmenu'>
<ul>
   <li class='<%=reqHelper.getAction()==0 ? "active " : ""%> last'><a href='ControlServlet?action=0'><span><%=RB.getString("menu.promotions") %></span></a></li>
   <li class='<%=reqHelper.getAction()==1 ? "active " : ""%>'><a href='ControlServlet?action=1'><span><%=RB.getString("menu.about") %></span></a></li>
   <li class='<%=reqHelper.getAction()==2 ? "active " : ""%>has-sub'><a href='#'><span><%=RB.getString("menu.company") %></span></a>   </li>
   <li class='<%=reqHelper.getAction()==3 ? "active " : ""%>'><a href='ControlServlet?action=3'><span><%=RB.getString("menu.news") %></span></a></li>
   <li class='<%=reqHelper.getAction()==4 ? "active " : ""%>'><a href='ControlServlet?action=4'><span><%=RB.getString("menu.downloads") %></span></a></li>
   
   <li class='<%=reqHelper.getAction()==5 ? "active " : ""%>'><a href='http://foro.tfandroid.es' target="_blank" ><span><%=RB.getString("menu.forum") %></span></a></li>
   <li class='<%=reqHelper.getAction()==6 ? "active " : ""%>'><a href='ControlServlet?action=6'><span><%=RB.getString("menu.staff") %></span></a></li>
   <li class='<%=reqHelper.getAction()==7 ? "active " : ""%> last'><a href='ControlServlet?action=7'><span><%=RB.getString("menu.contact") %></span></a></li>
   <li class='<%=reqHelper.getAction()==8 ? "active " : ""%> last'><a href='ControlServlet?action=8'><span><%=RB.getString("menu.reviews") %></span></a></li>
   
</ul>
</div>

		<%		
	
	}else{	
%>
<div id='cssmenu'>
<ul>
   <li class='<%=reqHelper.getAction()==0 ? "active " : ""%> last'><a href='ControlServlet?action=0'><span><%=RB.getString("menu.promotions") %></span></a></li>
   <li class='<%=reqHelper.getAction()==1 ? "active " : ""%>'><a href='ControlServlet?action=1'><span><%=RB.getString("menu.about") %></span></a></li>
   <li class='<%=reqHelper.getAction()==2 ? "active " : ""%>has-sub'><a href='#'><span><%=RB.getString("menu.company") %></span></a>
      <ul>
      <%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
		Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
		marca.getClass();
		%>
		<li><a href='ControlServlet?action=2&subaction=<%=marca.getIdmarca() %>'><img width="90%" src="<%=marca.getUrlImagen()%>"/><br/><%=marca.getTitulo()%></a></li>
<% }%>
      		 		 		 
      </ul>
   </li>
   <li class='<%=reqHelper.getAction()==3 ? "active " : ""%>'><a href='ControlServlet?action=3'><span><%=RB.getString("menu.news") %></span></a></li>
   <li class='<%=reqHelper.getAction()==4 ? "active " : ""%>'><a href='ControlServlet?action=4'><span><%=RB.getString("menu.downloads") %></span></a></li>
   
   <li class='<%=reqHelper.getAction()==5 ? "active " : ""%>'><a href='http://foro.tfandroid.es' target="_blank" ><span><%=RB.getString("menu.forum") %></span></a></li>
   <li class='<%=reqHelper.getAction()==6 ? "active " : ""%>'><a href='ControlServlet?action=6'><span><%=RB.getString("menu.staff") %></span></a></li>
   <li class='<%=reqHelper.getAction()==7 ? "active " : ""%> last'><a href='ControlServlet?action=7'><span><%=RB.getString("menu.contact") %></span></a></li>
   <li class='<%=reqHelper.getAction()==8 ? "active " : ""%> last'><a href='ControlServlet?action=8'><span><%=RB.getString("menu.reviews") %></span></a></li>
   
</ul>
</div>

<%}
} %>
