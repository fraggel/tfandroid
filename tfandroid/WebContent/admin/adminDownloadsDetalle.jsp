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
<%
if(reqHelper.getListaDescargas()!=null){
for (int xxx=0;xxx<reqHelper.getListaDescargas().size();xxx++){
	Download descarga=(Download)reqHelper.getListaDescargas().get(xxx);	
%>
<tr>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="4"/>
<input type="hidden" name="iddownload" value="<%=descarga.getIddescarga()%>"/>
<input type="hidden" name="idmarca" value="<%=descarga.getIdmarca()%>"/>
<input type="hidden" name="idmodelo" value="<%=descarga.getIdmodelo()%>"/>
Imagen: <img width="200px" src="<%=descarga.getUrlimagen()%>"/><br/><br/>
Fecha: <input type="text" name="fecha" value="<%=descarga.getFecha()%>"/><br/><br/>
Idioma: <input type="text" name="idioma" value="<%=descarga.getIdioma()%>"/><br/><br/>
Marca/Modelo: <input type="text" name="marcaModelo" value="<%=descarga.getMarcaModelo()%>"/><br/><br/>
Título. <input type="text" name="titulo" value="<%=descarga.getTitulo()%>"/><br/><br/>
URL Imagen: <input type="text" name="urlimagen" value="<%=descarga.getUrlimagen()%>" size="50"/><br/><br/>
Visible: <input type="text" name="visible" value="<%=descarga.isVisible()%>"/><br/><br/>
Información: <textarea name="informacion" rows="30" cols="100"><%=descarga.getDescripcion() %></textarea><br/><br/>
Rom Info: <textarea name="info" rows="30" cols="100"><%=descarga.getInfo() %></textarea><br/><br/>
Features Info: <textarea name="features" rows="30" cols="100"><%=descarga.getFeatures() %></textarea><br/><br/>
<input type="submit" name="modificar" value="modificar"/><br/><br/>
</form>
</tr>
<%
}%>
<iframe src="http://www.quackit.com/html/online-html-editor/full/" width="100%" height="1000px"></iframe><br/>
<iframe src="http://www.garyshood.com/htmltobb/" width="100%" height="1000px"></iframe>
<%}
} 
}%>
<%@include file="../footer.jsp" %>