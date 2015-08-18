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

<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<form action="AdminServlet" method="post"><input type="hidden" name="action" value="0"/>
	<input type="hidden" name="subaction" value="1"/>
	<input type="hidden" name="idmarca" value="<%=marca.getIdmarca()%>"/>
	Imagen: <img width="200px" src="<%=marca.getUrlImagen()%>"/><br/>
	Título: <input type="text" name="titulo" value="<%=marca.getTitulo()%>"/><br/>
	URL Imagen: <input type="text" name="urlimagen" value="<%=marca.getUrlImagen()%>" size="50"/><br/>
	Visible: <input type="text" name="visible" value="<%=marca.isVisible()%>"/><br/>
	Descripción: <textarea name="descripcion" rows="30" cols="100"><%=marca.getDescripcion() %></textarea><br/>
	<input type="submit" name="modificar" value="modificar"/>
</form>
<br/><hr/>
<% }%>

<%}%>

<%} %>

<%@include file="../footer.jsp" %>