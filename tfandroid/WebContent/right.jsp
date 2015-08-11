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
<div id="rigth">
<div id="recuadroRight">
<%for (int x=0;x<reqHelper.getListaMarcas().size();x++){
	Marca marca=(Marca)reqHelper.getListaMarcas().get(x);	
	marca.getClass();
%>
<a href='ControlServlet?action=2&subaction=<%=marca.getIdmarca() %>'><img width="70%" src="<%=marca.getUrlImagen()%>"/></a><br/>
<% }%>
</div>
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
%>
<div id="recuadroRight"><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=noticia.getFecha()%><br/><img width="90%" src="<%=noticia.getUrl()%>"/><br/><%=noticia.getTitulo()%><br/><%=RB.getString("home.readmore") %></a></div>
<% }%>

<div id="recuadroRight">Facebook<br/>
<img width="90%" src="http://www.tfandroid.es/images/css/face.png" />
</div>
<div id="recuadroRight">Google+<br/>
<img width="90%" src="http://www.tfandroid.es/images/css/goo.png"/>
</div>
<div id="recuadroRight">Twiter<br/>
<img width="90%" src="http://www.tfandroid.es/images/css/twit.png" />
</div>
<div id="recuadroRight">Foro<br/>
<img width="90%" src="http://www.tfandroid.es/images/css/face.png"/>
</div>
<div id="recuadroRight">Youtube<br/>
<img width="90%" src="http://www.tfandroid.es/images/css/face.png" />
</div>
</div>
<%}
} %>
                 
