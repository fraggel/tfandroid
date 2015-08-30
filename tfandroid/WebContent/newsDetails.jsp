<%@include file="header.jsp" %>
<div id="containerLinea">

<div id="noticiaDetails">
<%News noticia=(News)reqHelper.getNoticiaActual();%>
<b><%= noticia.getTitulo()%></b><br/>
<p id="grey"><%= noticia.getFecha()%></p><br/>
<center><img src="<%=noticia.getUrl()%>"/></center><br/><br/>
<%=noticia.getDescripcion() %>
</div>
</div>
<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>
