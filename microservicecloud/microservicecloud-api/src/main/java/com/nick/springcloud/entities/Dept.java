package com.nick.springcloud.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author: Nick
 * @Date: 2020/1/16 10:46 下午
 * Descriptions: new class
 */
@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {
    // 主键
    private Long 	deptno;

    // 部门名称
    private String 	dname;

    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String 	db_source;

    public Dept(String dname)
    {
        super();
        this.dname = dname;
    }

}
