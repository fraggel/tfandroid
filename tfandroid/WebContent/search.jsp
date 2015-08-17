<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<form method="post" action="ControlServlet">          
		<input type="hidden" name="action" value="20"/>
			<input type="text" name="textSearch" size="30"/><input type="submit" name="Buscar" value="<%=RB.getString("home.search") %>"/>  
		</form> 
		<br/><br/>

<% if((reqHelper.getListaDescargas()!=null && reqHelper.getListaDescargas().size()>0) || (reqHelper.getListaNews()!=null && reqHelper.getListaNews().size()>0)) {%>
<b><%=RB.getString("menu.searchresult") %>:</b>
<br/><br/>
<%}%>
<%if(reqHelper.getListaDescargas()!=null && reqHelper.getListaDescargas().size()>0){
	
	%><b><%=RB.getString("menu.downloads") %></b><br/><br/><br/><% for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download download=(Download)reqHelper.getListaDescargas().get(x);	
%>
<div id="tableDescDivImg"><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>"><%=download.getFecha()%><br/><img width="90%" src="<%=download.getUrlimagen()%>"/><br/><%=download.getTitulo()%><br/><%=RB.getString("home.showdetails") %></a></div>
<hr/>
<% }}%>

<br/><br/><br/>

<%if(reqHelper.getListaNews()!=null && reqHelper.getListaNews().size()>0){
	%>
	<b><%=RB.getString("menu.news") %></b><br/><br/><br/>
	<%for (int x=0;x<reqHelper.getListaNews().size();x++){
	News noticia=(News)reqHelper.getListaNews().get(x);	
%>
<div id="tableDescDivImg"><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=noticia.getFecha()%><br/><img width="90%" src="<%=noticia.getUrl()%>"/><br/><%=noticia.getTitulo()%><br/><%=RB.getString("home.readmore") %></a></div>
<hr/>
<% }
}else{%>
<b><%=RB.getString("home.nocontent") %></b>
<%} %>

<%@include file="footer.jsp" %>


