<%@include file="header.jsp" %>
<div id="containerLinea">
<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<center><div id="download"><br/><a href="ControlServlet?action=4&detalle=<%=marca.getIdmarca() %>"><img width="30%" src="<%=marca.getUrlImagen()%>"/><br/><%=marca.getTitulo()%><br/><%=RB.getString("home.showdetails") %></a></div></center><br/><br/>

<% }%>
</div>
<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>
