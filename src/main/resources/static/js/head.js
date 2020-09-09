     // 最上面的切换分站


     var toggle = document.getElementsByClassName("toggle")[0];

     var toggleCity = document.getElementById("toggleCity");
             var citywrite='<ul><li><a href="/"  class="action">首页</a></li>';
             for(let i=0;i<cityData.length;i++){
                 citywrite+=`<li><a target="_blank" href="/fenzhan/${cityData[i].code}.html" id=${cityData[i].code}>${cityData[i].name}</a></li>`
             }
             citywrite+="</ul>";
             toggleCity.innerHTML = citywrite
        toggle.onmouseenter = function(){
         toggleCity.style.display="block";
             toggle.style.color = "white"
             toggle.style.background = " #ff6000"

             this.onmouseleave = function(){
                 toggleCity.style.display="none";
                 toggle.style.color = "black"
                 toggle.style.background = "none";


                 toggleCity.onmouseenter= function(){
                     toggleCity.style.display="block";
                     toggle.style.color = "white"
                     toggle.style.background = "#ff6000"
                 }
             }
         toggleCity.onmouseleave = function(){
                 toggleCity.style.display="none";
                 toggle.style.color = "black"
                 toggle.style.background = "none "
             }
     }     
     



// 为导航上面更多添加点击事件
var morecity = document.getElementById("morecity");
var overhidden = document.getElementsByClassName("overhidden")[0]
var nanshou = document.getElementById("nanshou");
var yunshuhidden = document.getElementsByClassName("yunshuhidden")[0]
    morecity.onclick = function(){
        overhidden.style.display == "block"?overhidden.style.display = "none":overhidden.style.display = "block"
    }
    nanshou.onclick = function(){
        yunshuhidden.style.display == "block"?yunshuhidden.style.display = "none":yunshuhidden.style.display = "block"
    }







 // 为左上面的公司更改输入框
    var gongsi = document.getElementsByClassName("headCenter")[0].getElementsByTagName("div")[0].getElementsByTagName("li")[1];
    var gongsili = document.getElementsByClassName("headCenter")[0].getElementsByTagName("div")[0].getElementsByTagName("li");
    var input = document.getElementsByClassName("input")[0];
    var input1 = document.getElementsByClassName("input1")[0];
     for(let i=0;i<gongsili.length;i++){
         if(i==1){
            gongsili[i].onclick = function(){
                input.style.display="none";
                input1.style.display="block";
            }
         }else{
            gongsili[i].onclick = function(){
                input.style.display="block";
                input1.style.display="none";
                input.removeAttribute("style")
            }
         }
        
     }
     
     
   //根据公司名称搜索
     function serch(){
    	 var xian1=$("#xian1").val()
    	  var come=$("#come").val()
    	  if(come==""){
    		  alert("请输入公司名称")
    	  }else{
    		  window.location.href="fconame?name="+come+"&xian1="+xian1
    	  }
    	 console.log("搜索")
     }

     
     
     
     
     
     
     
     
     
