function commit()
{
	var price=document.getElementById("price").innerHTML; 
     var sightname=document.getElementById("sightname").innerHTML;
     var status="unfinish";
	$.ajax({  
        type: "POST",  
        url: "http://localhost:8080/wust3-travel/servlet/Addorderservlet?sightname="+sightname+"&price="+price+"&status="+status,  
        dataType:"json",
       // data: $('#login_form').serialize(), 
         
          
       
         success: function(data){    
        	
        	//var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
        	
           if(data.status=="1")
        	   alert("订单生成成功");
        	 
          else
        	  alert("订单生成失败");
            	 
         }  
    })  ;    

}
function buy()
{
	var price=document.getElementById("price").innerHTML; 
     var sightname=document.getElementById("sightname").innerHTML;
     var status="finish";
	$.ajax({  
        type: "POST",  
        url: "../servlet/Addorderservlet?sightname="+sightname+"&price="+price+"&status="+status,  
        dataType:"json",
       // data: $('#login_form').serialize(), 
         
          
       
         success: function(data){    
        	
        	//var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
        	
           if(data.status=="1")
        	   alert("购买成功");
        	 
          else
        	  alert("购买失败生成失败");
            	 
         }  
    })  ;    

}