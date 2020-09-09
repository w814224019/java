package com.wuliu.fa.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wuliu.fa.entity.area;
import com.wuliu.fa.entity.xianlu;
import com.wuliu.fa.service.areaService;

/**
 * 描述: 全局常量
 *      1. USER_TOKEN 用户认证的键，用来匹配http session中的对应userId；
 *    
 * @author Kanarien 
 * @version 1.0
 * @date 2018年5月18日 下午9:17:35
 */
public class Constant {
    
	public static final String yuming = "http://localhost:10002";
    public static final String USER_TOKEN = "userId";
    public static final String[] cityArray={
    		"北京_266","天津_685","石家庄_12","太原_826","呼和浩特_123","沈阳_173","长春_165","哈尔滨_111",
			"上海_2385","南京_11","杭州_156","合肥_142","福州_135","南昌_9","济南_2274","郑州_6","武汉_8",
			"长沙_1","广州_552","深圳_566","东莞_2214","南宁_103","海南_36417","重庆_1443","成都_76","贵阳_44",
			"昆明_4","西安_39","兰州_34","西宁_2039","银川_2082","拉萨_43","乌鲁木齐_18"};
   //相关线路 31地级市为到达地
    public static List<xianlu> centers(Integer cfd,String sta){
    	List<xianlu> xianlulist=new ArrayList<xianlu>();
    	for (String string : cityArray) {
			String arr[]=string.split("_");
			xianlu x=new xianlu();
			x.setCfd(cfd);
			x.setChufadi(sta);
			x.setDaodadi(arr[0]);
			x.setDdd(Integer.parseInt(arr[1]));
			xianlulist.add(x);
		}
    	return xianlulist;
    }
    public static final String[] cityArray1={
    		"北京_266","天津_685","上海_2385","重庆_1443","河北_36405","山西_36407","内蒙古_36426","辽宁_36410","吉林_36404",
			"黑龙江_36427","江苏_36403","浙江_36412","安徽_36413","福建_36415","江西_36414","山东_36409","河南_2397",
			"湖北_36406","湖南_36416","广东_36411","广西_3083","海南_36417","四川_36419","贵州_36418",
			"云南_36420","陕西_36421","甘肃_36422","青海_36423","宁夏_36424","西藏_36408","新疆_36425"};
    public static List<area> areas(){
    	List<area> xianlulist=new ArrayList<area>();
    	for (String string : cityArray1) {
			String arr[]=string.split("_");
			area a=new area();
			a.setXname(arr[0]);
			a.setId(Integer.parseInt(arr[1]));
			xianlulist.add(a);
		}
    	return xianlulist;
    } 
    
    public static String getRandomNumber(int count) {
        String[] arr={"0","1","2","3","4","5","6","7","8","9"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<count;i++){
            int index= (int) Math.round(Math.random()*9);
            sb.append(arr[index]);
        }
        return sb.toString();
    }
    
    public static String getRandomstr(int n) {
		String str="";
		//int n=3;//这个值可以改变的，对应的生成多少个字母
		for(int i=0;i<n;i++){
			str= str+(char) (Math.random ()*26+'A');
		}
           return str;
	}
    
}
