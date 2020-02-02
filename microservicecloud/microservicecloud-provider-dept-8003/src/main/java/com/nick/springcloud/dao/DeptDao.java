package com.nick.springcloud.dao;

import com.nick.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Nick
 * @Date: 2020/1/21 10:43 下午
 * Descriptions: new class
 */
@Component
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
