
function validateform(){
	var name=document.Form.fName.value;
	var password=document.Form.password.value;
	var cPassword=document.Form.cPassword.value;
	var email=document.Form.email.value;
	 var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	 
	 
	if(name==null||name==""&&name.length<=2){
		document.getElementById("n").innerHTML="Name cant't be balnk or less than 3 characters";
		return false;
	}
	else if(email==null||email==""){
		document.getElementById("e").innerHTML="Email can't be left blank";
		return false;
	}
	else if(!email.match(reg)){
		document.getElementById("e").innerHTML="Email is not in correct format";
		return false;
	}
	else if(password==null||password==""){
		document.getElementById("p").innerHTML="Password can't be null";
		
		return false;
	}
	else if(password!=cPassword){
		document.getElementById("cp").innerHTML="Password not matching";
		
		return false;
	}
	
	
	
}
	



