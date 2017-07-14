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
		url : "../servlet/Usernameservlet",
		dataType : "json",
		success : function(data) {

			if (data.status == "1") {
				var username = data.data;
				document.getElementById("tishi").innerHTML = "<font size='3' color='black'>欢迎"
						+ username + "</font>";
				document.getElementById("greet").innerHTML = "hello  "
						+ username;
				document.getElementById("online").innerHTML = "online";
			} else
				document.getElementById("userCue").innerHTML = "<font color='red'>注册失败！</font>";

		}
	});

}
				
		



     