<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
<%@include file="right.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<center>
<div id="noticiaDetails">
<%Marca marca=(Marca)reqHelper.getCompanyActual();%>
<%=marca.getDescripcion() %>
</div>
</center>
</div>
</div>
</div>
<%@include file="footer.jsp" %>

