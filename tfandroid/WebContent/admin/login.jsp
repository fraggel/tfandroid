<%@include file="../headeradmin.jsp" %>
<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube">
<center>
<form action="AdminServlet" method="post">
<input type="hidden" name="action" value="25"/>
<input type="text" name="user"/><br/>
<input type="text" name="pass"/><br/>
<input type="submit"/>
</form>
</center>
</div>
</div>
</div>
<%@include file="../footer.jsp" %>