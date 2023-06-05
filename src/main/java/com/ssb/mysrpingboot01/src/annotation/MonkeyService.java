package com.ssb.mysrpingboot01.src.annotation;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@MonkeyChao
public class MonkeyService {

    public void showData(){
        System.out.println("monkey");
    }

//    ImportBeanDefinitionRegistrar
}
