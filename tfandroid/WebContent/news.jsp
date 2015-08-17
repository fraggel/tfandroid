<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<b><%=RB.getString("menu.news") %>:</b><br/><br/><br/>
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
%>
<div id="tableDescDivImg"><b><%=noticia.getTitulo()%></b><br/><p id="grey"><%=noticia.getFecha()%></p><br/><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><img width="90%" src="<%=noticia.getUrl()%>"/></a><br/><br/><%if(noticia.getDescripcion().length()>200){%><%=noticia.getDescripcion().substring(0,200)%>...<%}else{%><%=noticia.getDescripcion()%><%}%><br/><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=RB.getString("home.readmore") %></a><br/><hr/></div>
<% }%>

<%@include file="footer.jsp" %>
