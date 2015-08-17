<%@include file="header.jsp" %>
<%@include file="right.jsp" %>

<div id="noticiaDetails">
<%News noticia=(News)reqHelper.getNoticiaActual();%>
<b><%= noticia.getTitulo()%></b><br/>
<p id="grey"><%= noticia.getFecha()%></p><br/>
<center><img src="<%=noticia.getUrl()%>"/></center><br/><br/>
<%=noticia.getDescripcion() %>
</div>

<%@include file="footer.jsp" %>
