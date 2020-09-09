package com.wuliu.fa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wuliu.fa.entity.company;
import com.wuliu.fa.mapper.CompanyMapper2;
import com.wuliu.fa.mapper.UserMapper;
import com.wuliu.fa.mapper.areaMapper;
import com.wuliu.fa.mapper.carUserMapper;
import com.wuliu.fa.mapper.fahRecorederMapper;
import com.wuliu.fa.mapper.goodstypeMapper;
import com.wuliu.fa.mapper.xianluMapper;
import com.wuliu.fa.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class mappertest {
	@Autowired
	IUserService userm1;
	
	@Autowired
	CompanyMapper2 comp;
	@Autowired
	UserMapper userm;
	@Autowired
	carUserMapper carm;
	@Autowired
	fahRecorederMapper fa;
	@Autowired
	xianluMapper xm;
	@Autowired
	areaMapper xlar;
	@Autowired
	goodstypeMapper xlars;
	@Test
	public void contextLoadsd2() {
		System.err.println(comp.Upcomorder(System.currentTimeMillis(),9, 182));
		//System.err.println(comp.findbyname("聚时"));
//		company p=new company();
//		p.setCtoname("聚时物流");
//		p.setHylx(0);
//		p.setLianxiren("张三");
//		p.setLianxitel("13313333333");
//		p.setWx("55442154");
//		p.setLitpic("");
//		p.setPassword("123");
//		p.setQianming("聚时");
//		p.setSheng1(19);
//		p.setTel("03171122111");
//		p.setXian1(6);
//		p.setXiancn("郑州");
//		p.setContent("");
//		p.setXianlustr("");
//		p.setXxaddress("郑州市二七区");
//		p.setYwms("大车");
//		p.setZhengche(0);
//		p.setShengm("河南");
//		System.err.println(comp.addCompany(p));
		//System.err.println();
		//System.err.println(fa.findhRecorderBycoi(182));
		//System.err.println(userm.findByphone("15515559623"));
//		User u=new User();
//		u.setAddress("");
//		u.setBranchid(6);
//		u.setCity("郑州");
//		u.setCompany("");
//		u.setCompanyid(0);
//		u.setDelFlag(0);
//		u.setHeadimgurl("");
//		u.setMobile("15515559622");
//		u.setName("15515559622");
//		u.setPassword("15515559622");
//		u.setPermissionid("0");
//		u.setType(4);
//		System.err.println(userm.addNewUser(u));
		//System.err.println(comp.findxings(182));
		
//		fahRecoreder f=new fahRecoreder();
//		f.setChang("3m");
//		f.setChetype("平板车");
//		f.setCompanyId(182);
//		f.setFhaddress("郑州");
//		f.setFhaddress1("新密");
//		f.setFhphone("15515559622");
//		f.setFhuser("测试");
//		f.setGoodsname("水");
//		f.setRemark("慢");
//		f.setShaddress("");
//		f.setShuser("");
//		f.setShphone("");
//		f.setStatus("长期");
//		f.setTimeout(new Date());
//		f.setVolume("3");
//		f.setXian1(6);
//		Integer a=fa.addOrder(f);
//		System.err.println(a);
//		carUser v=new carUser();
//		v.setCarLicense("888888");
//		v.setChang("8米");
//		v.setCity("郑州");
//		v.setDestination("山东");
//		v.setPicturePath("ddddddd");
//		v.setRemark("新加");
//		v.setUserid(6);
//		v.setStatus("长期");
//		v.setType("平板车");
//		v.setPhone("15515559622");
//		v.setXian1(6);
//		System.err.println(carm.add(v));
		//System.err.println(xlar.findByshengxi(2397, 1));
		//System.err.println(xlar.findByxiao(6, 2));
		
		
		
		/*List<goodstype> l=xlars.ngdfind(0);
		//System.err.println(l);
		List<lgoodstype> ddl=new ArrayList<lgoodstype>();
		for (goodstype goodstype : l) {
			List<goodstype> dl=xlars.ngdfind(goodstype.getId());
			//System.err.println(dl);
			lgoodstype ls=new lgoodstype();
			ls.setId(goodstype.getId());
			ls.setName(goodstype.getName());
			ls.setPinyin(goodstype.getPinyin());
			ls.setSlist(dl);
			ls.setTypeid(goodstype.getTypeid());
			ddl.add(ls);
		}
		System.err.println(ddl);*/
		//System.err.println(comp.findBycname("立强"));
		//System.err.println(xlar.findByid(6));
		//System.err.println(xlar.findxia(6));
		//System.err.println(xlar.finddijishi(6, 1));
		//System.err.println(xm.findBykey("郑州上海"));
		//System.err.println(xm.findBycd(6, 2385,1,10));
	}
	@Test
	public void contextLoads2() {
		//List<company> coml=comp.findAll();
		//System.err.println(coml);
		//Integer a=comp.updateBatch1(coml);
      // System.err.println(a);
		//System.err.println(carm.findAcarUserByi(1));
		//System.err.println(comp.findBycnz(6));
		//System.err.println(comp.findByid(182));
		//System.err.println(carm.findcarusers());
	}
	@Test
	public void contextLoads1() {
//		User u=userm.findByUserName("liqiang");
//		u.setPassword("1234567");
//		Integer a=userm1.UpdateUserInfo(u, u.getRid());
//		System.err.println(a);
	}
	
	
	
	
	@Test
	public void contextLoads() {
		//System.err.println(userm.findByUserName("liqiang"));
//		User u=userm.findByUserName("liqiang");
//		u.setPassword("123456");
//	Integer a=	userm.updateUser(u.getName(), u.getCompanyid(), u.getMobile(), u.getPermissionid(),
//				"123456", u.getAddress(), u.getHeadimgurl(), u.getDelFlag(),u.getRid());
//	System.err.println(a);
	}
	/*@Test
	public void contextLoads() {
	    List<User>u=new ArrayList<User>();
		List<company>l=comp.findAll();
		for (company company : l) {
			User u1=new User();
			u1.setMobile(company.getLianxitel());
			u1.setAddress(company.getXxaddress());
			u1.setBranchid(company.getXian1());
			u1.setCity(company.getXiancn());
			u1.setPermissionid(0+"");
			u1.setCompany(company.getCtoname());
			u1.setName(company.getUsername());
			u1.setPassword(company.getPassword());
			u1.setCompanyid(company.getId());
			u1.setHeadimgurl(company.getLitpic());
			u1.setAdd_time(new Date());
			u1.setType(1);
			u1.setDelFlag(0);
			u.add(u1);
		}
		Integer a=userm.addPathers(u);
		//Integer a=comp.addPathers(l);
		System.err.println(a);
	}
*/
}
