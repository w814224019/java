package com.wuliu.fa.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.wuliu.fa.config.RedisUtil;
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
public class companylistController extends BaseController {
	@Autowired
	private xianluService xianluservice;
	@Autowired
	private areaService areservice;
	@Autowired
	private goodstypeService gsservice;
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private RedisUtil redisUtil;
	//出发地和到达地查询结果页
	@GetMapping("/complist")
	public String companylists(Integer  cfd,Integer  ddd,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize,Integer id,Model model){
		if(pageNum<=0)pageNum=1;
		if(ddd==null||ddd==0)ddd=266;
		area  sta=areservice.GetdByid(cfd);
		area  end=areservice.GetdByid(ddd);
		//System.err.println(end.getXname());
		Page<company> companylist=new Page<company> ();
		//查询零担
		if(id==1090){
			companylist=xianluservice.GetcompBycd((pageNum-1)*pageSize, pageSize, cfd, ddd);
		}else{
			companylist=companyservice.getBycnz(sta.getXiaoxian(), pageSize, pageNum, 1);
		}
		//System.err.println(companylist.size()<8);
		//System.err.println(sta.getXiaoxian());
		//System.err.println(sta.getShiid());
		if(companylist.size()<8){
			companylist=companyservice.getBycnz(sta.getXiaoxian(), pageSize, pageNum, 0);
			//System.err.println(companylist);
		}
		if(companylist.size()<8){

			companylist=companyservice.getBycnz(sta.getShiid(), pageSize, pageNum, 0);
			//System.err.println(companylist);
		}
		//System.err.println(companylist);
		List<xianlu> x=Constant.centers(cfd, sta.getXname());
		goodstype d=gsservice.getByid(id);
		//周边 省下级地级市为出发地加参数到达地
		Integer shengid=sta.getShengxid();
		List<area> alists=new ArrayList<area>();
		if(redisUtil.hasKey("zongzhan"+shengid)){
			alists=(List<area>) redisUtil.get("zongzhan"+shengid);
		}else{
			alists=areservice.GetByshengxi(shengid, 1);
		}
		model.addAttribute("dijishi", alists);
		List<xianlu> xll=new ArrayList<xianlu>();
		//List<area> alists=areservice.getdijishi(cfd, 1);
		for (area area : alists) {
			xianlu x1=new xianlu();
			x1.setCfd(area.getId());
			x1.setChufadi(area.getXname());
			x1.setDaodadi(end.getXname());
			x1.setDdd(ddd);
			xll.add(x1);
		}
		model.addAttribute("zhoubian", xll);
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
		model.addAttribute("xianguan", x);
		model.addAttribute("companylist", companylist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("sta", sta);
		model.addAttribute("end", end);
		model.addAttribute("gs", d);
		model.addAttribute("xian1", cfd);
		model.addAttribute("yuming", Constant.yuming);
		return "complist";
	}
}
