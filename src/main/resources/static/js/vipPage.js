// 找到需要点击的按钮
var  btnA = document.getElementsByClassName("shuaxin")[0].getElementsByTagName("a");
    // btnA中有三个a 分别是 物流币冲值 网站会员充值 运单管理系统
var shuaxin  = document.getElementsByClassName("shuaxin")[0]; // 第一个显示的
var wuliubi  = document.getElementsByClassName("wuliubi")[0]; //物流币冲值 
var huiyuanchongzhi  = document.getElementsByClassName("huiyuanchongzhi")[0]; // 网站会员充值 

var fanhuiOne = document.getElementById("fanhuiOne") //物流币冲值 的返回
var fanhuiTow = document.getElementById("fanhuiTow") //网站会员充值 的返回
btnA[0].onclick = function(){
    shuaxin.style.display = "none";
    wuliubi.style.display = "block";
    fanhui();
}
btnA[1].onclick = function(){
    shuaxin.style.display = "none";
    huiyuanchongzhi.style.display = "block";
    fanhui()
}
// 返回的事件
function fanhui(){
        fanhuiOne.onclick = function(){
        shuaxin.style.display = "block";
        wuliubi.style.display = "none";
    }
        fanhuiTow.onclick = function(){
            shuaxin.style.display = "block";
            huiyuanchongzhi.style.display = "none";
        }
}

// 找到物流币充值的 充值按钮
    var chongzhi = document.getElementsByClassName("btn")[0].getElementsByTagName("div")[0];
// 显示二维码的盒子的父盒子
    var chongzhiMoney = document.getElementsByClassName("chongzhiMoney")[0];

    chongzhi.onclick = function(){
        // 找到物流币充值的 的input 看看有没有数字
    let qian = document.getElementById("qian").value;
    let bianhuichongzhi = document.getElementById("bianhuichongzhi");//二维码盒子中的返回
        if(parseInt(qian)){
            wuliubi.style.display = "none";
            chongzhiMoney.style.display = "block";
            //动态生成 盛放二维码的盒子 和p元素
           let div =  document.createElement("div");
                div.setAttribute("id","tutu")
            let p =  document.createElement("p");
                 p.setAttribute("id","p")
                 p.innerHTML = "微信扫一扫充值"
            chongzhiMoney.appendChild(div)
            chongzhiMoney.appendChild(p)
            // 找到生成的这两个元素等下移除    点击返回地时候移除
        let tutu = document.getElementById("tutu");
        let p1 = document.getElementById("p");
        var companyid=$("#companyid").val();
        console.log(companyid)
        $.ajax({
                    async:false,
                    url:"/createOrder", 
                    data:{
                    "total_fee":qian,
                    "companyid":companyid,
                    },
                    type:"get",
                    dataType:"json",
                    success:function(data){
                    	console.log(data)
                            // console.log(data.data.verifyCode) 这是验证码
                    	 // 显示二维码
                        new QRCode(tutu,{
                                width: 200, //设置宽高
                                height: 200,
                                text: data.message,
                            },
                        );
                            
                    }
                })
           
                // 返回的按钮
                bianhuichongzhi.onclick = function(){
                    chongzhiMoney.style.display = "none";
                    wuliubi.style.display = "block";
                    tutu.remove()
                    p1.remove()
                }       
        }else{
            alert("请输入金额")
        }


      
    }









    // 这是为下面冲1000 冲1500 做的 方案  你先看上免得  下面ll函数之变了一句 92行  money
    // chongzhi.onclick = function(){
    //     ll()
    // }
function ll(money){
        // 找到物流币充值的 的input 看看有没有数字
    let qian = money||document.getElementById("qian").value;
   
    let bianhuichongzhi = document.getElementById("bianhuichongzhi");//二维码盒子中的返回
        if(qian){
            wuliubi.style.display = "none";
            chongzhiMoney.style.display = "block";
            //动态生成 盛放二维码的盒子 和p元素
           let div =  document.createElement("div");
                div.setAttribute("id","tutu")
            let p =  document.createElement("p");
                 p.setAttribute("id","p")
                 p.innerHTML = "微信扫一扫充值"
            chongzhiMoney.appendChild(div)
            chongzhiMoney.appendChild(p)
            // 找到生成的这两个元素等下移除    点击返回地时候移除
        let tutu = document.getElementById("tutu");
        let p1 = document.getElementById("p");

            // 显示二维码
            new QRCode(tutu,{
                    width: 200, //设置宽高
                    height: 200,
                    text: `显示要充入的网址 ${qian}`,
                },
            );
                // 返回的按钮
                bianhuichongzhi.onclick = function(){
                    chongzhiMoney.style.display = "none";
                    wuliubi.style.display = "block";
                    tutu.remove()
                    p1.remove()
                }       
        }else{
            alert("请输入金额")
        }

}



function wlbiup(){
	 var companyid=$("#companyid").val();
     console.log(companyid)
       $.ajax({
                    async:false,
                    url:"/wxbiup", 
                    data:{
                    "id":companyid,
                    },
                    type:"post",
                    dataType:"json",
                    success:function(data){
                    	console.log(data)
                    	if(data.state==200){
                    		alert("刷新成功")
                    		location.href="vipPage"
                    	}else{
                    		alert(data.message)
                    	}
                            
                    }
                })
}















