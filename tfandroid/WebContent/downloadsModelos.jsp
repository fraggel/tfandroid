<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">

<b><%=RB.getString("menu.downloads") %>:<br/><a href="ControlServlet?action=4"><%=RB.getString("home.back") %></a></b></br></br></br>
<%for (int x=0;x<reqHelper.getListaModelos().size();x++){
	Modelo modelo=(Modelo)reqHelper.getListaModelos().get(x);	
%>
<center><div id="download"></br><a href="ControlServlet?action=4&detalle=<%=modelo.getIdmarca() %>&subDetalle=<%=modelo.getIdmodelo() %>"><img width="200px" src="<%=modelo.getUrlImagen()%>"/><%=modelo.getTitulo()%></br><%=RB.getString("home.showdetails") %></a></div></center>
<% }%>
</div>
</div>
</div>

<%@include file="footer.jsp" %>
