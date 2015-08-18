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
</hr>
Crear Marca<br/>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="0"/>
<input type="hidden" name="subaction" value="1"/>
Nombre:<input type="text" name="titulo"/><br/>
UrlImagen:<input type="text" name="urlimagen"/><br/>
Visible <select name="visible">
<option selected value="true">Si</option>
<option value="false">No</option>
</select><br/>
Descripcion:<textarea name="descripcion" rows="30" cols="100"></textarea><br/>
<input type="submit" name="crear" value="Crear"/><br/>
</form>
<br/><br/><br/>
<table border="1" width="100%">
<tr><td>Imagen</td><td>Título</td><td>Visible</td><td>&nbsp;</td><td>&nbsp;</td></tr>
<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<tr>
<form action="AdminServlet" method="post">
	<input type="hidden" name="subaction" value="1"/>
	<input type="hidden" name="idmarca" value="<%=marca.getIdmarca()%>"/>
	<td><img width="200px" src="<%=marca.getUrlImagen()%>"/></td>
	<td><%=marca.getTitulo()%></td><td><%=marca.isVisible()%></td>
	<td><input type="submit" name="modificarMain" value="modificar"/></td>
	<td><input type="submit" name="borrar" value="borrar"/></td>
</form>
</tr>
<% }%>
</table>
<%}%>

<%} %>
<%@include file="../footer.jsp" %>