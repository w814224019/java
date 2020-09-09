package com.wuliu.fa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wuliu.fa.mapper")
public class FaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaApplication.class, args);
	}

}
