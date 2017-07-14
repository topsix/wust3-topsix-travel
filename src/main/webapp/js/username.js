//function getQueryString(name) {
//	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
//	var r = window.location.search.substr(1).match(reg);
//
//	if (r != null)
//		return unescape(r[2]);
//	return null;
//}

function getusernamesession()
{
	$
	.ajax({
		type : "POST",
		url : "/wust3-travel/servlet/Usernameservlet",
		dataType : "json",
		success : function(data) {

			if (data.status == "1") {
				var username = data.data;
				document.getElementById("tishi").innerHTML = "<font size='3' color='black'>欢迎"
						+ username + "</font>";
				document.getElementById("greet").innerHTML = "hello  "
						+ username;
				document.getElementById("online").innerHTML = "online";
			} 

		}
	});

}
function update()
{
      var password1=document.getElementById("password1").value;
      
			$.ajax({  
	            type: "POST",  
	            url: "/wust3-travel/servlet/Updateservlet",  
	            dataType:"json",
	            data: $('#update_information').serialize(), 
	          
	              
	           
               success: function(data){    
               	if(data.status=="1")
               	{
               	     
               	      document.getElementById("password").value=password1;
               	       alert("修改成功");	
               	}
	            
                else if(data.status=="0")
               	 
	                 alert("修改失败");	 
	              
	            else
	            {
	               alert("密码输入错误");
	            }
	            }
	        })  ;    
   
   }
function getusername()
{
	  $.ajax({  
          type: "POST",  
          url: "/wust3-travel/servlet/UserServlet",  
          dataType:"json",
          
         
          success: function(data){    
          	
          	//var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
          	
                 if(data.status=="1")
              	  {
              	         var username=data.user.username;
              	           document.getElementById("tishi").innerHTML="<font size='3' color='black'>欢迎"+username+"</font>"; 
                            document.getElementById("greet").innerHTML="hello  "+username; 
                            document.getElementById("online").innerHTML="online";
              	        
              	        // alert(username+password+phone);
              	          document.getElementById("username").value=username; 
                            
                            
              	  }
              	  else
              	  {
              	    alert("失败");
              	  }
         
              	 
          }  
      })  ; 
}
function getuser()
{
	  $.ajax({  
          type: "POST",  
          url: "/wust3-travel/servlet/UserServlet",  
          dataType:"json",
          //data: $('#regUser').serialize(),  
         
          success: function(data){    
          	
          	//var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
          	
                 if(data.status=="1")
              	  {
              	         var username=data.user.username;
              	         var password=data.user.password;
              	         var phone=data.user.phone;
              	        // alert(username+password+phone);
              	          document.getElementById("username").value=username; 
                            document.getElementById("password").value=password; 
                            document.getElementById("phone").value=phone; 
                             document.getElementById("tishi").innerHTML="<font size='3' color='black'>欢迎"+username+"</font>"; 
                            document.getElementById("greet").innerHTML="hello  "+username; 
                            document.getElementById("online").innerHTML="online"; 
              	  }
              	  else
              	  {
              	    alert("失败");
              	  }
         
              	 
          }  
      })  ;    
}
				
		



     