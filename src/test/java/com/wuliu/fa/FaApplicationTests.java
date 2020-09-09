package com.wuliu.fa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import com.wuliu.fa.util.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FaApplicationTests {

	@Test
	public void contextLoads() {
		//System.err.println(DigestUtils.md5DigestAsHex("123456".getBytes()).toUpperCase());
		//System.err.println(Constant.centers(6, "郑州"));

	}

}
