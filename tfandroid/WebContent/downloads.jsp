<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<b><%=RB.getString("menu.downloads") %><br/><a href="ControlServlet?action=4&detalle=<%=reqHelper.getDetalle()%>"><%=RB.getString("home.back") %></a></b><br/><br/><br/>
<%for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download download=(Download)reqHelper.getListaDescargas().get(x);	
%>
<div id="tableDesc">
<b><%=download.getTitulo()%> <%=download.getFecha()%></b>
	<table id="downloads" border="0">
	
<tr>
<td id="tableDescTD1"><img src="http://www.tfandroid.es/images/arribaInfo.png" /><br/>
<%=download.getIdmarca()%>
</td>

	<td><div id="tableDescDivImg"><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>">
	<img src="<%=download.getUrlimagen()%>"/></a></div></td>
	</tr>

	<tr>
	<td colspan="2">
<img src="http://www.tfandroid.es/images/arribaFeatures.png" width="100%" height="30px"/>
	<ul style="margin-left:50px;margin-top:10px;">
<%=download.getIdmarca()%>
</ul>
</td>
	</tr>
	<tr>
	<td colspan="2"><center><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>">
	<div id="boldTable"><%=RB.getString("home.showdetails") %></div></a><center></td>
	</tr>
	</table>
</div>
	<br/><br/><hr/><br/><br/>


<% }%>

<%@include file="footer.jsp" %>
