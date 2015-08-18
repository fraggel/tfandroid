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
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<%
if(session.getAttribute("admin")!=null){
%>

<%if(reqHelper.getAction()==1){ %>
Crear Modelo<br/>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="1"/>
<input type="hidden" name="subaction" value="1"/>
Marca:<select name="marca">
<%
if(reqHelper.getListaMarcas()!=null){
for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
%>
<option value="<%=marca.getIdmarca()%>"><%=marca.getTitulo() %></option>
<%}
}%>
</select><br/>
Nombre:<input type="text" name="nombre"/><br/>
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
<tr><td>Imagen</td><td>Nombre</td><td>Visible</td><td>&nbsp;</td><td>&nbsp;</td></tr>
<%for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);	
	modelo.getClass();
%>

<tr>
	<input type="hidden" name="action" value="1"/><input type="hidden" name="idmarca" value="<%=modelo.getIdmarca()%>"/><input type="hidden" name="idmodelo" value="<%=modelo.getIdmodelo()%>"/>
	<td><%=modelo.getTitulo()%></td>
	<td><img width="100px" src="<%=modelo.getUrlImagen()%>"/></td>
	<td><%=modelo.isVisible()%></td>
	<td><%=modelo.getIdmarca()%></td>
	<td><input type="submit" name="modificar" value="modificar"/></td>
	<td><input type="submit" name="borrar" value="borrar"/></td>
</tr>

<% }%>


<%}%>

<%} %>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>