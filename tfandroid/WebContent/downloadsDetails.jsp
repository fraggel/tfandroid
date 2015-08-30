<%@include file="header.jsp" %>
<div id="containerLinea">
<%Download download=(Download)reqHelper.getDescargaActual();%>

<b><%=download.getMarcaModelo() %></b><br/><hr/>
<a href="ControlServlet?action=4&detalle=<%=reqHelper.getDetalle()%>&subDetalle=<%=reqHelper.getSubDetalle()%>"><%=RB.getString("home.back") %></a></b><br/><br/><br/>

<br/><br/>
<%if(download.getIntro()!=null){
	if(!"".equals(download.getIntro().trim())){
%>

<%=download.getIntro() %>

<br/>
<br/>
<%}
} %>
<%if(download.getInfo()!=null && download.getFeatures()!=null){
	if(!"".equals(download.getInfo().trim()) && !"".equals(download.getFeatures().trim())){
%>
<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/infoes.png"/></center><br/><br/>

<div id="descarga">
<div id="descargaInfo1" >
<div id="descargaInfo11">
<b><%=RB.getString("rom.info") %></b>
<%=download.parseCampo(download.getInfo()) %>
<b><%=RB.getString("rom.features") %></b>
<%=download.parseCampo(download.getFeatures()) %>
</div>
</div>
<div id="descargaInfo2"><center><img src="<%=download.getUrlimagenPhone()%>"/></center></div>
</div>
<br/>
<br/>
<%}
} %>
<%if(download.getChangelog()!=null){
	if(!"".equals(download.getChangelog().trim())){
%>

<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/changeloges.png"/></center><br/><br/>
<div id="descargaChangelog">
<%=download.parseCampo(download.getChangelog()) %>
</div>
<br/>
<br/>
<%}} %>
<%if(download.getFaq()!=null){
	if(!"".equals(download.getFaq().trim())){
%>
<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/faqes.png"/></center>
<div id="descargaChangelog">
<%=download.parseCampoBR(download.getFaq()) %>
</div>
<br/>
<br/>
<%}} %>
<%if(download.getInstall()!=null){
	if(!"".equals(download.getInstall().trim())){
%>
<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/installationes.png"/></center><br/><br/>
<div id="descargaChangelog">
<%=download.parseCampo(download.getInstall()) %>
</div>
<br/>
<br/>
<%}} %>
<%if(download.getScreenshots1()!=null && download.getScreenshots2()!=null){
	if(!"".equals(download.getScreenshots1().trim()) && !"".equals(download.getScreenshots2().trim())){
%>

<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/screenshotses.png"/></center><br/><br/>
<div id="descargaInfo3">
<img src="<%=download.getScreenshots1()%>"/><br/><br/>
<img src="<%=download.getScreenshots2()%>"/>
</div>
<br/>
<br/>
<%}} %>
<%if(download.getMega()!=null || download.getGdrive()!=null){
	if(!"".equals(download.getMega().trim()) || !"".equals(download.getGdrive().trim())){
%>
<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/downloadses.png" /></center><br/><br/>
<%if(!"".equals(download.getMega().trim())){ %>
<center><%=download.parseCampoMega(download.getMega()) %></center>
<%}%>
<%if(!"".equals(download.getGdrive().trim())){ %>
<center><%=download.parseCampoGdrive(download.getGdrive()) %></center>
<%}%>
<br/>
<br/>
<%}} %>
<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/visituses.png"/></center><br/><br/>

<center><a href="www.tfandroid.es"><img src="http://www.tfandroid.es/images/logonuevo.png" height="50px"/></a>
<a href="http://www.facebook.com/TFAndroidDevelopers" target="_blank"><img src="http://www.tfandroid.es/images/facebook.png" width="50px"/></a><a href="http://twitter.com/TFADevelopers" target="_blank"><img src="http://www.tfandroid.es/images/twiter.png" width="50px"/></a><a href="http://plus.google.com/103304683630993709928" target="_blank"><img src="http://www.tfandroid.es/images/googleplus.png" width="50px"/></a><a href="http://www.youtube.com/user/TeamForceGroup" target="_blank"><img src="http://www.tfandroid.es/images/youtube.png" width="50px"/></a></center>
</br>
</br>
<%if(download.getCredits()!=null){
	if(!"".equals(download.getCredits().trim())){
%>
<center><img id="imgSeparacion" src="http://www.tfandroid.es/images/downloads/creditses.png"/></center><br/><br/>
<div id="descargaChangelog">
<%=download.parseCampo(download.getCredits()) %>
</div>
<br/>
<br/>
<%}} %>
<div>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top"><input name="cmd" type="hidden" value="_s-xclick" /><br />
<input name="hosted_button_id" type="hidden" value="U8RJD58H3MDUG" /><br />
<center><%=RB.getString("download.donate") %>:<br />
<input alt="." name="submit" src="http://www.tfandroid.es/images/downloads/donatees.gif" type="image" width="200px"/><br />
<img src="https://www.paypalobjects.com/es_ES/i/scr/pixel.gif" alt="" width="1" height="1" border="0" /></center></form>

</div>
</div>
</div>
<br/><br/><br/><br/><br/><br/>

<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>
