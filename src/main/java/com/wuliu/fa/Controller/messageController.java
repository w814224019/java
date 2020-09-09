package com.wuliu.fa.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.ResponseResult;
import com.wuliu.fa.util.SmsUtil;


@RestController
public class messageController extends BaseController{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	//预约发货短信
	@PostMapping( "/smsXxs")
	@ResponseBody
    public ResponseResult<Map<String,Object>> smsXxs(String phone) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>(16);
        // 验证码（指定长度的随机数）
        String code = Constant.getRandomNumber(4);
        log.info(code);
        String templateParam = "{\"code\":\""+code+"\"}";
        SendSmsResponse response = SmsUtil.sendSms(phone, templateParam);
        map.put("verifyCode",code);
        map.put("phone",phone);
        if( response.getCode().equals("OK")) {
            map.put("status","短信发送成功");
        } else {
            map.put("isOk","false");
        }
        return new ResponseResult<Map<String,Object>>(SUCCESS,map);
    }
}
