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
Título: <input type="text" name="titulo" value="<%=modelo.getTitulo()%>"/><br/>
URL Imagen: <input type="text" name="urlimagen" value="<%=modelo.getUrlImagen()%>" size="50"/><br/>
Descripción: <textarea name="descripcion" rows="30" cols="100"><%=modelo.getDescripcion() %></textarea><br/>
Visible: <input type="text" name="visible" value="<%=modelo.isVisible()%>"/><br/>
<input type="submit" name="modificar" value="modificar"/></form>
<br/><hr/>
<% }%>
<%}%>
<br/><br/><br/>
Plantilla modelos<br/>
<textarea rows="30" cols="100">
<tr>
<td><center><img src="http://www.tfandroid.es/images/cpuicon.png" width="60px"/></center>
</td>
<td>MT6752
</td>
</tr>
<tr>
<td>
<center><img src="http://www.tfandroid.es/images/ramicon.png" width="60px"/></center>
</td>
<td>
3GB/2GB
</td>
</tr>
<tr>
<td>
<center><img src="http://www.tfandroid.es/images/displayicon.png" width="60px"/></center>
</td>
<td>
5,5", Full HD 1080p
</td>
</tr>
<tr>
<td>
<center><img src="http://www.tfandroid.es/images/cameraicon.png" width="60px"/></center>
</td>
<td>
13Mpx/5Mpx
</td>
</tr>
<tr>
<td>
<center><img src="http://www.tfandroid.es/images/batteryicon.png" width="60px"/></center>
</td>
<td>
3000mAh
</td>
</tr>
</textarea>
<%} %>
<%@include file="../footer.jsp" %>