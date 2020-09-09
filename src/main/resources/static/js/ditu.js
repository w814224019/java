

var inpid=0;

var prpr;

var prprcolor;

$(document).ready(function(){

	$(".tg1_item img").css("width","100%");

	/*more-begin*/

	/*  $(".tuiguang1 .hd").append("<a href='#' class='hd_a'>更多>></a>");

    $(".baojia .hd").append("<a href='#' class='hd_a'>更多>></a>")

   

   $(".hd_a:eq(0)").attr('href','http://www.56114.net.cn/zx/6_111_l2.html');

    $(".hd_a:eq(1)").attr('href','http://www.56114.net.cn/zx/6_111_l1.html');

    $(".hd_a:eq(2)").attr('href','http://huoyun.56114.net.cn/yj/6_111.html');*/

    $(".tuiguang1:eq(0) .hd div:eq(0)").css('width','auto');

    $(".tuiguang1:eq(1) .hd div:eq(0)").css('width','auto');

    $(".baojia .hd div:eq(0)").css('width','auto');

	/*more-end*/

	

	 $("body").on('click','.more-a',function(){

		$(this).siblings("dl").toggleClass("arrow1");

		$(this).hide();

	});

	

	  $("body").on('mouseenter','.list-memu dd',function(){

		  $(this).css("background-color","#4082e6");

		  $(this).children(".list-one").css("color","#fff");

		   $(this).children("p").children("a").css("color","#fff");

		   prpr=$(this).children(".list-one").attr("id2");

		  prprcolor= $("path[id2="+prpr+"]").attr("fill");

		  $("path[id2="+prpr+"]").attr("fill","yellow");

		  });

	  $("body").on('mouseleave','.list-memu dd',function(){

		   $(this).css("background-color","#fff");

		  $(this).children(".list-one").css("color","#df0000");

		   $(this).children("p").children("a").css("color","#666");

		    $("path[id2="+prpr+"]").attr("fill",prprcolor);

		  });

    var provincecolor1;

    var provinceid1; 

	var provincecolor2;

    var provinceid2; 

	var ptxt;

   /* $("body").on('mouseenter','.xian',function(){

	 provinceid2= $(this).attr("id2");

	 ptxt=$("body").find($("path[id2="+provinceid2+"]")).length;



	if(ptxt!='0'){

       provincecolor2= $("path[id2="+provinceid2+"]").attr("fill");

       $("path[id2="+provinceid2+"]").attr("fill","yellow");

	}else{

       provinceid1=$(this).parent().siblings(".list-one").attr("id2");

       provincecolor1= $("path[id2="+provinceid1+"]").attr("fill");

       $("path[id2="+provinceid1+"]").attr("fill","yellow");

				}



				

      }); 

    

      $("body").on('mouseleave','.xian',function(){

		  if(ptxt!='0'){

			   $("path[id2="+provinceid2+"]").attr("fill",provincecolor2);

		  }else{

			   $("path[id2="+provinceid1+"]").attr("fill",provincecolor1);

				  }

    });*/
    var provincecolor;
    var provinceid; 
      $("body").on('mouseenter',"#WTMap_Main path,#WTMap_Main span",function(){
         provinceid= $(this).attr("id2");
		 pclass=$("body").find($(".xian[id2="+provinceid+"]")).length;
		 if(pclass!="1"){
	          $("a[id2="+provinceid+"]").parent("dd").css("background-color","#4082e6");

			  $("a[id2="+provinceid+"]").css("color","#fff");

		      $("a[id2="+provinceid+"]").siblings("p").children().css("color","#fff");

			 }

		

       provincecolor= $("path[id2="+provinceid+"]").attr("fill");

       $("path[id2="+provinceid+"]").attr("fill","yellow");



      }); 

    

      $("body").on('mouseleave',"#WTMap_Main path,#WTMap_Main span",function(){

      $("path[id2="+provinceid+"]").attr("fill",provincecolor);

		 if(pclass!="1"){

	   $("a[id2="+provinceid+"]").parent("dd").css("background-color","#fff");

	    $("a[id2="+provinceid+"]").css("color","#df0000");

		 $("a[id2="+provinceid+"]").siblings("p").children().css("color","#666");

		 }

    });
      var provinceids;

      var provincename;

	 $(".c-close").on('click',function(){

		 $(".m-bottom dl").removeClass("arrow1").addClass("arrow");

				$(".more-a").show();

	 	$("#china_map,.m-box").hide();

	 	$(".theme-popover-mask").hide();

	 })

	$(".zx_cfd_inp,.zx_ddd_inp,.inp_zx_ddd,.inp_zx_cfd").click(function(){
		cdid=$(this).attr("id");

/*		if(cdid=="cfd"){ 

			$("#cfdid").val("");

		}

		else if($(cdid=="ddd")){ 

			$("#dddid").val("");

		}

		else if($(cdid=="cfd1")){ 

			$("#dddid").val("");

		}

		else if($(cdid=="ddd1")){ 

			$("#dddid").val("");

		};*/
		if($("#zhendiv").length>0)
		{
		  $("#zhendiv").hide();
		}

		$(".theme-popover,#zhens").hide();
		$("#cityname").val("");
		$(".search_citylist").hide();
			 

		var gjson="";

		gjson+="<div class='m-top'><h1>二、国际线路：</h1></div>";

		

		for( m=0;m<5;m++){

		gname=guojijson[m].zname;

		gjson+="<div class='m-bottom'>";

		gjson+="<span >"+gname+"</span>";

		gjson+="<dl class='arrow'>";

		gnamearr=guojijson[m].guojia.split("|");

			for (  w=0;w<gnamearr.length;w++){

				

		var xarr1=gnamearr[w].split("_");

		gjson+="<dd><a href='javascript:;' id2="+xarr1[1]+">"+xarr1[0]+"</a> </dd>";

		

			

			}

			gjson+="</dl>";

			gjson+="<a class='more-a' href='javascript:;'>更多>></a>"

			gjson+="</div>";

			}

		

		$(".m-box").html(gjson);

		

		if (navigator.appName === 'Microsoft Internet Explorer') { //判断是否是IE浏览器

		var DEFAULT_VERSION7 = 7.0;

		var DEFAULT_VERSION8 = 8.0;

		var ua = navigator.userAgent.toLowerCase();

		var isIE = ua.indexOf("msie")>-1;

		var safariVersion;

		if(isIE){

			safariVersion =  ua.match(/msie ([\d.]+)/)[1];

			}

			if(safariVersion <= DEFAULT_VERSION7 ){

				alert("版本太低，请选择其他浏览器！")

				}

		else if(safariVersion == DEFAULT_VERSION8 ){

	    $("#china_map img").show();

		$("#china_map label").hide();

		$(".warning").show();

 		$(".china-mapbox").html(cmap);

		inpid=$(this).attr("id");

		$(".theme-popover-mask").css("height",$(document).height()).show();

		$("#china_map,.m-box").show();

		}

        else{

			$(".china-mapbox").html(cmap);

		inpid=$(this).attr("id");

		$(".theme-popover-mask").css("height",$(document).height()).show();

		$("#china_map,.m-box").show();

			}

		}

		else{

		$(".china-mapbox").html(cmap);

		inpid=$(this).attr("id");

		$(".theme-popover-mask").css("height",$(document).height()).show();

		$("#china_map,.m-box").show();

		}

		});

	$(".close").click(function(){

			$("#china_map,.m-box").show();

		$(".theme-popover,#shi,#xian,#zhen").hide();

		});

	$('body').on('click', '.zhentitle_right', function() {

		$("#zhen").hide();

	});

	$('body').on('click', '#china_map span,#china_map path', function() {

		provinceids= $(this).attr("id2");

		$("#china_map,.m-box").hide();

        // small-map-begin

		for(var i=0;i<arr1.length;i++){

			if(arr1[i]==provinceids){

				$("#province_maps").html(arr[i]);

			}

		}



		// small-map-end

		 provincename= $("span[id2="+provinceids+"]").text()

         $("#txtWTMapSearch").val(provincename);

      

		cityid=$(this).attr("id");

		princeid=$(this).attr("id2");

		$(".prince-a").text($(this).attr("txt"));

		$(".prince-a").attr("id2",princeid);

	

		

		if (cityid=="closesheng"){

			$('#div_map_hw,.theme-popover-mask,.theme-popover,#china_map,.m-box').hide();

			}

		else if (cityid=="am" || cityid=="xg" || cityid=="tw" || cityid=="dy" || cityid=="ss"){

			$("#"+inpid).val($(this).attr("txt"));

			$("#"+inpid+"id").val($(this).attr("id2"));

			$('.theme-popover-mask,.theme-popover,#div_map_hw,#china_map,.m-box').hide();

		}

		else{

			$("#china_map,.m-box").hide();

			$(".theme-popover").css("display","block");

			$(".theme-poptit").css("display","block");

			var citystr="";

			for (i=0;i<31;i++){

				sname=cityjson[i].sname;

				spy=cityjson[i].spy;

				if (cityid==spy){

					

					snamearr=sname.split("_")

					citystr += "<div class='list-memu' id='list-memu'><dl>";

					for (j=0;j<cityjson[i].shi.length;j++){

						xnamearr=cityjson[i].shi[j].name.split("_");

						citystr+="<dd><a class='list-one' id2="+xnamearr[1]+">"+xnamearr[0]+"</a>";

						citystr+="<p class='ppp'>";

						xstr=cityjson[i].shi[j].xian;

						var xarr=xstr.split("|");

						for(var k=0;k<xarr.length-1;k++){

							xxnamearr=xarr[k].split("_");

							citystr+="<a id2="+xxnamearr[1]+" class='xian' href='javascript:;'>"+xxnamearr[0]+"</a>";

						}

						citystr+="</p>";

						citystr+="</dd>";

					}

					citystr+="</dl></div><div class='shifgx'></div><div class='shifgx1'></div>";

					i=30;

		

		

					if(cityid=="tj"|| cityid=="bj"||cityid=="sh"||cityid=="hi"||cityid=="cq"){

						$(".list-memu  dd").hide();

						$(".theme-popbod #shi").css("overflow","hidden");					

						$(".theme-popover").css("width","850px");

						$("#shi").css("margin-top","125px");

						}else{

							$(".theme-popbod #shi").css("overflow","auto");					

						$(".theme-popover").css("width","1250px");

						$("#shi").css("margin-top","0px");

							}

				}

				

				$("#shi").html(citystr);

				$("#shi").show();

				

	

			}

		}  

		

		$("#shi").append("<a  class='prince-b'></a>");

		$(".prince-b").text($(this).attr("txt"));

		$(".prince-b").attr("id2",princeid);

		if (cityid=="bj" ||cityid=="tj"||cityid=="cq"||cityid=="sh"||cityid=="hi"){$(".prince-b").hide();}

		

		

	});

	

	$('body').on('click', '#shi div dl dd  .xian', function() {

		

		zhenid=$(this).attr("id2");

		zhenname=$(this).text();



		var X = $(this).position().top;

		var Y = $(this).position().left;

		$("#zhen").css({"top":(X+30)+"px","left":(Y-170)+"px"});

		$("#zhen").show();

		var zhenstr="<div class='zhentitle'><div class='zhentitle_left'>请选择</div><a class='az'   id2="+zhenid+">"+zhenname+"</a><div class='zhentitle_right'>关闭</div></div>";

		zhenstr+="<div class='zhenlist'><a id2="+zhenid+" class='zhen' href='javascript:;'>"+zhenname+"</a>";

		var xianxj=0;

		for (j=1;j<zhenjson.length;j++){

			if (zhenid==zhenjson[j].xid){

				xianxj=1;

				if(zhenjson[j].xz==""){

					$("#"+inpid).val($(this).text());

					$("#"+inpid+"id").val($(this).attr("id2"));

					$('.theme-popover-mask,.theme-popover,#div_map_hw,#china_map,.m-box,#zhen').hide();

				}

				else{

					xzarr=zhenjson[j].xz.split("|");

					for(var x=0;x<xzarr.length-1;x++){

						xznamearr=xzarr[x].split("_");

						zhenstr+="<a id2="+xznamearr[1]+" class='zhen' href='javascript:;'>"+xznamearr[0]+"</a>";

					}

					zhenstr+="</div>"

					$("#zhen").html(zhenstr);

					$(".zhen-z").text($(".zhenlist a:eq(0)").text());

					var zzz=$(".zhenlist a:eq(0)").attr("id2");

					$(".zhen-z").attr("id2",zzz);

				}

			}

		}

		if (xianxj==0){

			$("#"+inpid).val($(this).text());

			$("#"+inpid+"id").val($(this).attr("id2"));

			$('.theme-popover-mask,.theme-popover,#div_map_hw,#china_map,.m-box,#zhen').hide();	

		}

	});

	$('body').on('click', '#shi div dl dd .list-one,#zhen .zhen,.zhen-z,.prince-a,.prince-b,#province_maps span,#province_maps path,.m-bottom dl dd a,.az,#xg,#am,#tw', function() {

		 $('html ,body').animate({scrollTop: 0},10);

				$(".m-bottom dl").removeClass("arrow1").addClass("arrow");

				$(".more-a").show();

		$(".theme-popover,#zhen,#shi,#china_map,.m-box,.theme-popover-mask").hide();

		var cityid=$(this).attr("id2");

		$("#"+inpid).val($(this).text());

		if($(this).text()==''){

			$("#"+inpid).val($(this).attr("txt"));

		}

		$("#"+inpid+"id").val(cityid);

		//if (inpid=="ddd"){

			cfd=$("#cfdid").val();

			ddd=$("#dddid").val();

			chufa=$("#cfd").val();

			daoda=$("#ddd").val();
			console.log(cfd)
			console.log(ddd)
			console.log(chufa)
		    console.log(daoda)
			l="";

			ym="www";

			ymdomain="zx";
			fw="";

			if(document.getElementById("l")) 

			{ 

				l=$("#l").val();

			}
			if(document.getElementById("gs")) 

			{ 

				gs=$("#gs").val();
				console.log(gs)

			}
			if(document.getElementById("fw")) 

			{ 

				fw=$("#fw").val();

			}
			if(document.getElementById("ym")) 

			{ 

				ymdomain=$("#ym").val();

				if (ymdomain==""){

					ym="www";

					ymdomain="zx";

				}else{

					ym="huoyun";

					}

			}

			$("#cfd").focus();


			

			if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && l!=""){
				console.log(cfd)
				console.log(ddd)
				
				//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+"_l"+l+".html");
				///complist/6/1/266/13.html
				//window.location="http://"+ym+".56114.net.cn/"+ymdomain+"/"+cfd+"_"+ddd+"_l"+l+".html";

			}else if (cfd==undefined ){
				console.log("zheli")

			}else if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && l==""){
				console.log(cfd)
				console.log(ddd)
				window.location="/complist/"+cfd+"/1/"+ddd+"/"+gs+".html";
				//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+".html");

				//window.location="http://"+ym+".56114.net.cn/"+ymdomain+"/"+cfd+"_"+ddd+".html";

			}
			if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && fw!=""){
				console.log(cfd)
				console.log(ddd)
				//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+"_l"+l+".html");

				//window.location="http://"+ym+".56114.net.cn/"+ymdomain+"/"+cfd+"_"+ddd+"_"+fw+".html";

			}

			/*else if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && fw==""){
				console.log(cfd)
				console.log(ddd)

			}*/

			else{

			 // alert("请选择出发地和到达地！");

			  return false;

			}

		//	}

	});
	var flag = true;
    $('#cityname,.inp_zx_cfd,.inp_zx_ddd').on('compositionstart',function(){
        flag = false;
    });
    $('#cityname,.inp_zx_cfd,.inp_zx_ddd').on('compositionend',function(){
        flag = true;
    });
    // 把他注解掉输入不改变只有提交才该变
