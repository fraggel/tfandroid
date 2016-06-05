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
<%if(reqHelper.getAction()==4){ %>
<form action="AdminServlet" method="post">
Elige Marca:<select name="idmarca">
<%
if(reqHelper.getListaMarcas()!=null){
for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
%>
<option value="<%=marca.getIdmarca()%>"><%=marca.getTitulo() %></option>
<%}
}%>
</select><br/>
Elige Modelo:<select name="idmodelo">
<%
if(reqHelper.getListaModelos()!=null){
for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);	
%>
<option value="<%=modelo.getIdmodelo()%>"><%=modelo.getTitulo() %></option>
<%}
}%>
</select><br/>
Elige idioma:<select name="language">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select><br/>
<input type="submit" name="CambiaIdioma" value="Consultar"/>
<input type="hidden" name="action" value="4"/>
</form>
<br/><br/><br/><br/><br/><br/>
<table border="1" width="100%">
<tr><td>Imagen</td><td>Fecha</td><td>Título</td><td>Marca/Modelo</td><td>Visible</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
<%if(reqHelper.getListaDescargas()!=null){
	for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download descarga=(Download)reqHelper.getListaDescargas().get(x);	
	descarga.getClass();
%>
<tr>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="4"/>
<input type="hidden" name="iddownload" value="<%=descarga.getIddescarga()%>"/>
<input type="hidden" name="idmarca" value="<%=descarga.getIdmarca()%>"/>
<input type="hidden" name="idmodelo" value="<%=descarga.getIdmodelo()%>"/>
<input type="hidden" name="idioma" value="<%=descarga.getIdioma()%>"/>
<td><img width="200px" src="<%=descarga.getUrlimagen()%>"/></td>
<td><%=descarga.getFecha()%></td>
<td><%=descarga.getTitulo()%></td>
<td><%=descarga.getMarcaModelo()%></td>
<td><%=descarga.isVisible()%></td>
<td><input type="submit" name="modificarMain" value="Modificar"/></td>
<td><input type="submit" name="generarBBCODE" value="Generar BBCODE"/></td>
<td><input type="submit" name="borrar" value="Borrar"/></td>
</form>
</tr>
<%
}
	%>
	</table>
	<br/>
	<br/>
<%}%>
Subir Imagen Descarga:<form method="POST" action="uploadServlet" enctype="multipart/form-data" >
            File:
            <input type="file" name="file" id="file" /> <br/>
            Destination:
            <input type="text" value="/public_html/images/downloads/ROMS" name="destination"/>
            </br>
            <input type="submit" value="Subir imagen" name="upload" id="upload" />
</form><br/>
Subir Imagen Captura:<form method="POST" action="uploadServlet" enctype="multipart/form-data" >
            File:
            <input type="file" name="file" id="file" /> <br/>
            Destination:
            <input type="text" value="/public_html/images/downloads/ROMS/screenshots" name="destination"/>
            </br>
            <input type="submit" value="Subir imagen" name="upload" id="upload" />
</form><br/>
Crear descarga<br/>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="4"/>
<input type="hidden" name="subaction" value="1"/>
Marca:<select name="idmarca">
<%
if(reqHelper.getListaMarcas()!=null){
for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
%>
<option value="<%=marca.getIdmarca()%>"><%=marca.getTitulo() %></option>
<%}
}%>
</select><br/>
Modelo:<select name="idmodelo">
<%
if(reqHelper.getListaModelos()!=null){
for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);	
%>
<option value="<%=modelo.getIdmodelo()%>"><%=modelo.getTitulo() %></option>
<%}
}%>
</select><br/>
Marca y Modelo:<input type="text" name="marcaModelo"/><br/>
Titulo:<input type="text" name="titulo"/><br/>
Intro: <textarea name="intro" rows="30" cols="100"></textarea><br/><br/>
Changelog:<textarea name="changelog" rows="30" cols="100"></textarea><br/><br/>
FAQ: <textarea name="faq" rows="30" cols="100"></textarea><br/><br/>
Install: <textarea name="install" rows="30" cols="100"></textarea><br/><br/>
Captura1: <textarea name="screenshots1" rows="30" cols="100"></textarea><br/><br/>
Captura2: <textarea name="screenshots2" rows="30" cols="100"></textarea><br/><br/>
Enlace MEGA: <textarea name="mega" rows="30" cols="100"></textarea><br/><br/>
Enlace GDRIVE: <textarea name="gdrive" rows="30" cols="100"></textarea><br/><br/>
Créditos: <textarea name="credits" rows="30" cols="100"></textarea><br/><br/>
Rom Info:<textarea name="info" rows="30" cols="100"></textarea><br/>
Rom Features:<textarea name="features" rows="30" cols="100"></textarea><br/>
Url Imagen:<input type="text" name="urlimagen"/><br/>
URL Imagen Phone: <input type="text" name="urlimagenphone" size="50"/><br/>
Idioma:<select name="idioma">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select><br/>
Visible <select name="visible">
<option selected value="true">Si</option>
<option value="false">No</option>
</select><br/><br/>
<input type="submit" name="crear" value="Crear"/><br/>
</form>
<br/><br/><br/>

<%	
}
%>
<%} %>

<%@include file="../footer.jsp" %>