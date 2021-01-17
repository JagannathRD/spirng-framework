
function validateform(){
	var name=document.Form.fName.value;
	var password=document.Form.password.value;
	var cPassword=document.Form.cPassword.value;
	var email=document.Form.email.value;
	 var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	 
	 
	if(name==null||name==""||name.length<=2){
		document.getElementById("n").innerHTML="Name cant't be balnk or less than 3 characters";
		return false;
	}
	if(name!=null||name!=""||name.length>=3){
		document.getElementById("n").innerHTML="";
		
	}
	 if(email==null||email==""){
		document.getElementById("e").innerHTML="Email can't be left blank";
		return false;
	}
	 if(email!=null||email!=""){
			document.getElementById("e").innerHTML="";
		
		}

	 if(!email.match(reg)){
		document.getElementById("e").innerHTML="Email is not in correct format";
		return false;
	}
	 if(email.match(reg)){
			document.getElementById("e").innerHTML="";
			
		}
	 if(password==null||password==""){
		document.getElementById("p").innerHTML="Password can't be null";
		
		return false;
	}
	 if(password!=null||password!=""){
			document.getElementById("p").innerHTML="";
			
			
		}
	if(password!=cPassword){
		document.getElementById("cp").innerHTML="Password not matching";
		
		return false;
	}
	if(password==cPassword){
		document.getElementById("cp").innerHTML="";
		
		
	}
	
		
	
	
	
	
}
	



