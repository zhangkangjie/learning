package com.zkj.springframework.beanRegister;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class BeanConfig {
    @Bean
    public Person personBean(){
        Person person = new Person();
        person.setName("tom");
        return person;
    }

    @Bean
    public PersonFactoryBean person(){
        return new PersonFactoryBean();
    }

}
    