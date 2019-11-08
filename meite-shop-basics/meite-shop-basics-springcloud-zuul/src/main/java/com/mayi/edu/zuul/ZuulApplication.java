package com.mayi.edu.zuul;


import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 微服务网关入口
 */
@SpringBootApplication
@EnableSwagger2Doc
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {

  public  static  void  main(String[] args){
      SpringApplication.run(ZuulApplication.class,args);
  }

   //添加文档来源
    @Primary
   @Component
    class DocumentationConfig implements SwaggerResourcesProvider{


       @Override
       public List<SwaggerResource> get() {
           List list=new ArrayList<>();
           list.add(swaggerResource("app-euerke-member","/app-euerke-member/v2/api-docs","2.0"));
           list.add(swaggerResource("app-euerke-sms","/app-euerke-sms/v2/api-doc","2.0"));
           return list;
       }

       private SwaggerResource swaggerResource(String name,String location,String version){
           SwaggerResource swaggerResource=new SwaggerResource();
           swaggerResource.setName(name);
           swaggerResource.setLocation(location);
           swaggerResource.setSwaggerVersion(version);
           return swaggerResource;
       }

   }





}
