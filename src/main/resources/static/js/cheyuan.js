//发布车源
function addcar(){
	var flag=true;
	var city=$.trim($("#ddd").val());
	if(city==''){
		flag=false;
		alert("请填写出发地")
		return;
	}
	var destination=$.trim($("#shouhuo").val());
	if(destination==''){
		flag=false;
		alert("请填写到达地")
		return;
	}
	var lianxiren=$.trim($("#lianxiren").val());
	if(lianxiren==''){
		flag=false;
		alert("请填写联系人")
		return;
	}
	var phone=$.trim($("#phone").val());
	if(phone==''){
		flag=false;
		alert("请填写车主电话")
		return;
	}
	
	
	var carLicense=$.trim($("#carLicense").val());
	if(carLicense==''){
		flag=false;
		alert("请填写车牌号")
		return;
	}
	var remark=$.trim($("#remark").val());
	var type=$('#type option:selected').val();
	var chang=$('#chang option:selected').val();
	var xian1=$.trim($("#dddid").val());
	console.log(xian1)
	if(flag){
		
		$.ajax({
			"url":'addcar',
			"data":{
				"phone":phone,
				"type":type,
				"chang":chang,
				"city":city,
				"destination":destination,
				"carLicense":carLicense,
				"remark":remark,
				"xian1":xian1,
				"lianxiren":lianxiren,
			},  
			"type":"post",
			"dataType":"json",
			"success":function(json){
				if(json.state==200){
					alert("发布成功！");
					location.href="";
				}else {
					alert(json.message);
				}
				
			}
		});
	}
}





//生成二维码
function craeteQR(top,left,tel){
	let div = document.createElement("div");
	div.setAttribute("id","remove")
	div.style.background="#ff552e"
		div.style.position = "absolute ";
	div.style.height="140px";
	div.style.width ="140px";
	div.style.boxSizing="border-box"
		div.style.padding = "10px"
			div.style.top=top-160;
	div.style.left=left-70;
	// console.log(div)
	document.body.appendChild(div)
	var qrcode = new QRCode(
			//二维码存放的div
			document.getElementById("remove"),{
				width: 120, //设置宽高
				height: 120,
			    text: "http://ceshi.56114.com/1.html?id="+tel,
			},
	);
	//根据input框的值生成二维码
	//qrcode.makeCode("手机号为："+ tel);
}
//移除二维码
function removeDiv(){
	let div = document.getElementById("remove");
	div.remove()
}


var shangjia = document.getElementsByClassName("TelQR");
let numQR= 0;
for(let i=0;i <shangjia.length;i++){
	shangjia[i].getElementsByTagName("a")[0].onmouseenter = function(e){
		let tel = this.getAttribute("tel");
		let y = e.pageY;
		let x = e.pageX;
		if(!numQR){
			craeteQR(y,x,tel);
			numQR++
		}
		this.onmouseleave = function(){
			removeDiv();
			numQR = 0
		}
	}
}
