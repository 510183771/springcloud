package com.nick.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nick.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

/**
 * 为了不在controller中每一个接口写一个相对应的熔断处理方法，让controller专注于业务，这里把熔断的处理方法单独出来
 * 也是了解偶
 */
@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
	@Override
	public DeptClientService create(Throwable throwable)
	{
		return new DeptClientService() {
			@Override
			public Dept get(long id)
			{
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> list()
			{
				return null;
			}

			@Override
			public boolean add(Dept dept)
			{
				return false;
			}
		};
	}
}
