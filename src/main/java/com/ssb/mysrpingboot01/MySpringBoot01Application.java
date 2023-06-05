package com.ssb.mysrpingboot01;

import com.ssb.mysrpingboot01.src.annotation.MapperAutoCon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperAutoCon
public class MySpringBoot01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MySpringBoot01Application.class, args);
        System.out.println((String) run.getBean("monkeyService").toString());
//        ConfigurationClassPostProcessor
//                ImportBeanDefinitionRegistrar
//        ImportSelector
    }

}
