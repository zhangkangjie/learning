package com.zkj.springframework.beanRegister;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(Person.class)
@Configuration
public class BeanImportConfig {

}
