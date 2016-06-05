
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="es.tfandroid.utils.RequestHelper"%>
<html>
<head>
<link rel="stylesheet" href="http://www.tfandroid.es/images/css/styles.css">
<script src="http://www.tfandroid.es/images/js/scripts.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TF Android Developers</title>
</head>
<body>
<%RequestHelper reqHelper=(RequestHelper)request.getAttribute("requestHelper");%>
<center><div><img src="http://www.tfandroid.es/images/logonuevo.png"/></div></center>
<br/><br/>
<div id="contentwrapper">
<div id="contentcolumn">

<div class="innertube"><center><br/><br/><br/><br/><br/>ERROR has occurred<br/>
<a href="ControlServlet?action=0">Back to TF Android Developers</a></center></div>
<%if(reqHelper.getE()!=null){
    StringWriter sw = new StringWriter();
    reqHelper.getE().printStackTrace(new PrintWriter(sw));
    String exceptionAsString = sw.toString();
    %><%= exceptionAsString%><%
} %>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>