<jsp:include page="theme/header.jsp"></jsp:include>
<h1 align="center">Admin Registration</h1>
<%
String msg = (String)session.getAttribute("message");
if(msg!=null && !"".equals(msg)){
	session.removeAttribute("message");
%>	
<div class="msg"><%=msg %></div>
	 <script>$('.msg').delay(3000).fadeOut('slow');</script>
<%}%>
	<form action="AdminRegistration" method="post" class="userform"  id="form">
	
	
	<table  style="width: 700px;margin-left: -50px;">
	<tr>
	<td  >First Name </td><td><input type="text" name="firstname"  id="firstname" class="form-control alpha-only"></td>
	 
	<td  >Last Name </td><td><input type="text" name="lastname" id="lastname" class="form-control"></td>
	</tr>
	 
	 
	 <tr>
	<td>DOB</td><td><input type="text" name="dob" id="dob" class="form-control"></td>
	<td>Gender </td><td><select name="gender" id="gender" class="form-control">
	<option>Male</option>
	<option>Female</option>
	</select>
	</td> 
	</tr>
	 
	 
	 
	 
	<tr>
	<td>Email Id</td><td><input type="text" name="emailid" id="emailid" class="form-control"></td>
	 <td>Admin Id</td><td><input type="text" name="adminid" id="adminid" class="form-control alpha-num"></td>
	</tr>
	<tr>
	<td>Password</td><td><input type="password" name="password" id="password" class="form-control"></td>
	 <td>Confirm Password</td><td><input type="password" name="confirmpassword" id="confirmpassword" class="form-control"></td>
	</tr>
<tr>  
	<td>Select a Security Question</td><td><select name="securityqstn" id="securityqstn" class="select-control" required>
				<option value=''>Select a question?</option>
				<option>what is your mother name?</option>
				<option>what is your father name?</option>
			</select></td> 
	 <td>Security Question Answer</td><td><input type="text" name="securityans" id="securityans" class="form-control"></td>
	</tr>
	 
	
	</table>
		<div align="center" class="buttons">
			<input class="sub_btn" type="submit" id="register"  value="Submit">
			<button class="sub_btn" >Clear</button>
					   <a href="javascript:history.go(-1)" ><input type="button" class="sub_btn" value="Go Back"></a>
			
		</div>
		
	</form>
	
	<script>

	$(document).ready(function(){
		$("#register").click(function(){
				var fname = $("#firstname").val();
				var lname = $("#lastname").val();
				var dob = $("#dob").val();
				var gender = $("#gender").val();
				var emailid = $("#emailid").val();
				var adminid = $("#adminid").val();
				var password = $("#password").val();
				var confirmpassword = $("#confirmpassword").val();
				var adminuniqueid = $("#adminuniqueid").val();
				var securityqstn = $("#securityqstn").val();
				var securityans = $("#securityans").val();

				if(fname=='' || lname=='' || dob==''||gender==''||emailid==''||adminid==''||password==''
					|| confirmpassword==''|| adminuniqueid==''||securityqstn==''||securityans==''){
					alert("All fields are mandatory");
					return false;
				}
				if(validateForm(emailid)==false){
					 alert("Enter a valid email id"); return false;
					 }
				if(password!=confirmpassword){
					alert("Password and Confirm password are not same");
					return false;
				}
		});
	});
		
	</script>
	
<jsp:include page="theme/footer.jsp"></jsp:include>