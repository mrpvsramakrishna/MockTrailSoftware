/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}


function validateForm(email)
	{
	var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
	  {
	  //alert("Not a valid e-mail address");
	  return false;
	  }
	else{
		return true;
	}
	
	}
$(document).ready(function(){
	
$(".num-only").keypress(function (e) {
    	
        if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
            return false;
        }
    });
  
  $(".not-num").keypress(function (e) {
	  var regex = new RegExp("^[0-9]+$")
	  var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
      if (regex.test(str)) {
    	  e.preventDefault();
          return false;
      }
     // e.preventDefault();
      return true;
  });
  
  $(".not-alpha").keypress(function (e) {
	  var regex = new RegExp("^[a-zA-Z]+$")
	  var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
      if (regex.test(str)) {
    	  e.preventDefault();
          return false;
      }
     // e.preventDefault();
      return true;
  });
    
  $(".alpha-only").keypress(function (e) {
  	var regex = new RegExp("^[a-zA-Z]+$");
      var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
      if (regex.test(str)) {
          return true;
      }
      e.preventDefault();
      return false;
  });
  
  $(".alpha-white").keypress(function (e) {
	  	var regex = new RegExp("^[a-zA-Z ]+$");
	      var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
	      if (regex.test(str)) {
	          return true;
	      }
	      e.preventDefault();
	      return false;
	  });

  
  $(".alpha-num").keypress(function (e) {
	  	var regex = new RegExp("^[a-zA-Z0-9]+$");
	      var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
	      if (regex.test(str)) {
	          return true;
	      }
	      e.preventDefault();
	      return false;
	  });
  
});
