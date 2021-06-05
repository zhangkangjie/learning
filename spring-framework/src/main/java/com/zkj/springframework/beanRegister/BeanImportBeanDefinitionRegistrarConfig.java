package com.zkj.springframework.beanRegister;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(MyImportBeanDefinitionRegistrar.class)
@Configuration
public class BeanImportBeanDefinitionRegistrarConfig {

}
