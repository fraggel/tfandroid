<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<b><%=RB.getString("menu.downloads") %>:</b></br></br></br>
<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<center><div id="download"></br><a href="ControlServlet?action=4&detalle=<%=marca.getIdmarca() %>"><img width="90%" src="<%=marca.getUrlImagen()%>"/></br><%=marca.getTitulo()%></br><%=RB.getString("home.showdetails") %></a></div></center>
<% }%>
</div>
</div>
</div>

<%@include file="footer.jsp" %>
