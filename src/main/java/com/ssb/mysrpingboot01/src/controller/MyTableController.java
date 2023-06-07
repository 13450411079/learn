package com.ssb.mysrpingboot01.src.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-07
 */
@RestController
@RequestMapping("/myTable")
public class MyTableController {

    @GetMapping("test")
    public String data(){
        System.out.println(111);
        return "111";
    }
}
