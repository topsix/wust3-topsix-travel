function register()
    {
    
         //ar user=document.getElementById("user").value;
		 // var pwd=document.getElementById("password").value;  
		  var str=$('#regUser').serialize();
		  alert(str);   
			$.ajax({  
	            type: "POST",  
	            url: "http://localhost:8080/wust3-travel/servlet/Regservlet",  
	            dataType:"json",
	            data: $('#regUser').serialize(),  
	           
                success: function(data){    
                	
	            	//var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
	            	
	                   if(data.status=="0")
	                	   window.location.href="login.html";
                 else
                	 document.getElementById("userCue").innerHTML="<font color='red'>注册失败！</font>";
	                	 
	            }  
	        })  ;    
    
   }

function checkname(username){ //失去焦点时执行的函数	
	if(username.value==""){
	   var inner=document.getElementById("userCue");
	   inner.innerHTML="<font color='red'>用户名为空</font>";
	  }
	else if(username.value.length<4 || username.value.length>16){
		 var inner=document.getElementById("userCue");
		   inner.innerHTML="<font color='red'>用户名必须为4~16位</font>";	
	}
	  else{
	     var inner=document.getElementById("userCue");
	      inner.innerHTML="";
	  }
}

function checkpassword(password){  //失去焦点时执行的函数
	  if(password.value==""){
	   var inner=document.getElementById("userCue");
	   inner.innerHTML="<font color='red'>密码为空</font>";
	  }
	  else if(password.value.length<6){
			 var inner=document.getElementById("userCue");
			   inner.innerHTML="<font color='red'>密码不能低于6位</font>";	
		}
	  else{
	     var inner=document.getElementById("userCue");
	      inner.innerHTML="";
	  }
	  
 }
	  
 function checkpassword2(password2){  //失去焦点时执行的函数
			  var password=document.getElementById("password");
			  if(password2.value != password.value){
			   var inner=document.getElementById("userCue");
			   inner.innerHTML="<font color='red'>密码不一致</font>";
			  }
			  else{
			     var inner=document.getElementById("userCue");
			      inner.innerHTML="";
			  }
		  }
 function checkphone(phone){  //失去焦点时执行的函数
				  if(phone.value==""){
				   var inner=document.getElementById("userCue");
				   inner.innerHTML="<font color='red'>手机号为空</font>";
				  }
				  else if(phone.value.length!=11){
					  var inner=document.getElementById("userCue");
					   inner.innerHTML="<font color='red'>手机号格式不正确</font>";
				  }
				  
				  else{
				     var inner=document.getElementById("userCue");
				      inner.innerHTML="";
				  }
	}
				  
 