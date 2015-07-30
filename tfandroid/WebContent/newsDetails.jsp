<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn2cols">
<div class="innertube">
<center>
<div id="noticiaDetails">
<%News noticia=(News)reqHelper.getNoticiaActual();%>
<%=noticia.getDescipcion() %>
</div>
</center>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
