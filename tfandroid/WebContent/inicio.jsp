<%@include file="header.jsp" %>
<div id="index">
<%for (int x=0;x<reqHelper.getListaInicio().size();x++){
	Inicio inicio=(Inicio)reqHelper.getListaInicio().get(x);
	if(inicio.getIdsecundario()!=-1 && inicio.getIdterciario()!=-1){
%>
<div id="tableDescDivImg"><a href="ControlServlet?action=4&detalle=<%=inicio.getIdsecundario()%>&subDetalle=<%=inicio.getIdterciario() %>&downloadId=<%=inicio.getIdprincipal()%>"><center><img src="<%=inicio.getUrlimagen()%>"/></center></a><br/><b><%=inicio.getMarcaModelo() %></b><br/><b><%=inicio.getTitulo()%></b><br/><p id="grey"><%=inicio.getFecha()%></p><br/><%if(inicio.getDescripcion().length()>200){%><%=inicio.getDescripcion().substring(0,200)%>...<%}else{%><%=inicio.getDescripcion()%><%}%><br/><br/><a href="ControlServlet?action=4&detalle=<%=inicio.getIdsecundario()%>&subDetalle=<%=inicio.getIdterciario() %>&downloadId=<%=inicio.getIdprincipal()%>"><%=RB.getString("home.readmore") %></a><br/><br/></div>
<% }
	else{
		if(inicio.isNoticiaForo()){
			%>
			<div id="tableDescDivImg"><a href="<%=inicio.getUrlForo()%>"><center><img src="<%=inicio.getUrlimagen()%>"/></center></a><br/><b><%=inicio.getTitulo()%></b><br/><p id="grey"><%=inicio.getFecha()%></p><br/><%if(inicio.getDescripcion().length()>200){%><%=inicio.getDescripcion().substring(0,200)%>...<%}else{%><%=inicio.getDescripcion()%><%}%><br/><a href="<%=inicio.getUrlForo()%>"><%=RB.getString("home.readmore") %></a><br/><br/></div>
			
			<%		
		}else{
		%>
		<div id="tableDescDivImg"><a href="ControlServlet?action=3&detalle=<%=inicio.getIdprincipal()%>"><center><img src="<%=inicio.getUrlimagen()%>"/></center></a><br/><b><%=inicio.getTitulo()%></b><br/><p id="grey"><%=inicio.getFecha()%></p><br/><%if(inicio.getDescripcion().length()>200){%><%=inicio.getDescripcion().substring(0,200)%>...<%}else{%><%=inicio.getDescripcion()%><%}%><br/><a href="ControlServlet?action=3&detalle=<%=inicio.getIdprincipal()%>"><%=RB.getString("home.readmore") %></a><br/><br/></div>
		
		<%	
		}
	}
	}%>
</div>
<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>

