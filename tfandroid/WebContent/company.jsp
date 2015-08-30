<%@include file="header.jsp" %>
<div id="containerLinea">
<b><a href="ControlServlet?action=2"><%=RB.getString("home.back") %></a></b><br/><br/><br/>
<center>
<div id="noticiaDetails">
<%Marca marca=(Marca)reqHelper.getCompanyActual();%>
<%=marca.getDescripcion() %>
</div>
</center>
</div>
<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>

