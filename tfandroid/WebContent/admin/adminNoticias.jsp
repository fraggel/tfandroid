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

<%if(reqHelper.getAction()==2){ %>
Subir Imagen Noticia:<form method="POST" action="uploadServlet" enctype="multipart/form-data" >
            File:
            <input type="file" name="file" id="file" /> <br/>
            Destination:
            <input type="text" value="/public_html/images/news" name="destination"/>
            </br>
            <input type="submit" value="Subir imagen" name="upload" id="upload" />
</form><br/>
Crear Noticia<br/>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="2"/>
<input type="hidden" name="subaction" value="1"/>
Titulo:<input type="text" name="titulo"/><br/>
Descripcion:<textarea name="descripcion" rows="30" cols="100"></textarea><br/>
Url Imagen:<input type="text" name="urlimagen"/><br/>
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
<form action="AdminServlet" method="post">
Elige idioma:<select name="language">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select><br/>
<input type="submit" name="cambiaIdioma" value="Consultar"/>
<input type="hidden" name="action" value="2"/>
</form>
<table border="1" width="100%">
<tr><td>Imagen</td><td>Fecha</td><td>Título</td><td>Visible</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
<%for (int x=0;x<reqHelper.getListaNews().size();x++){
	News noticia=(News)reqHelper.getListaNews().get(x);	
	noticia.getClass();
%>
<tr>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="2"/>
<input type="hidden" name="idioma" value="<%=noticia.getIdioma()%>"/>
<input type="hidden" name="idnoticia" value="<%=noticia.getIdnoticia()%>"/>
<td><img width="200px" src="<%=noticia.getUrl()%>"/></td>
<td><%=noticia.getFecha()%></td>
<td><%=noticia.getTitulo()%></td>
<td><%=noticia.isVisible()%></td>
<td><input type="submit" name="modificarMain" value="Modificar"/>
<td><input type="submit" name="generarBBCODE" value="Generar BBCODE"/>
<td><input type="submit" name="borrar" value="Borrar"/>
</form>
</tr>

<% }%>
</table>
<br/><br/><br/><br/><br/><br/>

<%}%>

<%} %>
<%@include file="../footer.jsp" %>