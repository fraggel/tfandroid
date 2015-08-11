<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<b><a href="ControlServlet?action=2"><%=RB.getString("home.back") %></a></b><br/><br/><br/>
<center>
<div id="noticiaDetails">
<%Marca marca=(Marca)reqHelper.getCompanyActual();%>
<%=marca.getDescripcion() %>
</div>
</center>
<%@include file="footer.jsp" %>

