// 找到 个人中心 和货物中心中的 两个ld    里那个p元素添加点击事件

var ps = document.getElementsByClassName("nav")[0].getElementsByTagName("p");
var dls = document.getElementsByClassName("nav")[0].getElementsByTagName("dl");
console.log(ps)
console.log(dls)

for(let i = 0;i<ps.length;i++){
    ps[i].onclick = function (){
        for(let j = 0;j<dls.length;j++){
            dls[j].style.display="none"
        }
        dls[i].style.display="block";
    }
}