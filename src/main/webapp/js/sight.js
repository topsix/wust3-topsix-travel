function getsight()
{
	 $.ajax({  
         type: "POST",  
         url: "http://localhost:8080/wust3-travel/servlet/Sightservlet",  
         dataType:"json",
        
        
         success: function(data){    
         	
       
                if(data.status=="1")
             	  {
             	         var picture=data.sight.picture;
             	         var price=data.sight.price;
             	         var sightname=data.sight.sightname;
             	         var detail=data.sight.detail;
             	        // alert(username+password+phone);
             	          document.getElementById("price").innerHTML=price; 
                           document.getElementById("sightname").innerHTML=sightname; 
                           document.getElementById("detail").innerHTML=detail; 
                            document.getElementById("image").innerHTML="<img src='"+picture+"' style=\"width: 500px; height: 300px\" />";
                         // document.getElementById("image").innerHTML="<img src='../images/suzhou.jpg'/>";
             	  }
             	  else
             	  {
             	    alert("error");
             	  }
        
             	 
         }  
     })  ;    
}