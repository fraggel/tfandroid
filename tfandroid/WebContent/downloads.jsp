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
<td id="tableDescTD1"><img src="http://www.tfandroid.es/images/<%=RB.getString("img.arribaInfo") %>" /><br/>
<%=download.getInfo()%>
</td>

	<td><div id="tableDescDivImg"><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>">
	<img src="<%=download.getUrlimagen()%>"/></a></div></td>
	</tr>

	<tr>
	<td colspan="2">
<img src="http://www.tfandroid.es/images/<%=RB.getString("img.arribaFeat") %>"/>
	<ul class="leaf" >
<%=download.getFeatures()%>
</ul>
</td>
	</tr>
	<tr>
	<td colspan="2"><center><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>">
	<%=RB.getString("home.showdetails") %></a><center></td>
	</tr>
	</table>
</div>
	<br/><br/><hr/><br/><br/>


<% }%>

<%@include file="footer.jsp" %>
