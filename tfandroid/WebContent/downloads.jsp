<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<b><%=RB.getString("menu.downloads") %><br/><a href="ControlServlet?action=4&detalle=<%=reqHelper.getDetalle()%>"><%=RB.getString("home.back") %></a></b></br></br></br>
<%for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download download=(Download)reqHelper.getListaDescargas().get(x);	
%>
<center><div id="download"><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>"><%=download.getFecha()%></br><img src="<%=download.getUrlimagen()%>"/></br><%=download.getTitulo()%></br><%=RB.getString("home.showdetails") %></a></div></center>
<br/><br/>
<% }%>
</div>
</div>
</div>

<%@include file="footer.jsp" %>
