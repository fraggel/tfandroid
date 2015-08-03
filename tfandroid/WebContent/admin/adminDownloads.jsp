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
<%if(reqHelper.getAction()==4){ %>
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

<%if(reqHelper.getListaDescargas()!=null){
	for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download descarga=(Download)reqHelper.getListaDescargas().get(x);	
	descarga.getClass();
%>
Marca:
<%
if(reqHelper.getListaMarcas()!=null){
for (int xx=0;xx<reqHelper.getListaMarcas().size();xx++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(xx);
	if(marca.getIdmarca()==descarga.getIdmarca()){
%>
<%=marca.getTitulo() %>
<%}
	}
}%>
<br/>
Modelo:
<%
if(reqHelper.getListaModelos()!=null){
for (int xxx=0;xxx<reqHelper.getListaModelos().size();xxx++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(xxx);	
	if(modelo.getIdmodelo()==descarga.getIdmodelo()){
%>
<%=modelo.getTitulo() %>
<%}
}
}%>
<br/>
<form action="AdminServlet" method="post"><input type="hidden" name="action" value="4"/><input type="hidden" name="iddownload" value="<%=descarga.getIddescarga()%>"/><input type="hidden" name="idmarca" value="<%=descarga.getIdmarca()%>"/><input type="hidden" name="idmodelo" value="<%=descarga.getIdmodelo()%>"/><img width="100px" src="<%=descarga.getUrlimagen()%>"/><br/><input type="text" name="fecha" value="<%=descarga.getFecha()%>"/><input type="text" name="idioma" value="<%=descarga.getIdioma()%>"/><br/><input type="text" name="titulo" value="<%=descarga.getTitulo()%>"/><br/><input type="text" name="urlimagen" value="<%=descarga.getUrlimagen()%>" size="50"/><br/><input type="text" name="visible" value="<%=descarga.isVisible()%>"/><br/><textarea name="descripcion" rows="30" cols="100"><%=descarga.getDescripcion() %></textarea><br/><input type="submit" name="modificar" value="modificar"/><br/><input type="submit" name="borrar" value="borrar"/><br/></form>
<br/><hr/>
<%
}
}%>
<%	
}
%>
<iframe src="http://www.quackit.com/html/online-html-editor/full/" width="100%" height="1000px"></iframe><br/>
<iframe src="http://www.garyshood.com/htmltobb/" width="100%" height="1000px"></iframe>
<div id="plantilla">
Plantilla Descarga Español:<br/>
<textarea rows="30" cols="100">
<!doctype html>
<html>
<head>
	<title>TELEFONO- ROM</title>
</head>
<body>
<div id="downloadImg"><center><img src="http://www.tfandroid.es/images/downloads/ROMS/imagenROM"/></center></div><br/><br/>
DESCRIPCION<br/>
<br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/infoes.png"/></center><br/><br/>
NOMBRE ROM<br/>

Versión Android: 4.4.4.<br/>

Fecha de publicación: 25-04-2015.<br/>

Tamaño: 557MB.<br/>

MD5: b0e8b413eaef23b96f661e47cf1ba600<br/><br/>

<center><img width="60%" src="http://www.tfandroid.es/images/downloads/changeloges.png"/></center><br/><br/>
<ul>
<li>LISTA DE CARACTERISTICAS</li>

</ul><br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/faqes.png"/></center><br/><br/>
PREGUNTAS FRECUENTES
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/installationes.png"/></center><br/><br/>
Se instala por recovery, recomendamos TWRP que le puedes descargar desde nuestra web.<br/>
<ul>
<li>Descargar ROM y copiarla en la SD interna.</li>
<li>Entrar en TWRP Recovery.</li>
<li>Wipe Data. (Opcional, ya lo hace la instalación)</li>
<li>Wipe Cache. (Opcional, ya lo hace la instalación)</li>
<li>Wipe Dalvik Cache. (Opcional, ya lo hace la instalación)</li>
<li>Format system.(Opcional, ya lo hace la instalación)</li>
<li>Instalar ROM from SD.</li>
<li>Reinicio automático.</li>
</ul>
<br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/screenshotses.png"/></center><br/><br/>
<a href="http://www.tfandroid.es/images/downloads/ROMS/screenshots/" target="_blank"><img src="http://www.tfandroid.es/images/downloads/ROMS/screenshots/"/></a>

<br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/downloadses.png"/></center><br/><br/>
Puedes descargarlo desde los siguientes servidores:<br/>
<a href="ENLACE DE MEGA"><img src="http://www.tfandroid.es/images/downloads/mega.png" width="100px"/></a><a href="ENLACE GDRIVE"><img src="http://www.tfandroid.es/images/downloads/gdrive.png" width="100px"/></a><br/>
<br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/visituses.png"/></center><br/>
<a href="www.tfandroid.es"><img src="http://www.tfandroid.es/images/logonuevo.png" width="100px"/></a>
<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.jpg" width="100px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.jpg" width="100px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.jpg" width="100px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.jpg" width="100px"/></a><br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/creditses.png"/></center><br/><br/>
CREDITOS<br/>

