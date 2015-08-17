<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<%for (int x=0;x<reqHelper.getListaInicio().size();x++){
	Inicio inicio=(Inicio)reqHelper.getListaInicio().get(x);
	if(inicio.getIdsecundario()!=-1 && inicio.getIdterciario()!=-1){
%>
<div id="tableDescDivImg"><b><%=inicio.getTitulo()%></b><br/><p id="grey"><%=inicio.getFecha()%></p><br/><a href="ControlServlet?action=4&detalle=<%=inicio.getIdprincipal()%>&subDetalle=<%=inicio.getIdsecundario() %>&downloadId=<%=inicio.getIdterciario()%>"><img width="90%" src="<%=inicio.getUrlimagen()%>"/></a><br/><%if(inicio.getDescripcion().length()>200){%><%=inicio.getDescripcion().substring(0,200)%>...<%}else{%><%=inicio.getDescripcion()%><%}%><br/><br/><a href="ControlServlet?action=4&detalle=<%=inicio.getIdprincipal()%>&subDetalle=<%=inicio.getIdsecundario() %>&downloadId=<%=inicio.getIdterciario()%>"><%=RB.getString("home.readmore") %></a><br/><hr/></div>
<% }
	else{
		%>
		<div id="tableDescDivImg"><b><%=inicio.getTitulo()%></b><br/><p id="grey"><%=inicio.getFecha()%></p><br/><a href="ControlServlet?action=3&detalle=<%=inicio.getIdprincipal()%>"><img width="90%" src="<%=inicio.getUrlimagen()%>"/></a><br/><%if(inicio.getDescripcion().length()>200){%><%=inicio.getDescripcion().substring(0,200)%>...<%}else{%><%=inicio.getDescripcion()%><%}%><br/><a href="ControlServlet?action=3&detalle=<%=inicio.getIdprincipal()%>"><%=RB.getString("home.readmore") %></a><br/><hr/></div>
		
		<%	
	}
	}%>
<%@include file="footer.jsp" %>

