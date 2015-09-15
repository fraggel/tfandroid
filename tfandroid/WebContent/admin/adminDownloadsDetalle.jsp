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
URL Imagen Phone: <input type="text" name="urlimagenphone" value="<%=descarga.getUrlimagenPhone()%>" size="50"/><br/><br/>
Visible: <input type="text" name="visible" value="<%=descarga.isVisible()%>"/><br/><br/>
Intro: <textarea name="intro" rows="30" cols="100"><%=descarga.getIntro() %></textarea><br/><br/>
Changelog:<textarea name="changelog" rows="30" cols="100"><%=descarga.getChangelog() %></textarea><br/><br/>
FAQ: <textarea name="faq" rows="30" cols="100"><%=descarga.getFaq()%></textarea><br/><br/>
Install: <textarea name="install" rows="30" cols="100"><%=descarga.getInstall() %></textarea><br/><br/>
Captura1: <textarea name="screenshots1" rows="30" cols="100"><%=descarga.getScreenshots1() %></textarea><br/><br/>
Captura2: <textarea name="screenshots2" rows="30" cols="100"><%=descarga.getScreenshots2() %></textarea><br/><br/>
Enlace MEGA: <textarea name="mega" rows="30" cols="100"><%=descarga.getMega() %></textarea><br/><br/>
Enlace GDRIVE: <textarea name="gdrive" rows="30" cols="100"><%=descarga.getGdrive() %></textarea><br/><br/>
Créditos: <textarea name="credits" rows="30" cols="100"><%=descarga.getCredits() %></textarea><br/><br/>
Forum_id: <input type="text" name="forum_id" value="<%=descarga.getForum_id()%>"/><br/><br/>
Topic_id: <input type="text" name="topic_id" value="<%=descarga.getTopic_id()%>"/><br/><br/>
Rom Info: <textarea name="info" rows="30" cols="100"><%=descarga.getInfo() %></textarea><br/><br/>
Features Info: <textarea name="features" rows="30" cols="100"><%=descarga.getFeatures() %></textarea><br/><br/>
<input type="submit" name="modificar" value="modificar"/><br/><br/>
</form>
</tr>
<%
}%>
<iframe src="http://www.garyshood.com/htmltobb/" width="100%" height="1000px"></iframe>
<%}
} 
}%>
<%@include file="../footer.jsp" %>