package com.ssb.mysrpingboot01.src.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-06-09
 */
@TableName("my_second_table")
@ApiModel(value = "MySecondTable对象", description = "")
public class MySecondTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer age;

    private String name;

    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MySecondTable{" +
            "id = " + id +
            ", age = " + age +
            ", name = " + name +
            ", updateTime = " + updateTime +
        "}";
    }
}