/*	$(".inp_zx_cfd").on('input',function(){
		var keywordsbf="";
		setTimeout(function(){
            if(flag){
				var keywords=$(".inp_zx_cfd").val();
				var citylist="";
				if (keywords.length>=1 && keywords!=keywordsbf){
					keywordsbf=keywords;
					$(".search_citylist").show();
					$.ajax({
					  url:"http://www.56114.net.cn/inc/ajaxset.asp?action=searchcity_jsonp",
					  data:{'keywords':escape(keywords)},
					  dataType:"jsonp",
					  jsonp: "callback",   //指定参数名称
					  jsonpCallback: "callback",  //指定回调函数名称
					  success:function(result){
						for(var v in result){
							citylist+="<li city='"+unescape(result[v].longname)+"' cityid='"+result[v].xid+"'>"+unescape(result[v].longname)+"</li>";
						  }
						  $(".search_citylist").html("<ul>"+citylist+"</ul>");
					  }
					});
				}else if(keywords.length==0){
					$(".search_citylist").hide();
				}
            }
        },0);
	});*/
/*	$(".inp_zx_ddd").on('input',function(){
		var keywordsbf="";
		setTimeout(function(){
            if(flag){
				var keywords=$(".inp_zx_ddd").val();
				var citylist="";
				if (keywords.length>=1 && keywords!=keywordsbf){
					keywordsbf=keywords;
					$(".search_citylist").show();
					$.ajax({
					  url:"http://www.56114.net.cn/inc/ajaxset.asp?action=searchcity_jsonp",
					  data:{'keywords':escape(keywords)},
					  dataType:"jsonp",
					  jsonp: "callback",   //指定参数名称
					  jsonpCallback: "callback",  //指定回调函数名称
					  success:function(result){
						for(var v in result){
							citylist+="<li city='"+unescape(result[v].longname)+"' cityid='"+result[v].xid+"'>"+unescape(result[v].longname)+"</li>";
						  }
						  $(".search_citylist").html("<ul>"+citylist+"</ul>");
					  }
					});
				}else if(keywords.length==0){
					$(".search_citylist").hide();
				}
            }
        },0);
	});*/
	$("body").on("click",".search_citylist li",function(){
		var getcity=$(this).attr("city");
		var getxid=$(this).attr("cityid");
		$("#"+inpid).val(getcity);
		$("#"+inpid+"id").val(getxid);
		var cfd=$("#cfdid").val();
		var ddd=$("#dddid").val();
		if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0){
			console.log(cfd)
			console.log(ddd)
			//window.location="http://www.56114.net.cn/zx/"+cfd+"_"+ddd+".html";
		}
		$("#china_map,.m-box").hide();
	 	$(".theme-popover-mask").hide();
	})
});



