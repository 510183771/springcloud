package com.nick.springcloud.controller;

import com.nick.springcloud.entities.Dept;
import com.nick.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController
{
	@Autowired
	private DeptService service = null;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	/**
	 * 由于依赖已经停用，新的用法需要重新看文档
	 * 这种用法有个不好的地方，就是每写一个接口，都要写一个相对应的处理方法，建议根据aop的思想，把熔断的处理代码单独抽出来
	 * 实现FallbackFactory 接口
	 */

	//@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id)
	{

		Dept dept = this.service.get(id);

		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}

		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id)
	{
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
}
