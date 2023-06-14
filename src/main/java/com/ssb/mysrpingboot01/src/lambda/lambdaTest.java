package com.ssb.mysrpingboot01.src.lambda;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.PipedReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class lambdaTest {


    public static void main(String[] args) throws JsonProcessingException {
        Monkey m1=new Monkey("明明1","data is here!!",10, LocalDateTime.now(),true);
        Monkey m2=new Monkey("明明2","data is here!!",5,LocalDateTime.now(),false);
        Monkey m3=new Monkey("明明3","data is here!!",11,LocalDateTime.now(),true);
        Monkey m4=new Monkey("明明4","data is here!!",10,LocalDateTime.now(),false);
        List<Monkey> list=new ArrayList<>(){{add(m1);add(m2);add(m3);add(m4);}};

        List<Monkey> collect = list.stream().filter(e -> e.getBanana() > 10).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));


        Map<String, Monkey> collect1 = list.stream().collect(Collectors.toMap(Monkey::getName, each -> each));
        System.out.println(JSONObject.toJSONString(collect1));
        Map<String, List<Monkey>> collect2 = list.stream().collect(Collectors.groupingBy(Monkey::getName ));
        System.out.println(JSONObject.toJSONString(collect2));
        Map<String, String> collect3 = list.stream().collect(Collectors.toMap(Monkey::getName,Monkey::getData));
        System.out.println(JSONObject.toJSONString(collect3));

        Map<Integer,List<String>> collect4=list.stream().collect(Collectors.toMap(Monkey::getBanana,each-> Collections.singletonList(each.getName()),(value1,value2)->{
            List<String> union = new ArrayList<>(value1);
            union.addAll(value2);
            return union;
        }));
        System.out.println(JSONObject.toJSONString(collect4));
        Map<Integer,List<String>> collect5=list.stream().collect(Collectors.toMap(Monkey::getBanana,each-> Collections.singletonList(each.getName()),(value1,value2)->value1));
        List<String> u1=new ArrayList<>(Collections.singleton("abc"));
        System.out.println(JSONObject.toJSONString(collect5));
        System.out.println(JSONObject.toJSONString(u1));

        Thread a=new Thread(()->{
            System.out.println(111);
        });

            String str="abc";
        System.out.println(111);
        HashMap

    }


}
@Data
@AllArgsConstructor
class Monkey {

    private String name;
    private String data;
    private Integer banana;
    private LocalDateTime date;
    private Boolean sex;

}
