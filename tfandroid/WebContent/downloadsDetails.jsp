<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<b><%=RB.getString("menu.downloads") %>:<br/><a href="ControlServlet?action=4&detalle=<%=reqHelper.getDetalle()%>&subDetalle=<%=reqHelper.getSubDetalle()%>"><%=RB.getString("home.back") %></a></b><br/><br/><br/>
<div id="download">
<%Download download=(Download)reqHelper.getDescargaActual();%>
<%=download.getDescripcion() %>

<%@include file="footer.jsp" %>
