package com.wuliu.fa.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wuliu.fa.Exception.WarnException;
import com.wuliu.fa.annonation.Log;
import com.wuliu.fa.config.RedisUtil;
import com.wuliu.fa.entity.Companier;
import com.wuliu.fa.entity.User;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.compxingx;
import com.wuliu.fa.entity.goodstype;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.IUserService;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.service.goodstypeService;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.ResponseResult;


@Controller
public class CompanyController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private areaService areservice;
	@Autowired
	private goodstypeService gsservice;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	IUserService userService;
	//物流币刷新接口
	@PostMapping("/wxbiup")
	@ResponseBody
	@Log("物流币刷新")
	public ResponseResult<Integer> wxbiup (Integer id){
		company c=companyservice.getById(id);
		Integer wlbi=c.getWlbi();
		if(wlbi<=0){
			wlbi=0;
			throw new WarnException("物流币不足，请及时充值");
		}else{
			wlbi=wlbi-1;
		}
		companyservice.IUpcomorder(id, wlbi);
		return new ResponseResult<Integer>(SUCCESS);
	}
	//根据公司名称查找
	@GetMapping("/fconame")
	public String fconame (Integer  xian1,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize,Model model,Integer id,String name){
		Page<company> companylist=companyservice.GetBycname(name, pageSize, pageNum);
		if(companylist.size()==0){
			companylist=companyservice.getBycnz(xian1, pageSize, pageNum,0);	
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
		if(id==null)id=484;
		goodstype d=gsservice.getByid(id);
		List<xianlu> x=Constant.centers(xian1, sta.getXname());
		model.addAttribute("xianguan", x);
		model.addAttribute("companylist", companylist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("xian1", xian1);
		model.addAttribute("sta", sta);
		model.addAttribute("gs", d);
		model.addAttribute("yuming", Constant.yuming);
		return "dajian";

	}


	//公司主页
	@GetMapping("/gonsimoban")
	public String co(Integer  id,Model model){
		company c=companyservice.getById(id);
		List<compxingx> xings=companyservice.Getxings(id);
		model.addAttribute("xings", xings);
		model.addAttribute("company", c);
		model.addAttribute("yuming", Constant.yuming);
		return "company/gonsimoban";
	}
	//大件运输
	@GetMapping("/dajianyunshu")
	public String dajianyunshu(Integer  id,Model model){
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("yuming", Constant.yuming);
		return "company/dajianyunshu";
	}
	//公路运输
	@GetMapping("/gongluyunshu")
	public String gongluyunshu(Integer  id,Model model){
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("yuming", Constant.yuming);
		return "company/gongluyunshu";
	}
	//关于我们
	@GetMapping("/guanyuwomen")
	public String guanyuwomen(Integer  id,Model model){
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("yuming", Constant.yuming);
		return "company/guanyuwomen";
	}
	//回程运输
	@GetMapping("/huichengyunshu")
	public String huichengyunshu(Integer  id,Model model){
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("yuming", Constant.yuming);
		return "company/huichengyunshu";
	}
	//联系我们
	@GetMapping("/lianxiwomen")
	public String lianxiwomen(Integer  id,Model model){
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("yuming", Constant.yuming);
		return "company/lianxiwomen";
	}
	//业务范围
	@GetMapping("/yiwufanwei")
	public String yiwufanwei(Integer  id,Model model){
		company c=companyservice.getById(id);
		model.addAttribute("company", c);
		model.addAttribute("yuming", Constant.yuming);
		return "company/yiwufanwei";
	}

	//根据公司id获取公司详情接口
	@GetMapping("/companyinfo")
	@ResponseBody
	public ResponseResult<company> po (Integer  id){
		company c=companyservice.getById(id);
		//System.err.println("公司详情"+c);
		return new ResponseResult<company>(200,c);
	}
	//伪静态零担公司列表
	@GetMapping("/zh")
	public String companylist(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Integer  xian1,Integer  zhengche,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<company> companylist=companyservice.getBycn(xian1,1, pageSize, pageNum);
		System.err.println("公司列表"+companylist);
		PageInfo<company> pageInfo = new PageInfo<company>(companylist);
		model.addAttribute("pageInfo",pageInfo);
		return "companylist";
	}
	//伪静态零担公司列表
	@GetMapping("/sh")
	public String scompanylist(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Integer  xian1,Integer  zhengche,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<company> companylist=companyservice.getBycnz(xian1, pageSize, pageNum,1);
		System.err.println("三方货代公司"+companylist);
		PageInfo<company> pageInfo = new PageInfo<company>(companylist);
		model.addAttribute("pageInfo",pageInfo);
		return "companylist2";
	}

	@PostMapping("/addalis")
	@ResponseBody
	public ResponseResult<List<Companier>> addalis(){
		List<Companier> d=companyservice.findAllCompany();
		log.error("CompanyController");
		return new ResponseResult<List<Companier>>(200,d);
	}

}
