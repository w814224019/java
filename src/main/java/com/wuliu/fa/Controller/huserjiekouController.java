package com.wuliu.fa.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.wuliu.fa.entity.fahRecoreder;
import com.wuliu.fa.service.IfahRecorederService;
import com.wuliu.fa.util.ResponseResult;
@Controller
public class huserjiekouController extends BaseController{
	@Autowired
	private IfahRecorederService fahrecorder;
	//我的订单接口
	@GetMapping("/myorderlist")
	@ResponseBody
	public ResponseResult<Map> po (Integer  rid,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<fahRecoreder> GetAfdhRecorderByi=fahrecorder.GetAfdhRecorderByi(pageNum, pageSize, rid);
		Map m=new HashMap<String,Object>();
		m.put("myorderlist", GetAfdhRecorderByi);
		return new ResponseResult<Map>(SUCCESS,m);
	}
	//公司的订单接口
	@GetMapping("/comporderlist")
	@ResponseBody
	public ResponseResult<Map> comporderlist (Integer  companyid,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "10",value = "pageSize")Integer pageSize){
		Page<fahRecoreder> GetAfdhRecorderByi=fahrecorder.gethRecorderBycoi(pageNum, pageSize, companyid);
		Map m=new HashMap<String,Object>();
		m.put("comporderlist", GetAfdhRecorderByi);
		return new ResponseResult<Map>(SUCCESS,m);
	}
}
