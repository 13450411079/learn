package com.ssb.mysrpingboot01.src.service.impl;

import com.ssb.mysrpingboot01.src.entity.MyTable;
import com.ssb.mysrpingboot01.src.mapper.MyTableMapper;
import com.ssb.mysrpingboot01.src.service.IMyTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-07
 */
@Service
public class MyTableServiceImpl extends ServiceImpl<MyTableMapper, MyTable> implements IMyTableService {

}
