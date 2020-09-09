package com.wuliu.fa.Controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayUtil;
import com.wuliu.fa.config.WeChatConfig;
import com.wuliu.fa.entity.PayResult;
import com.wuliu.fa.service.WxOrderService;
import com.wuliu.fa.util.Constant;
import com.wuliu.fa.util.HttpClientUtils;
import com.wuliu.fa.util.ResponseResult;
@Controller

public class weixinzhifuController extends BaseController{
	@Autowired
	private WxOrderService wxOrderService;
	public static boolean isOrderPaid = false;
	 @RequestMapping("/createOrder")
	 @ResponseBody 
	  public ResponseResult<String> generateQRCode(Integer companyid,
	    @RequestParam(value = "total_fee",required = true)Double total_fee) throws Exception {
	        System.out.println("生成微信支付二维码");
	     // 商户订单号
			String out_trade_no = String.valueOf(System.currentTimeMillis());
	        Map<String,Object> paramMap=new HashMap<>();
	        paramMap.put("body","微信扫码支付");
	        paramMap.put("out_trade_no",out_trade_no);
	        paramMap.put("total_fee",total_fee);
	        paramMap.put("attach",companyid+"");
	        //发送请求到微信统一下单api接口
	        String resultJson = HttpClientUtils.doPost(Constant.yuming+"/payOrder", paramMap);
	          System.err.println(resultJson);
	        //将json格式字符串转换成json对象
	        JSONObject jsonObject = JSONObject.parseObject(resultJson);
	        //获取通信标识
	        String return_code = jsonObject.getString("return_code");
	        System.err.println(return_code);
	        //判断通信是否成功
	        String code_url="http://java.56114.com/";
	        if("SUCCESS".equals(return_code)){
	            //获取业务处理结果
	            String result_code = jsonObject.getString("result_code");
	            //判断业务处理结果
	            if("SUCCESS".equals(result_code)){
	                //获取到code_url链接地址
	                 code_url = jsonObject.getString("code_url");
	                //生成二维码图片
	                System.err.println(code_url);
                    
	            }
	        }
	      
	        return new ResponseResult<>(SUCCESS,code_url);

	    }
	
	
	
	@RequestMapping("/payOrder")
	public @ResponseBody Object wxpay(HttpServletRequest request,
			@RequestParam(value = "body",required = true)String body,
			@RequestParam(value = "out_trade_no",required = true)String out_trade_no,
			@RequestParam(value = "attach",required = true)String attach,
			@RequestParam(value = "total_fee",required = true)String total_fee) throws Exception {

		//调用微信统一下单api接口->返回xml格式字符串

		//创建一个map集合的请求参数
		Map<String,String> requestDataMap=new HashMap<>();
		requestDataMap.put("appid","wx59a2a284d7b2b976");
		requestDataMap.put("mch_id","1230932602");
		requestDataMap.put("nonce_str", WXPayUtil.generateNonceStr());
		requestDataMap.put("body",body);
		requestDataMap.put("out_trade_no",out_trade_no);
		requestDataMap.put("attach",attach);
		//将充值金额单位变成分
		BigDecimal bigDecimal=new BigDecimal(total_fee);
		BigDecimal multiply = bigDecimal.multiply(new BigDecimal(100));
		int intValue = multiply.intValue();

		requestDataMap.put("total_fee",String.valueOf(intValue));

		requestDataMap.put("spbill_create_ip",WeChatConfig.SPBILL_CREATE_IP);//cmd->ipconfig查询
		requestDataMap.put("notify_url",Constant.yuming+"/wxpay/order");
		requestDataMap.put("trade_type","NATIVE");
		
		//生成签名值
		String signature = WXPayUtil.generateSignature(requestDataMap, "925c061e870a60c169589ac9813b2039");
		requestDataMap.put("sign",signature);


		//创建一个xml格式的请求参数
		String requestDataXml=WXPayUtil.mapToXml(requestDataMap);

		//调用统一下单api接口
		String responseDataXml = HttpClientUtils.doPostByXml("https://api.mch.weixin.qq.com/pay/unifiedorder", requestDataXml);


		//将统一下单api接口响应的xml格式的字符串转换为map集合
		Map<String, String> responseDataMap = WXPayUtil.xmlToMap(responseDataXml);

		return responseDataMap;
	}
	@RequestMapping(value = "/wxpay/order")
	public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PayResult payResult = wxOrderService.getWxPayResult(request);
		//获取公司id
		String attach=payResult.getAttach();
		
		boolean isPaid = payResult.getReturn_code().equals("SUCCESS") ? true : false;
		
		// 查询该笔订单在微信那边是否成功支付
		// 支付成功，商户处理后同步返回给微信参数
		PrintWriter writer = response.getWriter();
		if (isPaid) {
			System.out.println("================================= 支付成功 =================================");
			
			// ====================== 操作商户自己的业务，比如修改订单状态，生成支付流水等 start ==========================
			// TODO
			this.isOrderPaid = true;
			// ============================================ 业务结束， end ==================================
			
			// 通知微信已经收到消息，不要再给我发消息了，否则微信会8连击调用本接口
			String noticeStr = setXML("SUCCESS", "");
			writer.write(noticeStr);
			writer.flush();
						
		} else {
			System.out.println("================================= 支付失败 =================================");
			
			// 支付失败
			String noticeStr = setXML("FAIL", "");
			writer.write(noticeStr);
			writer.flush();
		}
		
	}
	public static String setXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
	}

}
