<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<center>
<div id="noticiaDetails">
<%News noticia=(News)reqHelper.getNoticiaActual();%>
<%=noticia.getDescipcion() %>
</div>
</center>

<%@include file="footer.jsp" %>