function zx(){
	console.log("这里")
	cfd=$("#cfdid").val();
	ddd=$("#dddid").val();
	chufa=$("#cfd").val();
	daoda=$("#ddd").val();
	daoda=$("#ddd").val();
	gs=$("#gs").val();
	console.log(cfd)
	console.log(ddd)
	
	l="";
	ym="www";
	ymdomain="zx";
	fw="";
	if(document.getElementById("l")) 
	{ 
		l=$("#l").val();
	}
	if(document.getElementById("fw")) 
	{ 
		fw=$("#fw").val();
	}
	if(document.getElementById("ym"))
	{ 
		ymdomain=$("#ym").val();
		if (ymdomain==""){
			ym="www";
			ymdomain="zx";
		}else{
			ym="huoyun";
			}
	}
	if (cfd=="" || cfd=="undefined"){cfd=getquid(chufa);}
	if (ddd=="" || ddd=="undefined"){ddd=getquid(daoda);}
	window.location="/complist/"+cfd+"/1/"+ddd+"/"+gs+".html";
	if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && l!=""){
		console.log(cfd)
		console.log(ddd)
		//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+"_l"+l+".html");
		//window.location="http://"+ym+".56114.net.cn/"+ymdomain+"/"+cfd+"_"+ddd+"_l"+l+".html";
	}
	else if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && l=="" && fw==""){
		console.log(cfd)
		console.log(ddd)
		//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+".html");
		//window.location="http://"+ym+".56114.net.cn/"+ymdomain+"/"+cfd+"_"+ddd+".html";
	}
	else if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && fw!=""){
		console.log(cfd)
		console.log(ddd)
		//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+"_l"+l+".html");
		//window.location="http://"+ym+".56114.net.cn/"+ymdomain+"/"+cfd+"_"+ddd+"_"+fw+".html";
	}
	else if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && fw==""){
		console.log(cfd)
		console.log(ddd)
		//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+".html");
		//window.location="http://"+ym+".56114.net.cn/"+ymdomain+"/"+cfd+"_"+ddd+".html";
	}
	else{
		//alert("请选择出发地和到达地！");
		return false;
		}
	}
