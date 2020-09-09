//下一步
function next(){
var goodname=$.trim($("#goodname").val());
var fhaddress=$.trim($("#fhaddress").val());
var shaddress=$.trim($("#shaddress").val());
var xian1=$("#xian1").val();
window.location.href="/hyfabuxinxi?xian1="+xian1+"&goodname="+goodname+"&fhaddress="+fhaddress+"&shaddress="+shaddress	
}
// 为切换分站

//var toggleCity =document.getElementsByClassName("toggle")[0].getElementsByTagName("span")[0]; 
  //  toggleCity.innerHTML = lc
   // console.log(lc.replace('市', ''))
    var xian1=$("#xian1").val();
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


    // 为发货分类添加样式 鼠标划上的样式
    var ConNav = document.getElementsByClassName("ConNav")[0];
    var kind = document.getElementsByClassName("kind")[0];
    // var dlkind  = kind
    var dd = ConNav.getElementsByTagName("dd");
    for(let i =0;i<dd.length;i++){
        dd[i].onmouseenter = function(){
        	 $.ajax({
                 async:false,
                 url:"/gslist", 
                 type:"get",
                 dataType:"json",
                 success:function(data){
                    //console.log(data)
                     huodeArr = data.data.gslist
                 }
             })
        // console.log(huodeArr[this.id].slist)
            let str="<ul>";
            for(let i=0;i<huodeArr[this.id].slist.length;i++){ 
                str +=`<li><a  href="xinglituoyunOne/${huodeArr[this.id].slist[i].id}/${xian1}.html" id=${huodeArr[this.id].slist[i].id}>${huodeArr[this.id].slist[i].name}</a></li>`
            }
            str +="</ul>"
            kind.innerHTML = str


         let left =  this.clientWidth 
           kind.style.display = "block";
            if(this.offsetTop<778){
               
                let jj = this.offsetTop;
                kind.style.top = jj + "px"; 
                kind.style.left = left + "px"; 
            }else{
                let jj = this.offsetTop- kind.offsetHeight/2;//获取鼠标移上的元素距离top的距离 减去出来的那个元素的高度
                kind.style.top = jj + "px"; //目的让出来的那个好看
                kind.style.left = left + "px"; //目的让出来的那个好看
            }
           kind.onmouseenter = function(){
            kind.style.display = "block";
            dd[i].style.background = "#06c";
            this.onmouseleave = function(){
                kind.style.display = "none";
                dd[i].style.background = "";
            }
           }
            this.onmouseleave = function(){
                kind.style.display = "none";
            }
        }
    }


   
      // 找到货源和车源下面的ul
     var huoyuanUL =  document.getElementsByClassName("huoyuan")[0].getElementsByTagName("ul")[0];
     var cheyuanUL =  document.getElementsByClassName("cheyuan")[0].getElementsByTagName("ul")[0];
           
    //  console.log(huoyuanUL)
    //  console.log(cheyuanUL)
    // 三方的有点特殊 分成两部分一部分为公司，一部分为公司简介   carditem为公司名字  carditem2为公司简介
    var    carditem = document.getElementsByClassName("carditem");
    var    carditem2 = document.getElementsByClassName("carditem2");

     // 零担货运就是同城货运 他的格式更特殊 一共有三级  第一先找到第一级 六个公司
    var changtong = document.getElementsByClassName("changtong");//以共有六个 每一个里面又分两个 ，然后再分
    // console.log(changtong)

    //轮播图
    var carousel = document.getElementsByClassName("carousel")[0];
    var lis = carousel.getElementsByTagName("li");
    var num = document.getElementsByClassName("num")[0];
    var spans = num.getElementsByTagName("span");
    var count = 0;
    function chang(){
        for (var i = 0; i < lis.length; i++) {//遍历所有图片
            lis[i].style.display = 'none';//先让所有图片隐藏
            spans[i].style.background  ="";
                     }
                lis[count].style.display = 'block';//让当前下标的图片显示
                spans[count].style.background = "#000"
                count++;//每次加1
                     if (count == lis.length) {
                             count = 0;
                     }
                 }
    for (var i = 0; i < lis.length; i++) {//遍历所有图片
        (function(i){
            spans[i].onclick=function(){
                 count = i
                 chang()
            }
         })(i)
     }
     var timer = null;
        timer = setInterval(chang,1500)  
    carousel.onmouseover = function () {
          clearInterval(timer);
             }
    carousel.onmouseout = function () {
         timer = setInterval(chang, 1500);
    }
    
   



