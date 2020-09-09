package com.wuliu.fa.config;


/**
 * 
 * @Title: Config.java
 * @Package com.sihai.wx.util
 * @Description: 微信支付的一些参数配置
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年8月31日 下午2:54:50
 * @version V1.0
 */
public class WeChatConfig {
	
	public static final String APPID = "wx59a2a284d7b2b976";						// 公众账号ID
	public static final String MCH_ID = "1230932602";						// 商户号
	public static final String KEY = "925c061e870a60c169589ac9813b2039";		// 商户密钥
	
	// APP和网页支付提交用户端ip, Native支付填调用微信支付API的机器IP, 即：服务器ip地址
	public static final String SPBILL_CREATE_IP = "180.76.133.145";
	public static final String SPBILL_CREATE_IP1 = "192.168.31.88";
	// 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。（需要配置）
	public static final String NOTIFY_URL = "java.56114.com/wxpay/order";
	// 支付方式，取值如下：JSAPI，NATIVE，APP
	public static final String TRADE_TYPE = "NATIVE";
	
	// 微信支付 - 统一下单地址
	public static final String PLACEANORDER_URL = "https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";
	
}
