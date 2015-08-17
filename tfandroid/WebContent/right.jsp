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
<a href='ControlServlet?action=2&detalle=<%=marca.getIdmarca() %>'><img width="70%" src="<%=marca.getUrlImagen()%>"/></a><br/><br/>
<% }%>
</div>
<%for (int x=0;x<reqHelper.getListaNewsCortas().size();x++){
	News noticia=(News)reqHelper.getListaNewsCortas().get(x);	
%>
<div id="recuadroRight"><a href="ControlServlet?action=3&detalle=<%=noticia.getIdnoticia()%>"><%=noticia.getFecha()%><br/><img width="90%" src="<%=noticia.getUrl()%>"/><br/><%=noticia.getTitulo()%><br/><%=RB.getString("home.readmore") %></a></div>
<% }%>
<div id="recuadroRight">Foro<br/>
</div>
<div id="recuadroRight">Facebook<br/>
<!-- Facebook Badge START --><a href="https://www.facebook.com/TFAndroidDevelopers" title="TF Android Developers" style="font-family: &quot;lucida grande&quot;,tahoma,verdana,arial,sans-serif; font-size: 11px; font-variant: normal; font-style: normal; font-weight: normal; color: #3B5998; text-decoration: none;" target="_TOP">TF Android Developers</a><span style="font-family: &#039;lucida grande&#039;,tahoma,verdana,arial,sans-serif;font-size: 11px;line-height: 16px;font-variant: normal;font-style: normal;font-weight: normal;color: #555555;text-decoration: none;">&nbsp;|&nbsp;</span><br /><a href="https://www.facebook.com/TFAndroidDevelopers" title="TF Android Developers" target="_TOP"><img class="img" src="https://badge.facebook.com/badge/1469395773303675.11172.292103911.png" style="border: 0px;" alt="" /></a><!-- Facebook Badge END -->
</div>
<div id="recuadroRight">Google+<br/>
<!-- Inserta esta etiqueta en la sección "head" o justo antes de la etiqueta "body" de cierre. -->
<script src="https://apis.google.com/js/platform.js" async defer>
  {lang: 'es'}
</script>

<!-- Inserta esta etiqueta donde quieras que aparezca widget. -->
<div class="g-person" data-href="//plus.google.com/103304683630993709928" data-rel="author"></div>
</div>
<div id="recuadroRight">Twiter<br/>
<a href="https://twitter.com/TFADevelopers" class="twitter-follow-button" data-show-count="false" data-size="large">Follow @TFADevelopers</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
<br/>

</div>
<div id="recuadroRight">Youtube<br/>
<a href="https://www.youtube.com/user/TeamForceGroup" target="_blank">Youtube TF Android Developers</a><br/>
</div>

</div>
<%}
} %>
                 
