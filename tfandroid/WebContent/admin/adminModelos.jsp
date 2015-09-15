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
Subir Imagen Modelo:<form method="POST" action="uploadServlet" enctype="multipart/form-data" >
            File:
            <input type="file" name="file" id="file" /> <br/>
            Destination:
            <input type="text" value="/public_html/images/devices" name="destination"/>
            </br>
            <input type="submit" value="Subir imagen" name="upload" id="upload" />
</form><br/>
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
Forum ID:<input type="text" name="forum_id"/><br/>
CPU:<input type="text" name="tfcpu"/><br/>
RAM:<input type="text" name="tfram"/><br/>
PANTALLA:<input type="text" name="tflcd"/><br/>
CAMARA:<input type="text" name="tfcam"/><br/>
BATERÍA:<input type="text" name="tfbat"/><br/>
<input type="submit" name="crear" value="Crear"/><br/>
</form>
<br/><br/><br/>
<table border="1" width="100%">
<tr><td>Imagen</td><td>Título</td><td>Visible</td><td>Marca</td><td>&nbsp;</td><td>&nbsp;</td></tr>
<%for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);	
	modelo.getClass();
%>

<tr>
<form action="AdminServlet" method="post">
	<input type="hidden" name="action" value="1"/>
	<input type="hidden" name="idmarca" value="<%=modelo.getIdmarca()%>"/>
	<input type="hidden" name="idmodelo" value="<%=modelo.getIdmodelo()%>"/>
	<td><img width="200px" src="<%=modelo.getUrlImagen()%>"/></td>
	<td><%=modelo.getTitulo()%></td>
	<td><%=modelo.isVisible()%></td>
	<td><%=modelo.getIdmarca()%></td>
	<td><input type="submit" name="modificarMain" value="modificar"/></td>
	<td><input type="submit" name="borrar" value="borrar"/></td>
</form>
</tr>

<% }%>
</table>

<%}%>
<%} %>

<%@include file="../footer.jsp" %>