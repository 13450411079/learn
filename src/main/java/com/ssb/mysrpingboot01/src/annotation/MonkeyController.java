package com.ssb.mysrpingboot01.src.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("co1")
@RequestMapping("/monkey")
public class MonkeyController {


    @MonkeyChao
    @GetMapping("/getInfo")
    public String getAnnotationInfo(@RequestParam(required = false) String data){
        System.out.printf(data);
        return data;
    }


}
