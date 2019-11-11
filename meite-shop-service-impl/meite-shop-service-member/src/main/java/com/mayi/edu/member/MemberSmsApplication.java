package com.mayi.edu.member;


import com.spring4all.swagger.EnableSwagger2Doc;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@MapperScan("com.mayi.edu.member.dao")
public class MemberSmsApplication {

    public  static  void  main(String[] args){
        SpringApplication.run(MemberSmsApplication.class,args);
    }
}
