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

<%if(reqHelper.getAction()==2){ %>
Crear Noticia</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="2"/>
<input type="hidden" name="subaction" value="1"/>
Titulo:<input type="text" name="titulo"/></br>
Descripcion:<textarea name="descripcion" rows="30" cols="100"></textarea></br>
Url Imagen:<input type="text" name="urlimagen"/></br>
Idioma:<select name="idioma">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select></br>
Visible <select name="visible">
<option selected value="true">Si</option>
<option value="false">No</option>
</select></br></br>
<input type="submit"/></br>
</form>
</br></br></br>
<form action="AdminServlet" method="post">
Elige idioma:<select name="language">
<option selected value="es">Español</option>
<option value="en">Ingles</option>
</select></br>
<input type="submit" name="CambiaIdioma" value="Cambiar idioma"/>
<input type="hidden" name="action" value="2"/>
</form>

<%for (int x=0;x<reqHelper.getListaNews().size();x++){
	News noticia=(News)reqHelper.getListaNews().get(x);	
	noticia.getClass();
%>
<form action="AdminServlet" method="post"><input type="hidden" name="action" value="2"/><input type="hidden" name="idioma" value="<%=noticia.getIdioma()%>"/><input type="hidden" name="idnoticia" value="<%=noticia.getIdnoticia()%>"/><img width="100px" src="<%=noticia.getUrl()%>"/></br><input type="text" name="titulo" value="<%=noticia.getTitulo()%>"/></br><input type="text" name="urlimagen" value="<%=noticia.getUrl()%>" size="50"/></br><input type="text" name="visible" value="<%=noticia.isVisible()%>"/></br><textarea name="descripcion" rows="30" cols="100"><%=noticia.getDescipcion() %></textarea></br><input type="submit" name="modificar" value="modificar"/></br><input type="submit" name="borrar" value="borrar"/></br></form>
</br><hr/>
<% }%>

</br></br></br></br></br></br>

<%}%>

<%} %>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>