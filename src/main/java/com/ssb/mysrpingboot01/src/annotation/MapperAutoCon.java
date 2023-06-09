package com.ssb.mysrpingboot01.src.annotation;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MapperAutoConfigureRegistrar.class)
public @interface MapperAutoCon {

}
