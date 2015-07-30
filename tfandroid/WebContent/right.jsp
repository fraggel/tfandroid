<%@ page import="java.io.*,
                 java.net.*,
                 java.util.*,
                 javax.servlet.*,
                 es.tfandroid.utils.RequestHelper,
                 es.tfandroid.beans.*" %>
                 <%if(reqHelper.getTipoDevice()!=null){
	if("mobile".equals(reqHelper.getTipoDevice())){
		%>

		<%		
	
	}else{	
%>
<div id="rightcolumn">
<div class="company">
<div class="innertube">

<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<a href='ControlServlet?action=2&subaction=<%=marca.getIdmarca() %>'><img width="90%" src="<%=marca.getUrlImagen()%>"/></a><br/>
<% }%>

</div>
</div>
</div>
<%}
} %>
                 
