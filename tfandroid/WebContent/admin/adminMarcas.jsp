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
<%if(reqHelper.getAction()==0){ %>
</hr>
Crear Marca</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="0"/>
<input type="hidden" name="subaction" value="1"/>
Nombre:<input type="text" name="titulo"/></br>
UrlImagen:<input type="text" name="urlimagen"/></br>
Visible <select name="visible">
<option selected value="true">Si</option>
<option value="false">No</option>
</select></br>
Descripcion:<textarea name="descripcion" rows="30" cols="100"></textarea></br>
<input type="submit" name="crear" value="Crear"/></br>
</form>
</br></br></br>
<table>
<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<form action="AdminServlet" method="post"><input type="hidden" name="action" value="0"/>
<input type="hidden" name="subaction" value="1"/><input type="hidden" name="idmarca" value="<%=marca.getIdmarca()%>"/><img width="100px" src="<%=marca.getUrlImagen()%>"/></br><input type="text" name="titulo" value="<%=marca.getTitulo()%>"/></br><input type="text" name="urlimagen" value="<%=marca.getUrlImagen()%>" size="50"/></br><input type="text" name="visible" value="<%=marca.isVisible()%>"/></br><textarea name="descripcion" rows="30" cols="100"><%=marca.getDescripcion() %></textarea></br><input type="submit" name="modificar" value="modificar"/></br><input type="submit" name="borrar" value="borrar"/></form>
</br><hr/>
<% }%>
</table>

</br></br></br></br></br></br>
<%}%>

<%} %>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>