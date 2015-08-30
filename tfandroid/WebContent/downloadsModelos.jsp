<%@include file="header.jsp" %>

<div id="containerLinea">
<b><a href="ControlServlet?action=4"><%=RB.getString("home.back") %></a></b><br/><br/><br/>

<%for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);
	%>
	
	<b><%=modelo.getTitulo()%></b>
	<table class="CSSTableGenerator" border="1">
	<tbody>
	<tr>
	<td colspan="2"><a href="ControlServlet?action=4&detalle=<%=modelo.getIdmodelo() %>&subDetalle=<%=modelo.getIdmarca() %>"><img align="middle" src="<%=modelo.getUrlImagen()%>"/></a></td>
	</tr>
		<td><center><img src="http://www.tfandroid.es/images/cpuicon.png" width="45px"/></center>
		</td>
		<td><%=modelo.getCpu() %>
		</td>
		</tr>
		<tr>
		<td>
		<center><img src="http://www.tfandroid.es/images/ramicon.png" width="45px"/></center>
		</td>
		<td>
		<%=modelo.getRam() %>
		</td>
		</tr>
		<tr>
		<td>
		<center><img src="http://www.tfandroid.es/images/displayicon.png" width="45px"/></center>
		</td>
		<td>
		<%=modelo.getDisplay() %>
		</td>
		</tr>
		<tr>
		<td>
		<center><img src="http://www.tfandroid.es/images/cameraicon.png" width="45px"/></center>
		</td>
		<td>
		<%=modelo.getCamara() %>
		</td>
		</tr>
		<tr>
		<td>
		<center><img src="http://www.tfandroid.es/images/batteryicon.png" width="45px"/></center>
		</td>
		<td>
		<%=modelo.getBateria() %>
		</td>
		</tr>

	<tr>
	<td colspan="2"><a href="ControlServlet?action=4&detalle=<%=modelo.getIdmodelo() %>&subDetalle=<%=modelo.getIdmarca() %>"><%=RB.getString("home.showdetails") %></a></td>
	</tr>
	</tbody>
	</table>
	<br/><br/><br/>
<%}%>
</div>
<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>
