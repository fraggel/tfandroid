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


<%if(reqHelper.getAction()==3){ %>
Crear Banner</br>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="3"/>
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
</br></br></br></br></br></br>
<%}%>
<%} %>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>