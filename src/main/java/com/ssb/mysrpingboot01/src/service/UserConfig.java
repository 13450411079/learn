package com.ssb.mysrpingboot01.src.service;

import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@Component
public class UserConfig {


    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public OrderService orderService(){
        System.out.println(userService());
        System.out.println(userService());
        Map<String,OrderService> map=new HashMap<>();
        return new OrderService();
    }

    public static void main(String[] args) {
        UserService u=new UserService();
        OrderService orderService=new OrderService(u);
        ProxyInterface o = (ProxyInterface) Proxy.newProxyInstance(UserService.class.getClassLoader(), UserService.class.getInterfaces(), orderService);
        o.printData();

        Enhancer e=new Enhancer();
        e.setSuperclass(UserService.class);
        e.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.printf("111");
                Object invoke = methodProxy.invokeSuper(o,objects);
                System.out.printf("222");
                Class<?> aClass = Class.forName("com.ssb.mysrpingboot01.src.service.UserService");
                return invoke;
            }
        });
        UserService u1= (UserService) e.create();
        u1.getData("111");

    }
}
class UserService implements ProxyInterface{

    @Override
    public void printData() {
        System.out.println("abc");
    }

    public void getData(String data){
        data="123";
        System.out.println(111);
    }
}

class OrderService implements InvocationHandler {
    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("111");
        Object invoke = method.invoke(target, args);
        System.out.println(222);
        return invoke;
    }
    OrderService(Object target){
        this.target=target;
    }
    OrderService( ){
    }
}
