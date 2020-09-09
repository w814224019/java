package com.wuliu.fa.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.pagehelper.Page;
import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.alist;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.goodstype;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.service.goodstypeService;
import com.wuliu.fa.service.xianluService;
import com.wuliu.fa.util.Constant;

@Controller
public class xinglituoyunController {
	@Autowired
	private areaService areservice;
	@Autowired
	private goodstypeService gsservice;
	@Autowired
	private xianluService xianluservice;
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private RedisUtil redisUtil;
	//行李托运一级页
	@GetMapping("/xinglituoyunOne")
	public String xinglituoyunOne(Integer id,Model model,Integer cfd){
		List<alist> v=areservice.GetByxiao();
		//System.err.println(v);
		goodstype d=gsservice.getByid(id);
		area  sta=areservice.GetdByid(cfd);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		List<area> x=Constant.areas();
		//System.err.println(d);
		Page<company> comlist=companyservice.youzhicom(cfd);
		model.addAttribute("v", v);
		model.addAttribute("sheng", x);
		model.addAttribute("gs", d);
		model.addAttribute("sta", sta);
		model.addAttribute("yzcomps", comlist);
		model.addAttribute("yuming", Constant.yuming);
		return "xinglituoyunOne";
	}
	//行李托运二级页
	@GetMapping("/xinglituoyunTow")
	public String xinglituoyunTwo(Integer ddd,Model model,Integer cfd,Integer id){
		List<alist> v=areservice.GetByshengxid(ddd);
		//System.err.println(v);
		area  sta=areservice.GetdByid(cfd);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		area  end=areservice.GetdByid(ddd);
		goodstype d=gsservice.getByid(id);
		Page<company> comlist=companyservice.youzhicom(cfd);
		model.addAttribute("yzcomps", comlist);
		model.addAttribute("sta", sta);
		model.addAttribute("end", end);
		model.addAttribute("gs", d);
		model.addAttribute("v", v);
		model.addAttribute("yuming", Constant.yuming);
		return "xinglituoyunTow";
	}
	//行李托运三级页
	@GetMapping("/xinglituoyunthree")
	public String xinglituoyunthree(Integer cfd,Integer ddd,Model model,Integer id){
		Page<company> companylist=xianluservice.GetcompBycd(1, 8, cfd, ddd);
		if(companylist.size()<8){
			companylist=companyservice.getBycn(cfd,1, 10, 1);
		}
		if(companylist.size()<8){
			companylist=companyservice.getBycn(ddd,1, 10, 1);
		}
		area  sta=areservice.GetdByid(cfd);
		Integer shengid=sta.getShengxid();
		List<area> dijishi=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			dijishi=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			dijishi=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", dijishi);
		area  end=areservice.GetdByid(ddd);
		model.addAttribute("sta", sta);
		model.addAttribute("end", end);
		List<xianlu> x=Constant.centers(cfd, sta.getXname());
		model.addAttribute("xianguan", x);
		model.addAttribute("companylist", companylist);
		//附近线路 下级地区为出发地 参数到达地
		List<xianlu> xl=new ArrayList<xianlu>();
		List<area> alist=areservice.getxia(cfd);
		for (area area : alist) {
			xianlu x1=new xianlu();
			x1.setCfd(area.getId());
			x1.setChufadi(area.getXname());
			x1.setDaodadi(end.getXname());
			x1.setDdd(ddd);
			xl.add(x1);
		}
		model.addAttribute("fujin", xl);
		//周边 省下级地级市为出发地加参数到达地
		List<xianlu> xll=new ArrayList<xianlu>();
		List<area> alists=areservice.getdijishi(cfd, 1);
		for (area area : alists) {
			xianlu x1=new xianlu();
			x1.setCfd(area.getId());
			x1.setChufadi(area.getXname());
			x1.setDaodadi(end.getXname());
			x1.setDdd(ddd);
			xll.add(x1);
		}
		model.addAttribute("zhoubian", xll);
		//System.err.println(xll);
		goodstype d=gsservice.getByid(id);
		model.addAttribute("gs", d);
		Page<company> comlist=companyservice.youzhicom(cfd);
		//System.err.println(comlist);
		model.addAttribute("yzcomps", comlist);
		model.addAttribute("yuming", Constant.yuming);
		return "xinglituoyunthree";
	}

	
	
	
	
	
}
