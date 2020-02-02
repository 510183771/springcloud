package com.nick.springcloud;

import com.nick.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//import com.nick.myrule.MySelfRule;

@SpringBootApplication

//声明这是一个服务消费的客户端
@EnableEurekaClient

/**
 * 1.在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
 *
 * 2.自定义的算法类不能放在主启动类的包下以及其子包下，否则所有的算法都会使用
 * 这个自定义的算法，这里，我们只想让dept 这个微服务运用自定义的算法
 */
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
public class DeptConsumer80_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
