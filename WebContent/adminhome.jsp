<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.app.db.DatabaseUtil"%>
<jsp:include page="theme/header.jsp"></jsp:include>

	<h1 align="center">Welcome to Admin</h1>
		<%
String msg = (String)session.getAttribute("message");
if(msg!=null && !"".equals(msg)){
	session.removeAttribute("message");
%>	
<div class="msg"><%=msg %></div>
	 <script>$('.msg').delay(3000).fadeOut('slow');</script>
<%}%>
<div align="center">
		  <a href="logout.jsp"><input type="button" class="sub_btn" value="Logout" ></a>
	</div>	   
		    
		   

<jsp:include page="theme/footer.jsp"></jsp:include>