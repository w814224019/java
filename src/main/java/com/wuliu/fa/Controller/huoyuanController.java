package com.wuliu.fa.Controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.User;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.carUser;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.fahRecoreder;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.IUserService;
import com.wuliu.fa.service.IfahRecorederService;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.MD5Utils;
import com.wuliu.fa.util.ResponseResult;

@Controller
public class huoyuanController extends BaseController {
	@Autowired
	private IfahRecorederService fahrecorder;
	@Autowired
	private areaService areservice;
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	IUserService userService;
	
	//已登录预约发货   查询手机号没有 添加发货人    添加发货记录  
	@PostMapping("/yuyuefOrdertwo")
	@ResponseBody
	public ResponseResult<Integer> yuyuefOrdertwo (HttpSession session,String fhuser,String fhphone,String fhaddress,Integer xian1,
			String status,String goodsname,String shaddress,String shphone,String goodsnum,String weight,String volume,
			String chetype,String chang,String remark,Integer companyid,Integer rid,String data,String compname) throws ParseException{
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 Date myDate = format.parse(data);
		fahRecoreder f=new fahRecoreder();
		//查询该条线路是否预约过
		User u=userService.getById(rid);
		f.setUserid(rid);
		f.setFhuser(u.getName());
		//手机号，
		f.setFhphone(u.getMobile());
		f.setFhaddress(fhaddress);
		f.setXian1(xian1);
		f.setGoodsname(goodsname);
		f.setShaddress(shaddress);
		//数量
		f.setGoodsnum(goodsnum);
		f.setWeight(weight);
		f.setVolume(volume);
		f.setCompanyId(companyid);
		f.setChang("");
		f.setStatus("已预约");
		f.setRemark("");
		f.setFhaddress1("");
		f.setShaddress1("");
		f.setShuser("");
		f.setShphone(shphone);
		f.setTimeout(myDate);
		f.setChetype("");
		f.setCompname(compname);
		f.setTracking(System.currentTimeMillis()+"");
		fahrecorder.addfOrder(f);
		//		if(redisUtil.hasKey("huoyuan"+xian1)){
		//			redisUtil.del("huoyuan"+xian1);
		//		}
		return new ResponseResult<Integer>(SUCCESS);

	}
	//未登录预约发货   查询手机号没有 添加发货人    添加发货记录  
	@PostMapping("/yuyuefOrder")
	@ResponseBody
	public ResponseResult<Integer> yuyuefOrder (HttpSession session,String fhuser,String fhphone,String fhaddress,Integer xian1,
			String status,String goodsname,String shaddress,String shphone,String goodsnum,String weight,String volume,
			String chetype,String chang,String remark,Integer companyid,String data,String compname) throws ParseException{
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 Date myDate = format.parse(data);
		fahRecoreder f=new fahRecoreder();
		//查询手机号看有用户没
		User u=userService.findByphone(fhphone);
		if(u==null){
			User us=new User();
			String city=areservice.GetdByid(xian1).getXname();
			us.setMobile(fhphone);
			us.setName(fhphone);
			us.setPassword(MD5Utils.getMd5Password(fhphone));
			us.setType(4);
			us.setCompanyid(0);
			us.setAddress(city);
			us.setBranchid(xian1);
			us.setDelFlag(0);
			us.setCity(city);
			us.setPermissionid("0");
			us.setHeadimgurl("");
			userService.addUser(us);
			User u1=userService.findByphone(fhphone);
			System.err.println(u1);
			session.setAttribute(Constant.USER_TOKEN, u1);
			f.setUserid(u1.getRid());
			f.setFhuser(fhphone);
		}else{
			session.setAttribute(Constant.USER_TOKEN, u);
			f.setUserid(u.getRid());
			f.setFhuser(u.getName());
		}
		//手机号，
		f.setFhphone(fhphone);
		f.setFhaddress(fhaddress);
		f.setXian1(xian1);
		f.setGoodsname(goodsname);
		f.setShaddress(shaddress);
		//数量
		f.setGoodsnum(goodsnum);
		f.setWeight(weight);
		f.setVolume(volume);
		f.setCompanyId(companyid);
		f.setChang("");
		f.setStatus("已预约");
		f.setRemark("");
		f.setFhaddress1("");
		f.setShaddress1("");
		f.setShuser("");
		f.setShphone(shphone);
		f.setTimeout(myDate);
		f.setChetype("");
		f.setCompname(compname);
		f.setTracking(System.currentTimeMillis()+"");
		fahrecorder.addfOrder(f);
		//		if(redisUtil.hasKey("huoyuan"+xian1)){
		//			redisUtil.del("huoyuan"+xian1);
		//		}
		return new ResponseResult<Integer>(SUCCESS);

	}



