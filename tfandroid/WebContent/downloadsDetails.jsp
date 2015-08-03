<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<b><%=RB.getString("menu.downloads") %>:<br/><a href="ControlServlet?action=4&detalle=<%=reqHelper.getDetalle()%>&subDetalle=<%=reqHelper.getSubDetalle()%>"><%=RB.getString("home.back") %></a></b><br/><br/><br/>
<div id="download">
<%Download download=(Download)reqHelper.getDescargaActual();%>
<%=download.getDescripcion() %>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
