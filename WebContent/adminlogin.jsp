<jsp:include page="theme/header.jsp"></jsp:include>
<h2 align="center">Admin Login Here</h2>
		<%
		
		session.removeAttribute("adminid");
		session.removeAttribute("policeid");
String msg = (String)session.getAttribute("message");
if(msg!=null && !"".equals(msg)){
	session.removeAttribute("message");
%>	
<div class="msg"><%=msg %></div>
	 <script>$('.msg').delay(3000).fadeOut('slow');</script>
<%}%>

	<form action="adminLogin" method="post" id="form">

		<br />
		<div align="center">	
			<span>&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp &nbspAdmin Id: </span>
			<input type="text" name="adminid" required="required" class="login-control" placeholder="please enter adminid"  id="adminid" />
		</div>	
		<div align="center">
			<span>&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp Password :</span>
			<input type="password" name="password" required="required" class="login-control"  placeholder="please enter password"  id="password" />
		</div>
		 
		<div align="center" class="buttons">
			<input class="sub_btn" type="submit" name="submit" value="Submit">
		 <a href="javascript:history.go(-1)" ><input type="button" class="sub_btn" value="Go Back"></a>
			
		</div>
		</form>
		
		
<jsp:include page="theme/footer.jsp"></jsp:include>