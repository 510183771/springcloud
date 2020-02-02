package com.nick.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//声明这是一个服务消费的客户端
@EnableEurekaClient

//添加Feign的支持
@EnableFeignClients(basePackages= {"com.nick.springcloud"})
@ComponentScan("com.nick.springcloud")
public class DeptConsumer80_Feign_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
