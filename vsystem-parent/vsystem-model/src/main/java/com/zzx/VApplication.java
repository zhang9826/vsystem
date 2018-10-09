package com.zzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author zzx
 *
 * @date 2018年10月9日
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zzx.model.dao","com.zzx.system.dao"})
public class VApplication {
	public static void main(String[] args) {
		SpringApplication.run(VApplication.class, args);
	}
}
