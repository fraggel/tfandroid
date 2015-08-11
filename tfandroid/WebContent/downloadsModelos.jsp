<%@include file="header.jsp" %>
<%@include file="right.jsp" %>

<b><%=RB.getString("menu.downloads") %>:<br/><a href="ControlServlet?action=4"><%=RB.getString("home.back") %></a></b><br/><br/><br/>

<%for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);
	%>
	
	<b><%=modelo.getTitulo()%></b>
	<table class="CSSTableGenerator" border="1">
	<tbody>
	<tr>
	<td colspan="2"><a href="ControlServlet?action=4&detalle=<%=modelo.getIdmarca() %>&subDetalle=<%=modelo.getIdmodelo() %>"><img width="200px" align="middle" src="<%=modelo.getUrlImagen()%>"/></a></td>
	</tr>
	<%=modelo.getDescripcion() %>
	<tr>
	<td colspan="2"><a href="ControlServlet?action=4&detalle=<%=modelo.getIdmarca() %>&subDetalle=<%=modelo.getIdmodelo() %>"><%=RB.getString("home.showdetails") %></a></td>
	</tr>
	</tbody>
	</table>
	<br/><br/><br/>
<%}%>


<%@include file="footer.jsp" %>
