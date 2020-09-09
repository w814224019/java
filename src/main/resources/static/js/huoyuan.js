//发布货源
function addfOrder(){
	var flag=true;
	var fhaddress=$.trim($("#ddd").val());
	if(fhaddress==''){
		flag=false;
		alert("请填写发货地")
		return;
	}
	var shaddress=$.trim($("#shouhuo").val());
	if(shaddress==''){
		flag=false;
		alert("请填收货地")
		return;
	}
	var fhuser=$.trim($("#fahuoren").val());
	if(fhuser==''){
		flag=false;
		alert("请填写发货人")
		return;
	}
	var fhphone=$.trim($("#fahourenTel").val());
	if(fhphone==''){
		flag=false;
		alert("请填发货人电话")
		return;
	}
	
	var goodsname=$.trim($("#huoName").val());
	if(goodsname==''){
		flag=false;
		alert("请填写货物名称")
		return;
	}
	var weight=$.trim($("#huoWeight").val());
	var volume=$.trim($("#huoVolume").val());
	var chetype=$('#type option:selected').val();
	var chang=$('#chang option:selected').val();
	var xian1=$.trim($("#dddid").val());
	console.log(xian1)
	if(flag){
		
		$.ajax({
			"url":'addfOrder',
			"data":{
				"fhaddress":fhaddress,
				"shaddress":shaddress,
				"fhuser":fhuser,
				"fhphone":fhphone,
				"goodsname":goodsname,
				"weight":weight,
				"xian1":xian1,
				"volume":volume,
				"chetype":chetype,
				"chang":chang,
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
                        width: 120, //璁剧疆瀹介珮
                        height: 120,
                        text: "http://ceshi.56114.com/1.html?id="+tel,
                    },
                );
	//根据input框的值生成二维码
        // qrcode.makeCode("手机号为："+tel);
}
//移除二维码
function removeDiv(){
    let div = document.getElementById("remove");
    div.remove()
}


    var shangjia = document.getElementsByClassName("moreTel");
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