	//货源发布页
	@GetMapping("/hyfabuxinxi")
	public String hyfabuxinx(Integer xian1,Model model,String goodname,String fhaddress,String shaddress){
		model.addAttribute("xian1", xian1);
		if(goodname==null)goodname="";
		if(fhaddress==null)fhaddress="";
		if(shaddress==null)shaddress="";
		model.addAttribute("goodname", goodname);
		model.addAttribute("fhaddress", fhaddress);
		model.addAttribute("shaddress", shaddress);
		return "hyfabuxinxi";
	}
	//发布货源信息
	@PostMapping("/addfOrder")
	@ResponseBody
	public ResponseResult<Integer> addfOrder (String fhuser,String shaddress,String fhphone,String fhaddress,Integer xian1,
			String status,String goodsname,
			String goodsnum,String weight,String volume,String chetype,String chang,String remark){
		fahRecoreder f=new fahRecoreder();
		f.setChang(chang);
		f.setChetype(chetype);
		f.setCompanyId(182);
		f.setFhaddress(fhaddress);
		f.setFhphone(fhphone);
		f.setFhuser(fhuser);
		f.setGoodsname(goodsname);
		f.setGoodsnum(goodsnum);
		f.setRemark(remark);
		f.setShaddress(shaddress);
		f.setFhaddress1("");
		f.setShuser("");
		f.setShphone("");
		f.setStatus(status);
		f.setWeight(weight);
		f.setTimeout(new Date());
		f.setVolume(volume);
		f.setXian1(xian1);
		fahrecorder.addfOrder(f);
		if(redisUtil.hasKey("huoyuan"+xian1)){
			redisUtil.del("huoyuan"+xian1);
		}
		return new ResponseResult<Integer>(SUCCESS);

	}
	//货源列表
	@GetMapping("/huoyuan")
	public String po (Integer  xian1,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize,Model model){
		if(pageNum<=0)pageNum=1;
		Page<fahRecoreder> fahrecorderlist=fahrecorder.GetAfdhRecorders(pageNum, pageSize);
		if(fahrecorderlist.size()<8){
			fahrecorderlist=fahrecorder.GetAfdhRecorders(1, pageSize);
		}
		area  sta=areservice.GetdByid(xian1);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		List<xianlu> x=Constant.centers(xian1, sta.getXname());
		model.addAttribute("xianguan", x);
		model.addAttribute("huolist", fahrecorderlist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("sta", sta);
		model.addAttribute("yuming", Constant.yuming);
		return "huoyuan";
	}
	//货源信息
	@GetMapping("/huoinfo")
	public String huoinfo (Integer  xian1,Integer id,Model model){
		fahRecoreder f=fahrecorder.getfaredByid(id);
		area  sta=areservice.GetdByid(xian1);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		Page<company> comlist=companyservice.youzhicom(xian1);
		model.addAttribute("huoinfo", f);
		model.addAttribute("sta", sta);
		model.addAttribute("yzcomps", comlist);
		model.addAttribute("yuming", Constant.yuming);
		return "203/huoinfo";
	}
}