function zx_xin(lx){

	cfd=$("#cfdid").val();

	ddd=$("#dddid").val();

	chufa=$("#cfd").val();

	daoda=$("#ddd").val();

	daoda=$("#ddd").val();

	

	if (cfd=="" || cfd=="undefined"){cfd=getquid(chufa);}

	if (ddd=="" || ddd=="undefined"){ddd=getquid(daoda);}

	if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && lx==1){

		//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+"_l"+l+".html");

		//window.location="http://www.56114.net.cn/zx/"+cfd+"_"+ddd+"_l1.html";

	}

	else if (cfd!='' && ddd!='' && cfd!=0 && ddd!=0 && lx==2){

		

		//console.log("http://"+ym+".56114.net.cn/zx/"+cfd+"_"+ddd+".html");

		//window.location="http://www.56114.net.cn/zx/"+cfd+"_"+ddd+"_l2.html";

	}

	else{

		//alert("请选择出发地和到达地！");

		return false;

		}

	}



$(document).ready(function(){

	$(".yqzkb").toggle(function(){

		$(this).text("收起");

		$(".yuanqu_con").removeAttr("style");

		zhankaizt=getCookie("zhankai");

		/*setCookie("zhankai","true");*/

		$("#cfkeytitle").show();

		$("#cfkeylist").show();

	},

    function(){

		$(this).text("展开");

		$(".yuanqu_con").css("height","28px");

		/*setCookie("zhankai","false");*/

		$("#cfkeytitle").hide();

		$("#cfkeylist").hide();

	});

	zhankaizt="false";

	if (zhankaizt=="true"){

		$(".yqzkb").text("收起");

		$(".yuanqu_con").removeAttr("style");

		$("#cfkeytitle").show();

		$("#cfkeylist").show();

	}

	else if (zhankaizt=="false"){

		$(".yqzkb").text("展开");

		$(".yuanqu_con").css("height","28px");

		$("#cfkeytitle").hide();

		$("#cfkeylist").hide();

	}



	$(".dyqzkb").toggle(function(){

		$(this).text("收起");

		$(".dyuanqu_con").removeAttr("style");

		zhankaizt=getCookie("dzhankai");

		/*setCookie("dzhankai","true");*/

		$("#ddkeytitle").show();

		$("#ddkeylist").show();

	},

    function(){

		$(this).text("展开");

		$(".dyuanqu_con").css("height","28px");

		/*setCookie("dzhankai","false");*/

		$("#ddkeytitle").hide();

		$("#ddkeylist").hide();

	});

	/*dzhankaizt=getCookie("dzhankai");*/
	dzhankaizt="false";

	if (dzhankaizt=="true"){

		$(".dyqzkb").text("收起");

		$(".dyuanqu_con").removeAttr("style");

		$("#ddkeytitle").show();

		$("#ddkeylist").show();

	}

	else if (dzhankaizt=="false"){

		$(".dyqzkb").text("展开");

		$(".dyuanqu_con").css("height","28px");

		$("#ddkeytitle").hide();

		$("#ddkeylist").hide();

	};

	



	$(".ddkeyzk").toggle(function(){



		$(this).text("收起");



		$(".ddkey_con").removeAttr("style");



		ddkeyzhankaizt=getCookie("ddkeyzhankai");



		/*setCookie("ddkeyzhankai","true");*/



	},



    function(){



		$(this).text("展开");



		$(".ddkey_con").css("height","28px");



		/*setCookie("ddkeyzhankai","false");*/



	});



	/*ddkeyzhankaizt=getCookie("ddkeyzhankai");*/
	ddkeyzhankaizt="false";


	if (ddkeyzhankaizt=="true"){



		$(".ddkeyzk").text("收起");



		$(".ddkey_con").removeAttr("style");



	}



	else if (ddkeyzhankaizt=="false"){



		$(".ddkeyzk").text("展开");



		$(".ddkey_con").css("height","28px");



	}



	$(".morezk").toggle(function(){

		$(this).text("收起");

		$(".more_sear").removeAttr("style");

	},

    function(){

		$(this).text("展开");

		$(".more_sear").css("height","45px");

	});

	

	$(".ggzk1").toggle(function(){

		$("#zk1").text("收起");

		$("#ggzkcon1").removeAttr("style");

		$(".ggzk1 div:eq(1)").attr("class","i_icon_t");

	},

    function(){

		$("#zk1").text("展开");

		$("#ggzkcon1").css("height","118px");

		$(".ggzk1 div:eq(1)").attr("class","i_icon_b");

	});

	$(".ggzk2").toggle(function(){

		$("#zk2").text("收起");

		$("#ggzkcon2").removeAttr("style");

		$(".ggzk2 div:eq(1)").attr("class","i_icon_t");

	},

    function(){

		$("#zk2").text("展开");

		$("#ggzkcon2").css("height","118px");

		$(".ggzk2 div:eq(1)").attr("class","i_icon_b");

	});

	$(".ggzk3").toggle(function(){

		$("#zk3").text("收起");

		$("#ggzkcon3").removeAttr("style");

		$(".ggzk3 div:eq(1)").attr("class","i_icon_t");

	},

    function(){

		$("#zk3").text("展开");

		$("#ggzkcon3").css("height","158px");

		$(".ggzk3 div:eq(1)").attr("class","i_icon_b");

	});



	$(".cfkeyzk").toggle(function(){



		$(this).text("收起");



		$(".cfkey_con").removeAttr("style");



		/*cfkeyzhankaizt=getCookie("cfkeyzhankai");*/

		

		/*setCookie("cfkeyzhankai","true");*/



	},



    function(){



		$(this).text("展开");



		$(".cfkey_con").css("height","28px");



		setCookie("cfkeyzhankai","false");



	});



	/*cfzhankaizt=getCookie("cfkeyzhankai");*/

	cfzhankaizt="false";

	/*if (cfkeyzhankaizt=="true"){



		$(".cfkeyzk").text("收起");



		$(".cfkey_con").removeAttr("style");



	}



	else if (cfkeyzhankaizt=="false"){



		$(".cfkeyzk").text("展开");



		$(".cfkey_con").css("height","28px");



	}*/



	



	function setCookie(name,value)



	{



	var Days = 30;



	var exp = new Date();



	exp.setTime(exp.getTime() + Days*24*60*60*1000);



	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();



	}



	function getCookie(name)



	{



	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");



	if(arr=document.cookie.match(reg))



	return unescape(arr[2]);



	else



	return null;



	}



});



function getquid(cfd){

    var temp=0;

	cfd=escape(cfd);

	//$("#cs").html("http://www.56114.net.cn/inc/ajaxset.asp?action=getquid&city="+cfd+"");

    $.ajax({

		url: "http://qun.56114.net.cn/wxqun/getcityid.php?callback=a&action=getquid_jsonp&city="+cfd+"",

		// url : "http://www.56114.net.cn/inc/ajaxset.asp?action=getquid&city="+cfd+"",

        async: true,

        type : "GET",

		 dataType:'jsonp',

		 jsonp: "callback",

        success : function(data) {

            temp=data.cfdid;

			console.log(data.cfdid);

			//$("#cs").html(temp);

        },

		 complete: function(data){

			//$("#cs").html("-1");

           // alert('complete');

        }

    });

	//if (temp>0){

	console.log("a");

   return temp

	//}

}

function addScriptTag(src) {

  var script = document.createElement('script');

  script.setAttribute("type","text/javascript");

  script.src = src;

  document.body.appendChild(script);

}

window.onload = function () {

  //addScriptTag("http://www.56114.net.cn/inc/ajaxset.asp?action=getquid&city="+cfd+"");

}
