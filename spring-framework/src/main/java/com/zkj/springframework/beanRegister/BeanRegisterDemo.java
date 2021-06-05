package com.zkj.springframework.beanRegister;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

/**
 * Bean
 */
public class BeanRegisterDemo {

    @Test
    public void xmlBased(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Object person = context.getBean("com.zkj.springframework.beanRegister.Person");
        System.out.println(person);
    }



    @Test
    public void myComponentAnnotation(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.zkj.springframework.beanRegister");
        Object person = context.getBean("myComponentPerson");
        System.out.println(person);
    }

    @Test
    public void beanConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Object person = context.getBean("personBean");
        System.out.println(person);
    }

    @Test
    public void beanFactory(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Object person = context.getBean("person");
        Object personFactory = context.getBean(BeanFactory.FACTORY_BEAN_PREFIX+"person");
        System.out.println(person);
        System.out.println(personFactory);
    }


    @Test
    public void beanImportConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanImportConfig.class);
        Object person = context.getBean("com.zkj.springframework.beanRegister.Person");
        System.out.println(person.getClass());
    }

    @Test
    public void beanImportSelectorConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanImportSelectorConfig.class);
        Object person = context.getBean("com.zkj.springframework.beanRegister.Person");
        System.out.println(person);
    }

    @Test
    public void beanImportBeanRegistrarConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanImportBeanDefinitionRegistrarConfig.class);

        Object person = context.getBean("person");
        System.out.println(person);
    }






}
