package com.wuliu.fa.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.wuliu.fa.Exception.WarnException;
import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.company;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.CompanyService;
import com.wuliu.fa.service.areaService;
import com.wuliu.fa.service.xianluService;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.ResponseResult;

@Controller
public class chaxunController extends BaseController{
	@Autowired
	private xianluService xianluservice;
	@Autowired
	private areaService areservice;
	@Autowired
	private CompanyService companyservice;
	//出发地和到达地查询列表接口
	@GetMapping("/cdlist")
	@ResponseBody
	public ResponseResult<Map> po (Integer  cfd,Integer ddd,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Map m=new HashMap<String,Object>();
		if(cfd ==null){
			throw new WarnException("出发地id为空");
		}
		if(ddd==null){
			throw new WarnException("到达地id为空");
		}
		m.put("pageNum", pageNum);
		Page<company> companylist=xianluservice.GetcompBycd(pageNum, pageSize, cfd, ddd);
		if(companylist.isEmpty()){
			companylist=companyservice.getBycn(cfd,1, 10, 1);
		}
		if(companylist.isEmpty()){
			companylist=companyservice.getBycn(ddd,1, 10, 1);
		}
		String  sta=areservice.GetdByid(cfd).getXname();
		String  end=areservice.GetdByid(ddd).getXname();
		//Page<company> companylist=xianluservice.getcompBykey(pageNum, pageSize, sta+end);
		List<xianlu> x=Constant.centers(cfd, sta);
		m.put("xianguan", x);
		m.put("companylist", companylist);
		//附近线路 下级地区为出发地 参数到达地
		List<xianlu> xl=new ArrayList<xianlu>();
		List<area> alist=areservice.getxia(cfd);
		for (area area : alist) {
			xianlu x1=new xianlu();
			x1.setCfd(area.getId());
			x1.setChufadi(area.getXname());
			x1.setDaodadi(end);
			x1.setDdd(ddd);
			xl.add(x1);
		}
		m.put("fujin", xl);
		//周边 省下级地级市为出发地加参数到达地
		List<xianlu> xll=new ArrayList<xianlu>();
		List<area> alists=areservice.getdijishi(cfd, 1);
		for (area area : alists) {
			xianlu x1=new xianlu();
			x1.setCfd(area.getId());
			x1.setChufadi(area.getXname());
			x1.setDaodadi(end);
			x1.setDdd(ddd);
			xll.add(x1);
		}
		m.put("zhoubian", xll);
		System.err.println(m+"公司列表");
		return new ResponseResult<Map>(SUCCESS,m);
	}




}
