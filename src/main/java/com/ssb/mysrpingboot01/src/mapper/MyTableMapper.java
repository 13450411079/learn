package com.ssb.mysrpingboot01.src.mapper;

import com.ssb.mysrpingboot01.src.entity.MyTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.mapper.MapperFactoryBean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-06-07
 */
public interface MyTableMapper extends BaseMapper<MyTable> {
//    MapperFactoryBean

    List<MyTable> getList();
}