<center><img width="60%" src="http://www.tfandroid.es/images/downloads/paypales.png"/></center><br/><br/>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top"><input name="cmd" type="hidden" value="_s-xclick" /><br />
<input name="hosted_button_id" type="hidden" value="U8RJD58H3MDUG" /><br />
Si quieres apoyarnos y permitir el continuo desarrollo de nuevas roms y sus constantes actualizaciones realiza aquí tu donativo:<br />
<input alt="PayPal. La forma rápida y segura de pagar en Internet." name="submit" src="http://www.tfandroid.es/images/downloads/donatees.gif" type="image" width="200px"/><br />
<img src="https://www.paypalobjects.com/es_ES/i/scr/pixel.gif" alt="" width="1" height="1" border="0" /></form><br/><br/><br/><br/><br/><br/>

</body>
</html>
</textarea><br/>
Plantilla Descarga Ingles:<br/>
<textarea rows="30" cols="100">
<!doctype html>
<html>
<head>
	<title>TELEFONO- ROM</title>
</head>
<body>
<div id="downloadImg"><center><img src="http://www.tfandroid.es/images/downloads/ROMS/imagenROM"/></center></div><br/><br/>
DESCRIPCION<br/>
<br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/infoen.png"/></center><br/><br/>
NOMBRE ROM<br/>

Versión Android: 4.4.4.<br/>

Fecha de publicación: 25-04-2015.<br/>

Tamaño: 557MB.<br/>

MD5: b0e8b413eaef23b96f661e47cf1ba600<br/><br/>

<center><img width="60%" src="http://www.tfandroid.es/images/downloads/changelogen.png"/></center><br/><br/>
<ul>
<li>LISTA DE CARACTERISTICAS</li>

</ul><br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/faqen.png"/></center><br/><br/>
PREGUNTAS FRECUENTES
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/installationen.png"/></center><br/><br/>
Se instala por recovery, recomendamos TWRP que le puedes descargar desde nuestra web.<br/>
<ul>
<li>Descargar ROM y copiarla en la SD interna.</li>
<li>Entrar en TWRP Recovery.</li>
<li>Wipe Data. (Opcional, ya lo hace la instalación)</li>
<li>Wipe Cache. (Opcional, ya lo hace la instalación)</li>
<li>Wipe Dalvik Cache. (Opcional, ya lo hace la instalación)</li>
<li>Format system.(Opcional, ya lo hace la instalación)</li>
<li>Instalar ROM from SD.</li>
<li>Reinicio automático.</li>
</ul>
<br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/screenshotsen.png"/></center><br/><br/>
<a href="http://www.tfandroid.es/images/downloads/ROMS/screenshots/" target="_blank"><img src="http://www.tfandroid.es/images/downloads/ROMS/screenshots/"/></a>
<br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/downloadsen.png"/></center><br/><br/>
Puedes descargarlo desde los siguientes servidores:<br/>
<a href="ENLACE DE MEGA"><img src="http://www.tfandroid.es/images/downloads/mega.png"/></a><a href="ENLACE GDRIVE"><img src="http://www.tfandroid.es/images/downloads/gdrive.png"/></a><br/>
<br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/visitusen.png"/></center><br/>
<a href="www.tfandroid.es"><img src="http://www.tfandroid.es/images/logonuevo.png"/></a>
<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.jpg" width="140px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.jpg" width="140px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.jpg" width="140px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.jpg" width="140px"/></a><br/><br/>
<center><img width="60%" src="http://www.tfandroid.es/images/downloads/creditsen.png"/></center><br/><br/>
CREDITOS<br/>

<center><img width="60%" src="http://www.tfandroid.es/images/downloads/paypalen.png"/></center><br/><br/>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top"><input name="cmd" type="hidden" value="_s-xclick" /><br />
<input name="hosted_button_id" type="hidden" value="U8RJD58H3MDUG" /><br />
Si quieres apoyarnos y permitir el continuo desarrollo de nuevas roms y sus constantes actualizaciones realiza aquí tu donativo:<br />
<input alt="PayPal. La forma rápida y segura de pagar en Internet." name="submit" src="http://www.tfandroid.es/images/downloads/donateen.gif" type="image" width="200px"/><br />
<img src="https://www.paypalobjects.com/es_ES/i/scr/pixel.gif" alt="" width="1" height="1" border="0" /></form><br/><br/><br/><br/><br/><br/>

</body>
</html>
</textarea><br/>
Plantilla Noticia Español:<br/>
<textarea rows="30" cols="100"></textarea><br/>
Plantilla Noticia Ingles:<br/>
<textarea rows="30" cols="100"></textarea><br/>
</div>
<%} %>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>