package com.ssb.mysrpingboot01.src.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssb.mysrpingboot01.src.entity.MyTable;
import com.ssb.mysrpingboot01.src.service.IMyTableService;
import com.zaxxer.hikari.HikariDataSource;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private IMyTableService myTableService;
//    @Autowired
//    private MyHashTemplate myHashTemplate;

    @GetMapping("/home")
    @ApiOperation("TEST!!")
    public String test(){
        List<Map<String, Object>> maps = template.queryForList("select * from my_table");
        myTableService.list(new QueryWrapper<MyTable>().eq("id", 1));
        return "111";
//        return myHashTemplate.myHash("dachao");
    }
//    @PostConstruct
    public void queryDatabase(){
        List<Map<String, Object>> maps = template.queryForList("select * from my_table");
        myTableService.list(new QueryWrapper<MyTable>().eq("id", 1));
        System.out.println(111);
    }
}
