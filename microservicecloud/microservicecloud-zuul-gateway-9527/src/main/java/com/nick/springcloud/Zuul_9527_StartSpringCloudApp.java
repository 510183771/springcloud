package com.nick.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 将zuul项目注册为eureka的微服务，然后在hosts文件中做一个映射"127.0.0.1 myzuul.com"
 * 启动微服务后，通过zuul 网关访问微服务的方式为 http://myzuul.com:9527/microservicecloud-dept/dept/list
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}
}
