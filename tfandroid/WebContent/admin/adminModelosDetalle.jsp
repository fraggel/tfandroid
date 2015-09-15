<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,
                 java.net.*,
                 java.util.*,
                 javax.servlet.*,
                 es.tfandroid.utils.RequestHelper,
                 es.tfandroid.beans.*" %>
<%@include file="../headeradmin.jsp" %>

<%
if(session.getAttribute("admin")!=null){
%>

<%if(reqHelper.getAction()==1){ %>
<%for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);	
	modelo.getClass();
%>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="1"/>
<input type="hidden" name="idmarca" value="<%=modelo.getIdmarca()%>"/>
<input type="hidden" name="idmodelo" value="<%=modelo.getIdmodelo()%>"/>
Imagen: <img width="200px" src="<%=modelo.getUrlImagen()%>"/><br/>
T�tulo: <input type="text" name="titulo" value="<%=modelo.getTitulo()%>"/><br/>
ForumID: <input type="text" name="forum_id" value="<%=modelo.getForum_id()%>"/><br/>
URL Imagen: <input type="text" name="urlimagen" value="<%=modelo.getUrlImagen()%>" size="50"/><br/>
CPU: <textarea name="tfcpu" rows="30" cols="100"><%=modelo.getCpu() %></textarea><br/>
RAM: <textarea name="tfram" rows="30" cols="100"><%=modelo.getRam() %></textarea><br/>
DISPLAY: <textarea name="tflcd" rows="30" cols="100"><%=modelo.getDisplay() %></textarea><br/>
CAMARA: <textarea name="tfcam" rows="30" cols="100"><%=modelo.getCamara() %></textarea><br/>
BATERIA: <textarea name="tfbat" rows="30" cols="100"><%=modelo.getBateria() %></textarea><br/>
Visible: <input type="text" name="visible" value="<%=modelo.isVisible()%>"/><br/>
<input type="submit" name="modificar" value="modificar"/></form>
<br/><hr/>
<% }%>
<%}%>
<br/><br/><br/>
<%} %>
<%@include file="../footer.jsp" %>