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
<%if(reqHelper.getAction()==0){ %>

<%for (int x=0;x<reqHelper.getListaBanners().size();x++){
	Banner banner=(Banner)reqHelper.getListaBanners().get(x);	
	banner.getClass();
%>
<form action="AdminServlet" method="post"><input type="hidden" name="action" value="0"/>
	<input type="hidden" name="subaction" value="1"/>
	<input type="hidden" name="idmarca" value="<%=banner.getIdBanner()%>"/>
	Imagen: <img width="200px" src="<%=banner.getUrlImagen()%>"/><br/>
	URL Imagen: <input type="text" name="urlimagen" value="<%=banner.getUrlImagen()%>" size="50"/><br/>
	URL Destino: <input type="text" name="urldestino" value="<%=banner.getUrlDestino()%>" size="50"/><br/>
	<input type="submit" name="modificar" value="modificar"/>
</form>
<br/><hr/>
<% }%>

<%}%>

<%} %>

<%@include file="../footer.jsp" %>