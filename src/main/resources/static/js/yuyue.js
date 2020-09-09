//生成二维码
function craeteQR(top,left,tel){
	let div = document.createElement("div");
	div.setAttribute("id","remove")
	div.style.background="#ff552e"
		div.style.position = "absolute";
	div.style.height="140px";
	div.style.width ="140px";
	div.style.boxSizing="border-box"
		div.style.padding = "10px"
			div.style.top=top-160;
	div.style.left=left-70;
	document.body.appendChild(div)

	var qrcode = new QRCode(
			//二维码存放的div
			document.getElementById("remove"), {
				width: 120, //设置宽高
				height: 120,
				text: "http://ceshi.56114.com/1.html?id="+tel,
			}
	);
	//根据input框的值生成二维码
	//qrcode.makeCode("手机号为："+tel);
}
//移除二维码
function removeDiv(){
	let div = document.getElementById("remove");
	div.remove()
}
//验证码，电话,公司id
var yanzhma='',dianhua='',rid=0, companyid=0, compname='', shphone='';
//为联系商家添加移上去的事件
var shangjia = document.getElementsByClassName("shangjia");
let numQR= 0;
for(let i=0;i <shangjia.length;i++){
	shangjia[i].getElementsByTagName("a")[0].onmouseenter = function(e){
		let tel = this.getAttribute("tel");
		if(tel==null) tel='4000056114';
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

//预约发货添加点击去的事件
function mianfeiyuyue(){
    var ddd = new Date();
    var day =ddd.getDate();
    if(ddd.getMonth()<10){
    var month = "0"+(ddd.getMonth()+1); 
    }
    if(ddd.getDate()<10){
    day = "0"+ddd.getDate(); 
    }
    var datew = ddd.getFullYear()+"-"+month+"-"+day;
    var datew = datew.toString();
    $("#data").val(datew);

let dianji = document.getElementById("dianji");
let hide = document.getElementsByClassName("hide")[0];
console.log(dianji)
    dianji.addEventListener("click",function(){
        this.style.color == "blue"?this.style.color ="black":this.style.color="blue";
        this.style.color == "blue"?this.innerHTML="隐藏货物信息":this.innerHTML="添加货物信息";
        this.style.color == "blue"?hide.style.display = "block":hide.style.display = "none";
    },false)
}
//点击预约发货弹出盒子
//预约发货添加点击去的事件
// 点击预约发货弹出盒子
var yuyue =document.getElementsByClassName("yuyue");
// console.log(yuyue)
        // 找到要显示的东西
var Order  = document.getElementsByClassName("Order")[0];
        for(let i=0;i<yuyue.length;i++){
          yuyue[i].onclick=function(){
            Order.style.display = "block";
            let tel = this.getAttribute("data-tel");
            let name = this.getAttribute("data-name");
             companyid=this.getAttribute("companyid");
            console.log(companyid)
           
             rid = this.getAttribute("rid");
             
             console.log(rid)
            if(rid==null){
            	
            	ridhtml=`<label for="tel">
            	手机号：<input type="text" placeholder="请输入手机号" id="tel" style="width:110px ">
            	</label>
            	<label for="duanxin0">
            	短信验证码：<input type="text" placeholder="请输入验证码" id="duanxin"><span id="code" class="">获取短信验证码</span>
            	</label>
            	</div>
            	
            	`
            }else{
            	ridhtml=`
            	</div>
            	`
            }
            Order.innerHTML = `
                          <div class="xinxi">
            免费预约发货，可以发表评价、在线投诉
            <span>X</span>
          </div>
          <div class="message">
            <h3 >${name}</h3>
            <h4>河南省郑州市 - 广东省深圳市</h4>
            <p>线路经理电话：${tel}</p>
            <hr>
            <label for="data">
              预约时间：<input type="date" id="data">
              <em id="dianji">添加货物信息</em> 
            </label>
            <div class="hide" style="display: none;">
                  <p>
                    货物名称：<input type="text" name="name" id="name" style="width: 90px;">
                    总件数：<input type="text" name="zongshu" id="zongshu">
                  </p>  
                  <p>
                      货物总重量：<input type="text" name="gomgjin" id="weight">吨
                      货物总体积：<input type="text" name="lifang" id="volume">方
                  </p>
            </div>
            ${ridhtml}
            <div class="queren">
        	<div id=${name} txt=${tel} >确认</div>
        	</div>
            `
            let spanX = Order.getElementsByTagName("span")[0];//为X做点击事件
            spanX.onclick=function(){
           Order.style.display = "none"
                     }
          mianfeiyuyue()//这个表格生成出来为添加信息 添加点击事件
          let code = document.getElementById("code");//短信验证码btn
          let panduan = true;
          if(rid==null){
        	  
          
              code.onclick=function(){
              	let telValue = document.getElementById("tel").value;//获得手机号是否为空
                  let reg = /^1[3456789]\d{9}$/;
                  if(panduan&&reg.test(telValue)){
                    this.classList.add( "class","ban")
                    panduan=false;
                    codeTel(telValue)  // 写入请验证码请求
                    daojiashi(this);//留下多有才可以再次验证
                    dianhua=telValue;
                  }else if(!reg.test(telValue)){
                    console.log(reg.test(telValue))
                    console.log(2)
                    alert("请填写正确手机号")
                  }
              } 
          }
              // 判断多少秒可以再次刷新
              function daojiashi(oneself){
                let timer= null;
                let num = 60;
                timer =setInterval(function(){
                  oneself.innerHTML = num--+"可以再次发送";
                  if(!num){
                    clearInterval(timer)
                    oneself.classList.remove("ban");
                    oneself.innerHTML="获取短信验证码";
                    panduan = true
                  }
                },1000)
                
              }
              //提交订单
              tijao()
          }
        }


//获取验证码
function codeTel(Tel){
	$.ajax({
		"url":'smsXxs',
		"data":{
			"phone":Tel,
		},  
		"type":"post",
		"dataType":"json",
		"success":function(json){
			console.log(json.data.status)
			console.log(json.data.verifyCode)
			yanzhma=json.data.verifyCode;

		}
	});
}
//确认
function tijao(){
let queren = document.getElementsByClassName("queren")[0].getElementsByTagName("div")[0];
  queren.onclick = function(){
	console.log("确认")
    let  Order2 = document.getElementsByClassName("Order2")[0];
    let  Order3 = document.getElementsByClassName("Order3")[0];
    let  Order = document.getElementsByClassName("Order")[0];
    let  guanbi = document.getElementsByClassName("guanbi");
  //  let duanxin = document.getElementById("duanxin");
    console.log(rid)
    var data=$("#data").val();
    console.log(data)
    var goodsname=$("#name").val();
    var goodsnum=$("#zongshu").val();
    var weight=$("#weight").val();
    var volume=$("#volume").val();
    compname= $(this).attr("id");
    shphone=$(this).attr("txt");
   console.log(compname)
    console.log(shphone)
   if(rid==null){//未登录
	console.log(yanzhma);
	if(dianhua==''){
		alert("请填写手机号")
	}else{
		console.log(dianhua);
		var shuyan=$("#duanxin").val();
		console.log(shuyan);
		if(yanzhma==shuyan){
			console.log("注册，登录后台")
			//注册，登录后台
			$.ajax({
				"url":'yuyuefOrder',
				"data":{
					"fhphone":dianhua,
					"xian1":xian1,
					"fhaddress":chufa,
					"shaddress":daoda,
					"goodsname":goodsname,
					"companyid":companyid,
					"goodsnum":goodsnum,
					"weight":weight,
					"volume":volume,
					"data":data,
					"compname":compname,
					"shphone":shphone,
				},  
				"type":"post",
				"dataType":"json",
				"success":function(json){
					console.log(json)
					//location.href='/vipPage?id='+ companyid
				}
			});
			 Order2.style.display = "block";
		       Order3.style.display = "block";
		        for(let i = 0 ;i<guanbi.length;i++){
		            guanbi[i].onclick = function(){
		              Order2.style.display = "none";
		              Order3.style.display = "none";
		              Order.style.display = "none"; //把那个大的也弄掉
		            }
		          }
			
		}else{
		     alert("验证码不正确")
	    }


	}
	
	
   }else{
	   console.log("已登录预约")
	 //注册，登录后台
		$.ajax({
			"url":'yuyuefOrdertwo',
			"data":{
				"rid":rid,
				"xian1":xian1,
				"fhaddress":chufa,
				"shaddress":daoda,
				"companyid":companyid,
				"goodsname":goodsname,
				"goodsnum":goodsnum,
				"weight":weight,
				"volume":volume,
				"data":data,
				"compname":compname,
				"shphone":shphone,
			},  
			"type":"post",
			"dataType":"json",
			"success":function(json){
				console.log(json)
				//location.href='/vipPage?id='+ companyid
			}
		});
	   Order2.style.display = "block";
       Order3.style.display = "block";
        for(let i = 0 ;i<guanbi.length;i++){
            guanbi[i].onclick = function(){
              Order2.style.display = "none";
              Order3.style.display = "none";
              Order.style.display = "none"; //把那个大的也弄掉
            }
          }
	   
	   
   }
	
	
	
	
	
	
	
	
	
  }
}

