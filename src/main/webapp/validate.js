
function validateform(){
	var name=document.Form.fname.value;
	var password=document.Form.password.value;
	var cPassword=document.Form.cPassword.value;
	var email=document.Form.email.value;
	 var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	 
	if(name==null||name==""&&name.length<=2){
		document.getElementById("n").innerHTML="Name cant't be balnk or less than 3 characters";
		return false;
	}
	else if(password!=cPassword){
		document.getElementById("p").innerHTML="password and cpassword must be same";
		return false;
	}
	else if(!email.match(reg)){
		document.getElementById("e").innerHTML="email is not in correct format";
		return false;
	}
	
}


