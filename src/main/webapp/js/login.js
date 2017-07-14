function checkname(username ){ //失去焦点时执行的函数
	 
	
	if(username.value==""){
	   var inner=document.getElementById("userCue");
	   inner.innerHTML="<font color='red'>用户名为空</font>";
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
	  else{
	     var inner=document.getElementById("userCue");
	      inner.innerHTML="";
	  }
}
 function login()
 {
         var username=document.getElementById("u").value;
//            var str=$('#login_form').serialize();
// 		           alert(str);   
    
			$.ajax({  
	            type: "POST",  
	            url: "http://localhost:8080/wust3-travel/servlet/Logservlet",  
	            dataType:"json",
	            data: $('#login_form').serialize(), 
	             
	              
	           
                 success: function(data){    
                	
	            	//var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
	            	
                   if(data.status=="1")
                	   window.location.href="index.html";
                  else
                	 document.getElementById("userCue").innerHTML="<font color='red'>登录失败！</font>";
	                	 
 	            }  
	        })  ;    
    
    }
		