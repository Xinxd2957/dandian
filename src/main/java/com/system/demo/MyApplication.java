package com.system.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@MapperScan("com.system.demo.mapper")
//排除掉SpringBoot自动装配DataSource的操作exclude={DataSourceAutoConfiguration.class}

@SpringBootApplication(scanBasePackages = {"com.system"})
//@EnableScheduling
//,exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class }
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
