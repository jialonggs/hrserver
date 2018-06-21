package org.sang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.github.pagehelper.PageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@SpringBootApplication
@MapperScan("org.sang.mapper")
@EnableScheduling
public class HrserverApplication {


	public static void main(String[] args) {
		SpringApplication.run(HrserverApplication.class, args);
	}
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		p.setProperty("dialect", "mysql");
		p.setProperty("supportMethodsArguments", "false");
		p.setProperty("pageSizeZero", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}


