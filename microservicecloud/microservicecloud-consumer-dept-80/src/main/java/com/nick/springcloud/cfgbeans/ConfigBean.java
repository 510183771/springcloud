package com.nick.springcloud.cfgbeans;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
{
	/**
	 * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
	 * 开启负载均衡,默认使用的是轮询算法
	 */
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}


	/**
	 * Spring Cloud Ribbon 为我们提供好几种算法，如果想使用轮询以外的算法，请显示声明我们想使用的其他算法
	 * 如果想让某个微服务使用我们自定义的算法，则
	 * 1。在主启动类中添加注解
	 * 2。编写我们自己的算法
	 * @return
	 */
	@Bean
	public IRule myRule()
	{
		//默认的轮询算法
		//return new RoundRobinRule();

		//随机算法
		//用我们重新选择的随机算法替代默认的轮询。
		return new RandomRule();

		//重试算法：如果所有的微服务都是正常的，使用的是轮询算法，如果其中有部分服务不可用，尝试多次后，如果服务依然不可用，则轮询的
		//的时候会自动跳过失效的微服务
		//return new RetryRule();
	}
}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">