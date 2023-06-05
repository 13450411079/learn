package com.ssb.mysrpingboot01.src;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


//    @Autowired
//    private MyHashTemplate myHashTemplate;

    @GetMapping("/home")
    public String test(){
        return "111";
//        return myHashTemplate.myHash("dachao");
    }
}
