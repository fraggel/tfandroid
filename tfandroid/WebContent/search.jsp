<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<b><%=RB.getString("menu.searchresult") %>:
<br/><br/>
<b><%=RB.getString("menu.downloads") %></b><br/><br/><br/>
<%for (int x=0;x<reqHelper.getListaDescargas().size();x++){
	Download download=(Download)reqHelper.getListaDescargas().get(x);	
%>
<center><div id="download"><a href="ControlServlet?action=4&detalle=<%=download.getIdmarca() %>&subDetalle=<%=download.getIdmodelo() %>&downloadId=<%=download.getIddescarga()%>"><%=download.getFecha()%><br/><img width="90%" src="<%=download.getUrlimagen()%>"/><br/><%=download.getTitulo()%><br/><%=RB.getString("home.showdetails") %></a></div></center>
<% }%>

<br/><br/><br/>
<b><%=RB.getString("menu.news") %></b><br/><br/><br/>
<%for (int x=0;x<reqHelper.getListaNews().size();x++){
	News noticia=(News)reqHelper.getListaNews().get(x);	
%>
<center><div id="noticia"><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=noticia.getFecha()%><br/><img width="90%" src="<%=noticia.getUrl()%>"/><br/><%=noticia.getTitulo()%><br/><%=RB.getString("home.readmore") %></a></div></center>
<% }%>


<%@include file="footer.jsp" %>


