


//    如果我要改变头部的内容 要不在more。html中改好  要不在下下面的settimeout改变
setTimeout(function(){
    var headLeft =document.getElementsByClassName("toggle")[0].getElementsByTagName("span")[0]; 
    //这个是切换分站的的例子
    console.log(headLeft)
    headLeft.innerHTML = lc;
    // lc是more.html中引用的城市地址
    },20)






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