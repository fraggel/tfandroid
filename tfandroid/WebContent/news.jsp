<%@include file="header.jsp" %>
<div id="containerLinea">
<b><%=RB.getString("menu.news") %>:</b><br/><br/><br/>
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
	if(noticia.isNoticiaForo()){
		%>
		<div id="tableDescDivImg"><b><%=noticia.getTitulo()%></b><br/><p id="grey"><%=noticia.getFecha()%></p><br/><a href="<%=noticia.getUrlForo()%>"><center><img  src="<%=noticia.getUrl()%>"/></center></a><br/><br/><%if(noticia.getDescripcion().length()>200){%><%=noticia.getDescripcion().substring(0,200)%>...<%}else{%><%=noticia.getDescripcion()%><%}%><br/><a href="<%=noticia.getUrlForo()%>"><%=RB.getString("home.readmore") %></a><br/><br/></div>
		<% 
	}else{
%>
<div id="tableDescDivImg"><b><%=noticia.getTitulo()%></b><br/><p id="grey"><%=noticia.getFecha()%></p><br/><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><center><img  src="<%=noticia.getUrl()%>"/></center></a><br/><br/><%if(noticia.getDescripcion().length()>200){%><%=noticia.getDescripcion().substring(0,200)%>...<%}else{%><%=noticia.getDescripcion()%><%}%><br/><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=RB.getString("home.readmore") %></a><br/><br/></div>
<% }
}%>
</div>
<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>
