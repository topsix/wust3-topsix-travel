function commit()
{
	var price=document.getElementById("price").innerHTML; 
     var sightname=document.getElementById("sightname").innerHTML;
     var status="unfinish";
	$.ajax({  
        type: "POST",  
        url: "/wust3-travel/servlet/Addorderservlet?sightname="+sightname+"&price="+price+"&status="+status,  
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
        url: "/wust3-travel/servlet/Addorderservlet?sightname="+sightname+"&price="+price+"&status="+status,  
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

function order(){
	var i=0;
	$.ajax({  
		 type: "POST",  
		 url: "/wust3-travel/servlet/Allorderservlet?status=unfinish", 
		 dataType:"json",
//		 data: $('#form').serialize(),  
		 success: function(data){    	
		 //var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
	     var list=data.data;
	     var recordstotal=data.recordsTotal;
		 length=list.length;
		 var inn="";
		 
		 inn+="<table><tr><th style=\"width:200px\">orderid</th><th style=\"width:200px\">username</th><th style=\"width:200px\">sightname</th><th style=\"width:200px\">price</th><th style=\"width:200px\">status</th></tr>";
		 for(i;i<recordstotal;i++)
			 {
			 inn+="<tr>";
			 
			 inn+="<td><font color='#9955FF' style=\"width:200px\">"+list[i].orderid+"</font></td>";
			 inn+="<td style=\"width:200px\">"+list[i].username+"</td>";
			 inn+="<td style=\"width:200px\">"+list[i].sightname+"</td>";
			 inn+="<td style=\"width:200px\">"+list[i].price+"</td>";
			 inn+="<td style=\"width:200px\">"+list[i].status+"</td>";
			 inn+="</tr>"; 
			 }
		 inn+="</table>";
		 document.getElementById("showunfinish").innerHTML=inn;
	    }  
	})  ;
}

function orders()
{
	
	var i=0;
	$.ajax({  
		 type: "POST",  
		 url: "/wust3-travel/servlet/Allorderservlet?status=finish", 
		 dataType:"json",
//		 data: $('#form').serialize(),  
		 success: function(data){    	
		 //var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
	     var list=data.data;
	     var recordstotal=data.recordsTotal;
		 length=list.length;
		 var inn="";
		 
		 inn+="<table><tr><th style=\"width:200px\">orderid</th><th style=\"width:200px\">username</th><th style=\"width:200px\">sightname</th><th style=\"width:200px\">price</th><th style=\"width:200px\">status</th></tr>";
		 for(i;i<recordstotal;i++)
			 {
			 inn+="<tr>";
			 
			 inn+="<td><font color='#9955FF' style=\"width:200px\">"+list[i].orderid+"</font></td>";
			 inn+="<td style=\"width:200px\">"+list[i].username+"</td>";
			 inn+="<td style=\"width:200px\">"+list[i].sightname+"</td>";
			 inn+="<td style=\"width:200px\">"+list[i].price+"</td>";
			 inn+="<td style=\"width:200px\">"+list[i].status+"</td>";
			 inn+="</tr>"; 
			 }
		 inn+="</table>";
		 document.getElementById("showunfinish").innerHTML=inn;
	    }  
	})  ;
}
//function 