<jsp:include page="theme/header.jsp"></jsp:include>
	<form action="AttorneyLogin" method="post" id="form">
		<h2 align="center">Attorney Login Form</h2>
		
				<%
				
				String queryString = request.getQueryString();
				
				session.removeAttribute("adminid");
				session.removeAttribute("attorneyid");
				
String msg = (String)session.getAttribute("message");
if(msg!=null && !"".equals(msg)){
	session.removeAttribute("message");
%>	
<div class="msg"><%=msg %></div>
	 <script>$('.msg').delay(3000).fadeOut('slow');</script>
<%}%>
		<br />
		<div align="center">	
			<span>Attorney ID : </span>
			<input type="text" name="attorneyid" required="required" class="login-control" placeholder="Enter your Attorney id" />
		</div>	
		<div align="center">
			<span>Password : </span>
			<input type="password" name="password" required="required" class="login-control" placeholder="Enter your Password" />
		</div>
		<div align="center" class="buttons">
			<input class="sub_btn" type="submit" name="submit" value="Submit">
					   <a href="javascript:history.go(-1)" ><input type="button" class="sub_btn" value="Go Back"></a>
<br />
			
		</div>
		
		</form>
<jsp:include page="theme/footer.jsp"></jsp:include>