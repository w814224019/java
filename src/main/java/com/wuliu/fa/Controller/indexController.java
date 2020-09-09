package com.wuliu.fa.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.wuliu.fa.Exception.WarnException;
import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.alist;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.carUser;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.fahRecoreder;
import com.wuliu.fa.entity.goodstype;
import com.wuliu.fa.entity.lgoodstype;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.IcarUserService;
import com.wuliu.fa.service.IfahRecorederService;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.service.goodstypeService;
import com.wuliu.fa.service.xianluService;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.ResponseResult;

@Controller
public class indexController extends BaseController {
	@Autowired
	private IcarUserService caruserService;
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private IfahRecorederService fahrecorder;
	@Autowired
	private goodstypeService gsservice;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private areaService areservice;
	//主页通用方法
	public void tongyong(Integer xian1,Model model){
		//整车 三方 车源 货源 出发地 域名
		Page<company> companylist=new Page<company>();
		//System.err.println(companylist.size());
		if(redisUtil.hasKey("zhengche"+xian1)){
			companylist=(Page<company>) redisUtil.get("zhengche"+xian1);
		}else{
			companylist=companyservice.getBycn(xian1,1, 6, 1);
			if(companylist.size()<6){ 
				companylist=companyservice.getBycn(areservice.GetdByid(xian1).getXiaoxian(),1, 6, 1);
				}
			redisUtil.set("zhengche"+xian1, companylist,43200);
		}
		Page<company> companylist2=new Page<company>();
		
		if(redisUtil.hasKey("sanfang"+xian1)){
			companylist2=(Page<company>) redisUtil.get("sanfang"+xian1);
		}else{
			companylist2=companyservice.getBycn(xian1,2, 6, 1);
			if(companylist2.size()<6){ 
				 companylist2=companyservice.getBycn(areservice.GetdByid(xian1).getXiaoxian(),2, 6, 1);
				}
			redisUtil.set("sanfang"+xian1, companylist2,43200);
		}
		Page<carUser> carUserlist=new Page<carUser>();
		if(redisUtil.hasKey("cheyuan"+xian1)){
			carUserlist=(Page<carUser>) redisUtil.get("cheyuan"+xian1);
		}else{
			carUserlist=caruserService.getcarusers(1, 8);
			redisUtil.set("cheyuan"+xian1, carUserlist,43200);
		}
		Page<fahRecoreder> fahrecorderlist=new Page<fahRecoreder>();
		if(redisUtil.hasKey("huoyuan"+xian1)){
			fahrecorderlist=(Page<fahRecoreder>) redisUtil.get("huoyuan"+xian1);
		}else{
			fahrecorderlist=fahrecorder.GetAfdhRecorders(1, 8);
			redisUtil.set("huoyuan"+xian1, fahrecorderlist,43200);
		}
		model.addAttribute("zhengche", companylist);
		model.addAttribute("sanfang", companylist2);
		model.addAttribute("cheyuan", carUserlist);
		model.addAttribute("huoyuan", fahrecorderlist);
		
		model.addAttribute("xian1", xian1);
		model.addAttribute("yuming", Constant.yuming);
	}
	//分站下面地级市
	@GetMapping("/zongzhan")
	public String zongzhan(Integer xian1,Model model){
		//整车 三方 车源 货源 出发地 域名
		tongyong(xian1, model);
		area  sta=areservice.GetdByid(xian1);
		model.addAttribute("sta", sta);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		return "fenzhan";
	}
	//分站
	@GetMapping("/fenzhan")
	public String fenzhan(Integer shengid,Model model){
		//System.err.println(xian1);
		area sheng=areservice.GetdByid(shengid);
		//Integer xian1=sheng.getXiaoxian();
		//整车 三方 车源 货源 出发地 域名
		tongyong(shengid, model);
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
			redisUtil.set("zongzhan"+shengid, dijishi, 36000);
		}
		area  sta=areservice.GetdByid(shengid);
		model.addAttribute("sta", sta);
		model.addAttribute("dijishi", dijishi);
		model.addAttribute("shname", sheng.getXname());
		return "fenzhan";
	}
	@GetMapping("/")
	public String index(Integer xian1,Model model){
		//System.err.println(xian1);
		if(xian1==null)xian1=6;
		//整车 三方 车源 货源  域名
		tongyong(xian1, model);
		List<area> dijishi=Constant.areas();
		area  sta=areservice.GetdByid(xian1);
		model.addAttribute("sta", sta);
		model.addAttribute("dijishi", dijishi);
		return "index";
	}
	 
	//主页接口
	@GetMapping("/companylist")
	@ResponseBody
	public ResponseResult<Map> po (Integer  xian1){
		Page<company> companylist=companyservice.getBycn(xian1,1, 6, 1);
		Page<company> companylist2=companyservice.getBycn(xian1,2, 6, 1);
		Page<carUser> carUserlist=caruserService.getcarusers(1, 8);
		Page<fahRecoreder> fahrecorderlist=fahrecorder.GetAfdhRecorders(1, 8);
		Map m=new HashMap<String,Object>();
		m.put("zhengche", companylist);
		m.put("sanfang", companylist2);
		m.put("cheyuan", carUserlist);
		m.put("huoyuan", fahrecorderlist);
		System.err.println(m+"公司列表");
		return new ResponseResult<Map>(SUCCESS,m);
	}
	//整车列表页接口
	@GetMapping("/zhlist")
	@ResponseBody
	public ResponseResult<Map> zpo (Integer  xian1,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<company> companylist=companyservice.getBycn(xian1,1, pageSize, pageNum);
		Map m=new HashMap<String,Object>();
		m.put("zhengche", companylist);
		return new ResponseResult<Map>(SUCCESS,m);
	}
	//三方列表页接口
	@GetMapping("/shlist")
	@ResponseBody
	public ResponseResult<Map> spo (Integer  xian1,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		if(pageNum==null)pageNum=4;
		Page<company> companylist=companyservice.getBycnz(xian1, pageSize, pageNum,1);
		Map m=new HashMap<String,Object>();
		m.put("sanfang", companylist);
		return new ResponseResult<Map>(SUCCESS,m);
	}
	//车源列表接口
	@GetMapping("/chlist")
	@ResponseBody
	public ResponseResult<Map> cpo (@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<carUser> carUserlist=caruserService.getcarusers(pageNum, pageSize);
		Map m=new HashMap<String,Object>();
		m.put("cheyuan", carUserlist);
		return new ResponseResult<Map>(SUCCESS,m);
	}
	//货源列表接口
	@GetMapping("/hulist")
	@ResponseBody
	public ResponseResult<Map> hpo (@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<fahRecoreder> fahrecorderlist=fahrecorder.GetAfdhRecorders(pageNum, pageSize);
		Map m=new HashMap<String,Object>();
		m.put("huoyuan", fahrecorderlist);
		return new ResponseResult<Map>(SUCCESS,m);
	}
	//车源信息
	@GetMapping("/chinfo")
	@ResponseBody
	public ResponseResult<Map> cpof (Integer id){
		if(id==null){
			throw new WarnException("缺少参数id");
		}else{
			carUser c=caruserService.getcarUserByi(id);
			Map m=new HashMap<String,Object>();
			m.put("cheinfo", c);
			return new ResponseResult<Map>(SUCCESS,m);
		}
	}
	//货源信息
	@GetMapping("/huinfo")
	@ResponseBody
	public ResponseResult<Map> cpohu (Integer id){
		if(id==null){
			throw new WarnException("缺少参数id");
		}else{
			fahRecoreder f=fahrecorder.getfaredByid(id);
			Map m=new HashMap<String,Object>();
			m.put("huoinfo", f);
			return new ResponseResult<Map>(SUCCESS,m);
		}
	}
	//根据公司名称查找
	@GetMapping("/namelist")
	@ResponseBody
	public ResponseResult<Map> namelist (String  name,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<company> companylist=companyservice.GetBycname(name, pageSize, pageNum);
		Map m=new HashMap<String,Object>();
		m.put("namelist", companylist);
		return new ResponseResult<Map>(SUCCESS,m);

	}
	//获取所有分类
	@GetMapping("/gslist")
	@ResponseBody
	public ResponseResult<Map> gslist (){
		String key = "gslist";
		List<lgoodstype> ddl=new ArrayList<lgoodstype>();
		//有key 返回true
		boolean flag =  redisUtil.hasKey(key);
		// System.err.println(flag);
		if(flag){
			ddl=(List<lgoodstype>) redisUtil.get(key);
		}else{
			ddl=gsservice.GetAllgt();
			redisUtil.set("gslist", ddl,43200);
		}
		Map m=new HashMap<String,Object>();
		m.put("gslist", ddl);
		return new ResponseResult<Map>(SUCCESS,m);

	}



}
