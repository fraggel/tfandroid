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
<%for (int x=0;x<reqHelper.getListaNews().size();x++){
	News noticia=(News)reqHelper.getListaNews().get(x);	
	noticia.getClass();
%>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="2"/>
<input type="hidden" name="idioma" value="<%=noticia.getIdioma()%>"/>
<input type="hidden" name="idnoticia" value="<%=noticia.getIdnoticia()%>"/>
Imagen: <img width="200px" src="<%=noticia.getUrl()%>"/><br/>
Fecha: <input type="text" name="fecha" value="<%=noticia.getFecha()%>"/><br/>
Título: <input type="text" name="titulo" value="<%=noticia.getTitulo()%>"/><br/>
URL Imagen:<input type="text" name="urlimagen" value="<%=noticia.getUrl()%>" size="50"/><br/>
Visible: <input type="text" name="visible" value="<%=noticia.isVisible()%>"/><br/>
Descripción: <textarea name="descripcion" rows="30" cols="100"><%=noticia.getDescripcion() %></textarea><br/>
Noticia Foro: <input type="text" name="noticiaForo" value="<%=noticia.isNoticiaForo()%>"/><br/>
UrlForo: <input type="text" name="urlForo" value="<%=noticia.getUrlForo()%>"/><br/>
<input type="submit" name="modificar" value="modificar"/><br/>
</form>
<br/><hr/>
<% }%>

<br/><br/><br/><br/><br/><br/>

<%}%>

<%} %>

<%@include file="../footer.jsp" %>