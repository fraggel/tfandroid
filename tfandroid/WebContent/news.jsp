<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<b><%=RB.getString("menu.news") %>:</b><br/><br/><br/>
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
%>
<div id="tableDescDivImg"><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=noticia.getFecha()%><br/><img width="90%" src="<%=noticia.getUrl()%>"/><br/><%=noticia.getTitulo()%><br/><%=RB.getString("home.readmore") %></a></div>
<% }%>

<%@include file="footer.jsp" %>
