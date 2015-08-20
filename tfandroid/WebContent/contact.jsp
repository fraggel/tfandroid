<%@include file="header.jsp" %>
<%@include file="right.jsp" %>
<form action="ControlServlet" method="post">

<input type="hidden" name="action" value="21" />
<b><%=RB.getString("menu.contact") %></b><br/><br/>
<%if (request.getParameter("error")!=null){
	if(!"-1".equals(request.getParameter("error"))){
		if("0".equals(request.getParameter("error"))){
			%><p id="success"><%=RB.getString("mail.error0") %></p><%
		}else if("1".equals(request.getParameter("error"))){
			%><p id="error"><%=RB.getString("mail.error1") %></p><%
		}else if("2".equals(request.getParameter("error"))){
			%><p id="error"><%=RB.getString("mail.error2") %></p><%
		}
	}
} %><br/>
<%=RB.getString("mail.name") %>: <br/><input type="text" name="name"><br/><br/>
<%=RB.getString("mail.email") %>: <br/><input type="text" name="email"><br/><br/>
<%=RB.getString("mail.problem") %>: <br/><select name="emailTo">
<option value=""><%=RB.getString("mail.emailTo") %></option>
<option value="0"><%=RB.getString("mail.emailTo0") %></option>
<option value="1"><%=RB.getString("mail.emailTo1") %></option>
<option value="2"><%=RB.getString("mail.emailTo2") %></option>
</select><br/><br/>
<%=RB.getString("mail.text") %>: <br/><textarea name="message" rows="30" cols="100"></textarea><br/><br/>
<input type="submit" name="enviar" value="<%=RB.getString("mail.send") %>"/><br/><br/>
</form>
<br/>
<br/>
<br/>
<%=RB.getString("mail.manualContact1") %><br/><br/>
<%=RB.getString("mail.manualContactEmail1") %><br/>
<a href="mailto:tfandroid@tfandroid.es">tfandroid@tfandroid.es</a><br/>
<%=RB.getString("mail.manualContactEmail2") %><br/>
<a href="mailto:contacto@tfandroid.es">contacto@tfandroid.es</a><br/>
<%=RB.getString("mail.manualContactEmail3") %><br/>
<a href="mailto:web@tfandroid.es">web@tfandroid.es</a><br/><br/><br/><br/><br/>
<%@include file="footer.jsp" %>
