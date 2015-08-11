<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<b><%=RB.getString("menu.company") %>:</b><br/><br/><br/>
<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<center><div id="download"><br/><a href="ControlServlet?action=2&detalle=<%=marca.getIdmarca() %>"><img width="50%" src="<%=marca.getUrlImagen()%>"/><br/><%=marca.getTitulo()%><br/><%=RB.getString("home.showdetails") %></a></div></center>

<% }%>


<%@include file="footer.jsp" %>
