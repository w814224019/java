package com.wuliu.fa.util;


import org.springframework.util.DigestUtils;

public  class MD5Utils {
	//生成盐值
	public  static String getMd5Password(String Srcpassword){
		String	str=DigestUtils.md5DigestAsHex(Srcpassword.getBytes()).toUpperCase();
		return str;
	}
}
